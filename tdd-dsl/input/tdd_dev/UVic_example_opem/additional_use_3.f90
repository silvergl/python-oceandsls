MODULE additional_use_3
  IMPLICIT NONE

  PRIVATE
  PUBLIC :: fT_ME, foo



CONTAINS

  ! auto-generated, src: tdd-dsl/input/test_fT_ME_multi.tdd, 12:4-19:8
  FUNCTION fT_ME (arg0, unit) RESULT (out)
    IMPLICIT NONE
    real(dp), INTENT(IN)  :: arg0
    real :: out

    character(len = *),optional :: unit
    if(present(unit))then
        if ( unit /= "K" ) then
          print *, "fT_ME: Expected K as input unit but got ", unit
        endif
    endif

    out = ! <<Add return expression here>>
  END FUNCTION fT_ME

  ! auto-generated, src: tdd-dsl/input/test_fT_ME_multi.tdd, 36:4-42:52
  FUNCTION foo (arg0, unit) RESULT (out)
    IMPLICIT NONE
    real(dp), INTENT(IN)  :: arg0
    real :: out

    character(len = *),optional :: unit
    if(present(unit))then
        if ( unit /= "K" ) then
          print *, "foo: Expected K as input unit but got ", unit
        endif
    endif

    out = ! <<Add return expression here>>
  END FUNCTION foo

END MODULE additional_use_3