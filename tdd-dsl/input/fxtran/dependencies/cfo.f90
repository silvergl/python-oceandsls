MODULE cfo
  USE lambert
  IMPLICIT NONE
  PRIVATE
  PUBLIC :: ft_ME, nprey
  INTEGER, PARAMETER :: dp=KIND(0D0)
  INTEGER :: nprey=4
  REAL(dp), PARAMETER :: cfds=86.4D3
  INCLUDE 'stdunits.h'

  TYPE, PUBLIC :: ocf
     REAL(dp) :: ngr,&          ! relative growth rate
          Imax=1D0,&            ! max. specific ingestion rate (1/d)
          Rm=0.05D0,&           ! specific maintenance respiration (1/d)
          beta=0.2D0,&          ! digestion (assimilation) coefficient
          ca=0.1D0, cf=0.1D0,&  ! cost of assimilation, foraging coefficients
          Emax=1D0,&            ! max. assimilation efficiency
          gbio, geZ, gamma1, kzoo,&
          Af,&                  ! foraging activity
          At,&                  ! total activity
          IC, IN, IP,&          ! C, N, P ingestion
          E,&                   ! assimilation efficiency
          g,&                   ! net growth rate
          POC, PON, POP,&       ! zooplankton biomass concentration
          RC, RN, RP,&          ! respiration
          XC,&                  ! C excretion
          XN,&                  ! N excretion
          XP,&                  ! P excretion
          QN=0.15D0,&           ! N:C ratio (mol/mol)
          QP=0.0095D0,&         ! P:C ratio (mol/mol)
          Pth,&                 ! feeding threshold
          morq, mort            ! quadratic mortality (m3/mmolC/d)
     REAL(dp), DIMENSION(:), ALLOCATABLE :: phi,& ! prey capture coefficients (m3/molC)
          pref,&
          pI                    ! partial ingestion of each prey
     PROCEDURE(REAL(dp)), POINTER, NOPASS :: fT
     PROCEDURE(foraging), POINTER :: forage
     PROCEDURE(loss), POINTER :: regex
   CONTAINS
     PROCEDURE :: read => read_cfo
  END TYPE ocf

  ABSTRACT INTERFACE
     SUBROUTINE foraging (zoo, preyC, preyN, preyP, bct, bctz)
       IMPORT :: ocf
       IMPLICIT NONE
       CLASS(ocf), INTENT(INOUT) :: zoo
       REAL(KIND(0D0)), INTENT(IN) :: preyC(:), preyN(:), preyP(:), bct, bctz
     END SUBROUTINE foraging
     SUBROUTINE loss (zoo, Rm, fQ)
       IMPORT :: ocf
       IMPLICIT NONE
       CLASS(ocf), INTENT(INOUT) :: zoo
       REAL(KIND(0D0)), INTENT(IN) :: Rm, fQ
     END SUBROUTINE loss
  END INTERFACE

  TYPE(ocf), DIMENSION(:), ALLOCATABLE, PUBLIC :: zoo

CONTAINS

  ! read_param (zoo%read): read zooplankton parameters from namelist cfo
  ! Rm, Imax entered in 1/d,     converted here to 1/s
  ! phi      entered in m3/molC, converted here to m3/mmmolC
  ! all others are dimensionless
  ! forage can be used to enforce either 'UVic' or 'cfo' grazing
  SUBROUTINE read_cfo (zoo, lun, nprey, pf)
    IMPLICIT NONE
    CLASS(ocf), INTENT(INOUT) :: zoo
    INTEGER, INTENT(IN) :: lun, nprey
    LOGICAL, INTENT(IN) :: pf
    CHARACTER(LEN=10) :: ftz, forage, regex
    REAL(dp) :: beta, ca, cf, Emax, Imax, Rm, QN, QP, morq, morq0
    REAL(dp), DIMENSION(nprey) :: phi
    NAMELIST /cfo/ beta, ca, cf, Emax, phi, Imax, Rm, QN, QP, morq,&
         ftz, forage, regex
    ALLOCATE (zoo%phi(nprey), zoo%pref(nprey), zoo%pI(nprey))
    beta = zoo%beta
    ca = zoo%ca
    cf = zoo%cf
    Emax = zoo%Emax
    phi = 0D0
    Imax = zoo%Imax
    Rm = zoo%Rm
    QN = zoo%QN
    QP = zoo%QP
    morq0 = zoo%morq
    morq = -1D0
    ftz = 'bctz'
    regex = 'respire'
    forage = ''
    READ (lun, NML=cfo, END=100)
    zoo%beta = beta
    zoo%ca = ca
    zoo%cf = cf
    zoo%Emax = Emax
    zoo%phi = phi*1D-3          ! convert m3/molC to m3/mmolC
    zoo%Imax = Imax/cfds        ! convert 1/d     to 1/s
    zoo%Rm = Rm/cfds            ! convert 1/d     to 1/s
    zoo%QN = QN
    zoo%QP = QP
    zoo%morq = MAX(morq, 0D0)/cfds
    zoo%At = zoo%Imax/zoo%beta &                     ! total activity       (15)
         *(-1D0 - lwm1(-(1D0 - zoo%cf/zoo%Emax/(1D0 - zoo%ca))/EXP(1D0 + zoo%beta)))
    zoo%Pth = -LOG((1D0 - zoo%cf/zoo%Emax/(1D0 - zoo%ca))) ! /zoo%phi
    IF (LEN_TRIM(forage).EQ.0) forage = 'ocf'
100 CONTINUE
    SELECT CASE (TRIM(ftz))
    CASE ('bct')
       zoo%fT => ftz_bct
    CASE ('bctz')
       zoo%fT => ftz_bctz
    CASE DEFAULT
       STOP 'cfo_read_param: Invalid setting for ftz in namelist cfo.'
    END SELECT
    SELECT CASE (TRIM(forage))
    CASE ('ocf', 'cfo')
       zoo%forage => forage_cfo
    CASE ('UVic', '', 'H2', 'Holling 2', 'Holling II')
       IF (morq.LT.0D0) zoo%morq = morq0*zoo%QN/cfds ! -> UVic default in m3/mmolN/s
       zoo%gbio = zoo%gbio/cfds
       zoo%forage => forage_UVic
    CASE ('H3', 'Holling 3', 'Holling III')
       IF (morq.LT.0D0) zoo%morq = morq0*zoo%QN/cfds ! -> UVic default in m3/mmolN/s
       zoo%gbio = zoo%gbio/cfds
       zoo%forage => forage_H3
    CASE DEFAULT
       STOP 'cfo_read_cfo: Invalid setting for forage in namelist cfo.'
    END SELECT
    SELECT CASE (TRIM(regex))
    CASE ('respire')
       zoo%regex => zxrex
    CASE ('egest')
       zoo%regex => zxreg
    CASE DEFAULT
       STOP 'read_cfo: regex must be one of "respire" or "egest"'
    END SELECT
    IF (pf) WRITE (stdout, NML=cfo)
  END SUBROUTINE read_cfo
  
  ! bctz    zooplankton temperature dependence from tracer.F
  SUBROUTINE forage_cfo (zoo, preyC, preyN, preyP, bct, bctz)
    IMPLICIT NONE
    CLASS(ocf), INTENT(INOUT) :: zoo
    REAL(dp), INTENT(IN) :: preyC(:), preyN(:), preyP(:), bct, bctz
    REAL(dp) :: At, fT, I0, Rm, PC, PN, PP, fQ, rxm
    fT = zoo%fT(bct, bctz)
    Rm = zoo%Rm*fT
    PC = MAX(SUM(zoo%phi*preyC), 1D-30) ! (effective food concentration)*phi
    PN = SUM(zoo%phi*preyN)
    PP = SUM(zoo%phi*preyP)
    IF ((PC.LE.zoo%Pth).OR.(fT.LE.0D0)) THEN    ! food below feeding threshold
       fQ = 1D0
       zoo%Af = 0D0
       zoo%E  = zoo%Emax
       zoo%IC = 0D0
    ELSE
       fQ = MIN(PN/zoo%QN, PP/zoo%QP, PC)/PC
       ! fQ accounts for different N:C ratios in predator and prey, after
       ! Kiørboe (1989) C Ingestion is unaffected by food C:N ratio according
       ! to Kiørboe (1989), so Af should not be affected either.  Thus, food
       ! C:N should influence only R and ngr.  The same concept is applied here
       ! also to C:P.
       I0 = 1D0 - EXP(-PC)                        ! ingestion saturation  (6)
       At = fT*zoo%At                             ! total activity       (15)
       ! Af: foraging activity
       zoo%Af = zoo%beta*At/(-1D0 - lwm1(-(1D0 - zoo%cf/(zoo%Emax*(1 - zoo%ca)*I0)) &
                                          /EXP(1D0 + zoo%beta)));      ! (12)
       ! E: assimilation efficiency
       zoo%E  = zoo%Emax*(1D0 - EXP(-zoo%beta*(At/zoo%Af - 1D0)))      !  (8)
       zoo%IC = zoo%POC*I0*zoo%Af                           ! C ingestion (7)
    END IF
    zoo%pI = zoo%IC*zoo%phi/PC  ! ingestion of each prey type
    zoo%IN = zoo%IC*PN/PC             ! N intake
    zoo%IP = zoo%IC*PP/PC             ! P intake
    CALL zoo%regex(Rm, fQ)
    rxm = zoo%XC/MAX(zoo%RC, 1D-30) ! ratio of egestion : metabolic losses
    zoo%RN = (zoo%IN - zoo%ngr*zoo%QN)/(1D0 + rxm) ! DIN excretion
    zoo%RP = (zoo%IP - zoo%ngr*zoo%QP)/(1D0 + rxm) ! DIP excretion
    zoo%XN = zoo%RN*rxm                            ! PON egestion
    zoo%XP = zoo%RP*rxm                            ! POP egestion
  END SUBROUTINE forage_cfo

  SUBROUTINE forage_UVic (zoo, preyC, preyN, preyP, bct, bctz)
    IMPLICIT NONE
    CLASS(ocf), INTENT(INOUT) :: zoo
    REAL(dp), INTENT(IN) :: preyC(:), preyN(:), preyP(:), bct, bctz
    REAL(dp) :: gmax, thetaZ, geZ_eff
    gmax = zoo%gbio*bctz        ! max. zooplankton growth rate
    thetaZ = SUM(preyN*zoo%pref) + zoo%kzoo
    zoo%pI = gmax*zoo%pref/thetaZ*zoo%POC
    zoo%IC = SUM(zoo%pI*preyC)
    zoo%IN = SUM(zoo%pI*preyN)
    zoo%IP = SUM(zoo%pI*preyP)
    ! effective growth efficiency for homeostatic zooplankton
    ! gamma1*zoo%pI is net ingestion, (1 - gamma1)*zoo%pI goes to detritus
    ! geZ_eff is (growth efficiency)*zoo%IC to prevent division by 0
    geZ_eff = MIN(zoo%geZ*zoo%IC, zoo%gamma1*zoo%IN/zoo%QN, zoo%gamma1*zoo%IP/zoo%QP)
    ! Rx fluxes go into dissolved inorganic pools
    zoo%RC = MAX(zoo%gamma1*zoo%IC - geZ_eff, 0D0)
    zoo%RN = MAX(zoo%gamma1*zoo%IN - (zoo%gamma1*zoo%IC - zoo%RC)*zoo%QN, 0D0)
    zoo%RP = MAX(zoo%gamma1*zoo%IP - (zoo%gamma1*zoo%IC - zoo%RC)*zoo%QP, 0D0)
    zoo%ngr = zoo%gamma1*zoo%IC - zoo%RC
    ! Xx fluxes go to detritus
    zoo%XC = (1D0 - zoo%gamma1)*zoo%IC
    zoo%XN = (1D0 - zoo%gamma1)*zoo%IN
    zoo%XP = (1D0 - zoo%gamma1)*zoo%IP
  END SUBROUTINE forage_UVic

  SUBROUTINE forage_H3 (zoo, preyC, preyN, preyP, bct, bctz)
    IMPLICIT NONE
    CLASS(ocf), INTENT(INOUT) :: zoo
    REAL(dp), INTENT(IN) :: preyC(:), preyN(:), preyP(:), bct, bctz
    REAL(dp) :: gmax, thetaZ, geZ_eff
    REAL(dp) :: pref(nprey)
    gmax = zoo%gbio*bctz        ! max. zooplankton growth rate
    pref = preyC*zoo%pref
    thetaZ = SUM(preyC*pref) + zoo%kzoo
    zoo%pI = gmax*pref/thetaZ*zoo%POC
    zoo%IC = SUM(zoo%pI*preyC)
    zoo%IN = SUM(zoo%pI*preyN)
    zoo%IP = SUM(zoo%pI*preyP)
    ! effective growth efficiency for homeostatic zooplankton
    ! gamma1*zoo%pI is net ingestion, (1 - gamma1)*zoo%pI goes to detritus
    ! geZ_eff is (growth efficiency)*zoo%IC to prevent division by 0
    geZ_eff = MIN(zoo%geZ*zoo%IC, zoo%gamma1*zoo%IN/zoo%QN, zoo%gamma1*zoo%IP/zoo%QP)
    ! Rx fluxes go into dissolved inorganic pools
    zoo%RC = MAX(zoo%gamma1*zoo%IC - geZ_eff, 0D0)
    zoo%RN = MAX(zoo%gamma1*zoo%IN - (zoo%gamma1*zoo%IC - zoo%RC)*zoo%QN, 0D0)
    zoo%RP = MAX(zoo%gamma1*zoo%IP - (zoo%gamma1*zoo%IC - zoo%RC)*zoo%QP, 0D0)
    zoo%ngr = zoo%gamma1*zoo%IC - zoo%RC
    ! Xx fluxes go to detritus
    zoo%XC = (1D0 - zoo%gamma1)*zoo%IC
    zoo%XN = (1D0 - zoo%gamma1)*zoo%IN
    zoo%XP = (1D0 - zoo%gamma1)*zoo%IP
  END SUBROUTINE forage_H3

  ! excrete (respire) extra C in food
  SUBROUTINE zxrex (zoo, Rm, fQ)
    IMPLICIT NONE
    CLASS(ocf), INTENT(INOUT) :: zoo
    REAL(dp), INTENT(IN) :: Rm, fQ
    REAL(dp) :: EI
    EI = zoo%E*zoo%IC
    zoo%ngr = (EI*(1D0 - zoo%ca) - zoo%poc*(zoo%cf*zoo%Af + Rm))*fQ
    zoo%RC  = EI - zoo%ngr        ! respiration
    zoo%XC = zoo%IC*(1D0 - zoo%E) ! egestion
  END SUBROUTINE zxrex

  ! egest extra C in food
  SUBROUTINE zxreg (zoo, Rm, fQ)
    IMPLICIT NONE
    CLASS(ocf), INTENT(INOUT) :: zoo
    REAL(dp), INTENT(IN) :: Rm, fQ
    REAL(dp) :: EI
    EI = zoo%E*zoo%IC*fQ
    zoo%RC = zoo%poc*(zoo%cf*zoo%Af + Rm)*fQ + EI*zoo%ca  ! respiration (2)
    zoo%ngr = EI - zoo%RC                                 ! net growth  (9)
    zoo%XC = zoo%IC - zoo%ngr - zoo%RC                    ! egestion
  END SUBROUTINE zxreg

  ! temperature function for Mytilus edulis from Jenny's simulations
  FUNCTION fT_ME (temperature) RESULT (fT)
    IMPLICIT NONE
    REAL(dp), INTENT(IN) :: temperature
    REAL(dp) :: fT
    fT = (1D0 + (temperature - 15D0)*9.5D0)/260D0
  END FUNCTION fT_ME

  ! temperature function ftz_bct: use bct also for zooplankton
  FUNCTION ftz_bct (bct, bctz) RESULT (ftz)
    IMPLICIT NONE
    REAL(dp), INTENT(IN) :: bct, bctz
    REAL(dp) :: ftz
    ftz = bct
  END FUNCTION ftz_bct

  ! temperature function ftz_bctz: UVic default zooplankton temperature dependence
  FUNCTION ftz_bctz (bct, bctz) RESULT (ftz)
    IMPLICIT NONE
    REAL(dp), INTENT(IN) :: bct, bctz
    REAL(dp) :: ftz
    ftz = bctz
  END FUNCTION ftz_bctz
END MODULE cfo
