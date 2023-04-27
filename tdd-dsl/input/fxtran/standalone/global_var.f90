module global_var
   implicit none

   integer :: gl_a, gl_b

contains
   subroutine set_gl( a, b)
      integer, intent(in) :: a, b

      gl_a = a
      gl_b = b
   end subroutine set_gl

end module global_var