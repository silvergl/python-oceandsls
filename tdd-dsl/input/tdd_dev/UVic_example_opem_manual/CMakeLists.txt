cmake_minimum_required(VERSION 3.12)

project (test_suite
  VERSION 1.0.0
  LANGUAGES Fortran)

# Enable CTest
enable_testing()

# This assumes that you've already cloned the pFUnit source code, built and installed it (make install)
# to a suitable location on your computer. Adding search paths using the PATHS argument is often necessary.
# See https://cmake.org/cmake/help/v3.0/command/find_package.html for more information.
# Note that the pFUnit package will be OS, compiler and compiler version dependent as it distributes Fortran mod-files.
find_package(PFUNIT REQUIRED)

# system under test source files

add_library(cfo_example
  cfo_sut_example.f90
  additional_use_0.f90
  additional_use_1.f90
  )

target_include_directories(cfo_example PUBLIC ${CMAKE_CURRENT_BINARY_DIR})

set_target_properties (cfo_example PROPERTIES
  Fortran_MODULE_DIRECTORY ${CMAKE_CURRENT_BINARY_DIR})

add_subdirectory(tests)