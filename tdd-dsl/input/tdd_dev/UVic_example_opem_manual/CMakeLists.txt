cmake_minimum_required(VERSION 3.12)

project (PFUNIT_DEMO_BASIC
  VERSION 1.0.0
  LANGUAGES Fortran)

find_package(PFUNIT REQUIRED)
enable_testing()

# system under test
add_library(sut
  cfo_sut_example.f90
  )

set_target_properties (sut PROPERTIES
  Fortran_MODULE_DIRECTORY ${CMAKE_CURRENT_BINARY_DIR})

target_include_directories(sut PUBLIC ${CMAKE_CURRENT_BINARY_DIR})

add_subdirectory(tests)
