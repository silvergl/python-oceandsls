module mult_mod
  implicit none

  real :: x
  integer :: i

  private
  public :: mult
 
  interface mult
    procedure mult_real, mult_int
  end interface mult
 
contains
  real pure function mult_real( a, b) result(c)
    real, intent(in) :: a,b
    c = a * b
  end function mult_real
 
  integer pure function mult_int( a, b) result(c)
    integer, intent(in) :: a,b
    c = a * b
  end function mult_int
 
end module mult_mod