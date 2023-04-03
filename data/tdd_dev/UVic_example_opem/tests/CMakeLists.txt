add_pfunit_ctest (simple_tests
  TEST_SOURCES test_simple.pf
  LINK_LIBRARIES sut
  )

add_pfunit_ctest (test_zxrex
  TEST_SOURCES test_zxrex.pf
  LINK_LIBRARIES sut
  )

add_pfunit_ctest (test_fT_ME
  TEST_SOURCES test_fT_ME.pf
  LINK_LIBRARIES sut
  )

add_pfunit_ctest (test_combined
  TEST_SOURCES test_zxrex.pf test_fT_ME.pf
  LINK_LIBRARIES sut
  )