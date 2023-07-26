! minimal example from uvic-model/2.9/updates/uvic-updates-opem/f90/cfo.f90
MODULE cfo_example  
  IMPLICIT NONE

  PRIVATE :: get_sum
  PUBLIC :: ft_ME

  INTEGER, PARAMETER :: dp=KIND(0D0)

  ! INCLUDE 'stdunits.h'

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

CONTAINS

  ! temperature function for Mytilus edulis from Jenny's simulations
  FUNCTION fT_ME (temperature) RESULT (fT)
    IMPLICIT NONE
    REAL(dp), INTENT(IN) :: temperature
    REAL(dp) :: fT
    fT = (1D0 + (temperature - 15D0)*9.5D0)/260D0
  END FUNCTION fT_ME
  
  ! Return type, function, name, arguments
  integer function get_sum(n1, n2)
    implicit none
    integer :: n1, n2, sum

    ! The last value defined is returned
    sum = n1 + n2
  end function get_sum

  ! Define variable to be returned
  function get_sum2(n1, n2) result(sum)
    implicit none

    ! Don't allow variable values to change
    integer, intent(in) :: n1, n2
    integer :: sum
    sum = n1 + n2
  end function get_sum2

  ! Block functions from changing input
  ! variables with pure
  pure function get_sum3(n1, n2) result(sum)
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
  end function get_sum3
  
END MODULE cfo_example