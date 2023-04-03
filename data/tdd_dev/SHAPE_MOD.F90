! You can derive one type from another
module shape_mod
  implicit none
 
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
end module shape_mod