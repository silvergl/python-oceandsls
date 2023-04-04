! https://youtu.be/__2UgFNYgf8
! https://www.newthinktank.com/2018/12/fortran-tutorial/

program fortrantut
	implicit none
	
	integer :: age = 16, m , n, interior_value=42
	integer, parameter :: NX_LOC=2, NY_LOC=2
	integer :: array(NX_LOC,0:NY_LOC+1)
	
	array(1:NX_LOC,1:NY_LOC) = interior_value
	do n=1,NX_LOC
		do m=0,NY_LOC+1
			print"(i1,2x,i1,a3,i3)",n, m ," : ",array(n,m)
		end do
	end do
	select case (age)
		case (5)
			print *, "5"
		case (6:13)
			print *, "6 to 13"
		case (14,15,16,17,18)
			print *, "14 to 18"
		case default
			print *, "def"
	end select
end program fortrantut