subroutine foo()
    implicit none
    integer :: i, j, k
    !$construct begin
    do i = 1, 10
        do j = 1, 10
            call bar(i, j, k)
        end do
    end do
    !$construct end
end subroutine foo

subroutine bar(a, b, c)
    implicit none
    integer, intent(in) :: a, b
    integer, intent(out) :: c
    c = a + b
end subroutine bar

program main
    implicit none
    call foo()
end program main