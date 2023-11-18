# pFUnit test source files
add_pfunit_ctest (test_fT_ME
  TEST_SOURCES test_fT_ME.pf
  LINK_LIBRARIES test_fT_ME_sut
)
add_pfunit_ctest (test_fT_ME_more
  TEST_SOURCES test_fT_ME_more.pf
  LINK_LIBRARIES test_fT_ME_more_sut
)