module global_rd
   implicit none

contains
   integer function add_gl()
       use global_var
       implicit none
       integer :: c
       c = gl_a + gl_b
   end function add_gl

end module global_rd