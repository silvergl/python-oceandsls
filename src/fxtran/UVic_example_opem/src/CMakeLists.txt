add_library(sut
  cfo_sut_example.f90
  )

set_target_properties (sut PROPERTIES
  Fortran_MODULE_DIRECTORY ${CMAKE_CURRENT_BINARY_DIR})

target_include_directories(sut PUBLIC ${CMAKE_CURRENT_BINARY_DIR})
