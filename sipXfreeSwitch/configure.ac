AC_PREREQ(2.57)
AC_INIT(sipXfreeSwitch, 4.6.0, sipx-dev@list.sipfoundry.org)
AC_CONFIG_AUX_DIR(config)
m4_include([config/general.m4])
m4_include([config/sipXlib.m4])
AM_INIT_AUTOMAKE(foreign tar-ustar)
SFAC_AUTOMAKE_VERSION([1.6])
AC_PROG_LIBTOOL
AC_PATH_PROG([BASH], [bash])
AC_PROG_CXX
AX_COMPILER_VENDOR
AC_PROG_CC
CHECK_XARGS_REPLACE
SFAC_INIT_FLAGS
CHECK_FREESWITCH
AC_CONFIG_FILES([
  Makefile 
  etc/Makefile
  bin/Makefile
])
AC_OUTPUT
