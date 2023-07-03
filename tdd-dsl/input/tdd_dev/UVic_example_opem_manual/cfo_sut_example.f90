! minimal example from uvic-model/2.9/updates/uvic-updates-opem/f90/cfo.f90
MODULE cfo_example  
  IMPLICIT NONE

  PRIVATE
  PUBLIC :: ft_ME, zxrex, nprey

  INTEGER, PARAMETER :: dp=KIND(0D0)
  REAL(dp) :: nprey= - ( 283D0 / 520D0 )
  REAL(dp), PARAMETER :: cfds=86.4D3

  INCLUDE 'stdunits.h'

  TYPE, PUBLIC :: ocf
     REAL(dp) :: ngr,&  ! relative growth rate
          ca=0.1D0,&    ! cost of assimilation coefficients
          cf=0.1D0,&    ! cost of foraging coefficients
          Af,&          ! foraging activity
          IC,&          ! C ingestion
          E,&           ! assimilation efficiency
          POC,&         ! zooplankton biomass concentration
          RC,&          ! respiration
          XC            ! C excretion
  END TYPE ocf
  TYPE(ocf), DIMENSION(:), ALLOCATABLE, PUBLIC :: zoo

CONTAINS

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

  ! temperature function for Mytilus edulis from Jenny's simulations
  FUNCTION fT_ME (temperature) RESULT (fT)
    IMPLICIT NONE
    REAL(dp), INTENT(IN) :: temperature
    REAL(dp) :: fT
    fT = (1D0 + (temperature - 15D0)*9.5D0)/260D0
  END FUNCTION fT_ME
END MODULE cfo_example