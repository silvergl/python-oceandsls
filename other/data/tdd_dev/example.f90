subroutine foo()
    implicit none
    integer :: i, j, k
    do i = 1, 10
        do j = 1, 10
            call bar(i, j, k)
        end do
    end do
end subroutine foo

subroutine bar(a, b, c)
    implicit none
    integer, intent(in) :: a, b
    integer, intent(out) :: c
    c = a + b
end subroutine bar

program main
    use mult_mod
    use global_var
    use global_rd
    implicit none
    integer :: res_i
    real :: res_r
    call foo()

    call set_gl( 5, 4)
    res_i = add_gl()
    print "(a8,i1)", "5 + 4 = ", res_i

    res_i = add_res(5,4)
    print "(a8,i1)", "5 + 4 = ", res_i

    res_i = mult(5,4)
    print "(a8,i2)", "5 * 4 = ", res_i
    res_r = mult(5.0,4.0)
    print "(a12,f6.2)", "5.0 * 4.0 = ", res_r

    contains
        integer pure function add_res(a, b) result(c)
            implicit none
            integer, intent(in) :: a
            integer, intent(in), optional :: b
            if(present(b)) then
                c = a + b
            else
                c = a
            end if
        end function add_res

end program main