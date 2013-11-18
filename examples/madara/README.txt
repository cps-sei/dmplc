1. INTRODUCTION

This directory contains an example MADARA implementation of a synchronous
distributed algorithm for collision avoidance implemented in MADARA. This
example is based off the sync-coll-avoid.mcda logic located in the parent
directory.

This has not been tested, only built.

2. HOW TO BUILD

  2.0 PREREQUISITES
  
    MADARA installed (see Installation wiki at madara.googlecode.com)

  2.1 LINUX
  
    mwc.pl -type gnuace sync-coll-avoid.mwc
    make
  
  2.2 WINDOWS
  
    mwc.pl -type vc10 sync-coll-avoid.mwc
    *open sync_coll_avoid.sln and build*
  
