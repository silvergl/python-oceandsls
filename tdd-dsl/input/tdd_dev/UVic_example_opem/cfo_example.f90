! minimal example from uvic-model/2.9/updates/uvic-updates-opem/f90/cfo.f90
MODULE cfo_example  
  IMPLICIT NONE

  !---------------------------------------------
  !------------- UVIC EXAMPLE ------------------
  !---------------------------------------------

  PRIVATE
  PUBLIC :: fT_ME, zxrex, nprey

  INTEGER, PARAMETER :: dp=KIND(0D0)
  INTEGER :: nprey=4
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

  !---------------------------------------------
  !---------- FORTRAN EXAMPLE ------------------
  !---------------------------------------------

  PUBLIC :: get_sum0, get_sum1
  PRIVATE :: get_sum2

  ! Set the super type as abstract
  type, abstract :: shape_m
 
    ! Sub-types receive these variables
    real :: x, y
 
  contains

    ! This procedure marked as deferred
    ! will be defined in sub-types
    procedure(shape_area), deferred :: get_area
  end type shape_m
 
  ! Define that we want to return the defined
  ! area for each shape sub-class
  interface
    function shape_area(this) result(area)
      import :: shape_m
      class(shape_m) :: this
      real :: area
    end function shape_area
  end interface

  !---------------------------------------------
  !---------------------------------------------
  !---------------------------------------------

CONTAINS

  !---------------------------------------------
  !------------- UVIC EXAMPLE ------------------
  !---------------------------------------------

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
  
  !---------------------------------------------
  !---------- FORTRAN EXAMPLE ------------------
  !---------------------------------------------

  ! Return type, function, name, arguments
  integer function get_sum0(n1, n2)
    implicit none
    integer :: n1, n2, sum

    ! The last value defined is returned
    sum = get_sum1(n1, n2)
  end function get_sum0

  ! Define variable to be returned
  function get_sum1(n1, n2) result(sum)
    implicit none

    ! Don't allow variable values to change
    integer, intent(in) :: n1, n2
    integer :: sum
    sum = get_sum2(n1, n2)
  end function get_sum1

  ! Block functions from changing input
  ! variables with pure
  pure function get_sum2(n1, n2) result(sum)
    implicit none
    integer, intent(in) :: n1

    ! Arguments don't need to have a value passed
    integer, intent(in), optional :: n2
    integer :: sum

    if(present(n2)) then
      sum = n1 + n2
    else
      sum = n1 + 1
    end if
  end function get_sum2
  
  subroutine plus_two(n, plus1, plus2)
    integer, intent(in) :: n
    integer, intent(out) :: plus1, plus2 ! Output
    plus1 = n + 1
    plus2 = n + 2
  end subroutine plus_two

  !---------------------------------------------
  !---------------------------------------------
  !---------------------------------------------


END MODULE cfo_example