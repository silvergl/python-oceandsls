! minimal example from uvic-model/2.9/updates/uvic-updates-opem/f90/cfo.f90
MODULE cfo_example  
  IMPLICIT NONE

  PRIVATE
  PUBLIC :: ft_ME

  INTEGER, PARAMETER :: dp=KIND(0D0)

  ! INCLUDE 'stdunits.h'


CONTAINS

  ! temperature function for Mytilus edulis from Jenny's simulations
  FUNCTION fT_ME (temperature) RESULT (fT)
    IMPLICIT NONE
    REAL(dp), INTENT(IN) :: temperature
    REAL(dp) :: fT
    fT = (1D0 + (temperature - 15D0)*9.5D0)/260D0
  END FUNCTION fT_ME

END MODULE cfo_example