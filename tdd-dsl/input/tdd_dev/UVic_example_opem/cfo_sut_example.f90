! minimal example from uvic-model/2.9/updates/uvic-updates-opem/f90/cfo.f90
MODULE cfo_example  
  IMPLICIT NONE

  PRIVATE
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
  
END MODULE cfo_example