/**
 * Copyright (c) 2015 Carnegie Mellon University. All Rights Reserved.

 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:

 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following acknowledgments
 * and disclaimers.

 * 2. Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution.

 * 3. The names "Carnegie Mellon University," "SEI" and/or "Software
 * Engineering Institute" shall not be used to endorse or promote
 * products derived from this software without prior written
 * permission. For written permission, please contact
 * permission@sei.cmu.edu.

 * 4. Products derived from this software may not be called "SEI" nor
 * may "SEI" appear in their names without prior written permission of
 * permission@sei.cmu.edu.

 * 5. Redistributions of any form whatsoever must retain the following
 * acknowledgment:

 * This material is based upon work funded and supported by the
 * Department of Defense under Contract No. FA8721-05-C-0003 with
 * Carnegie Mellon University for the operation of the Software
 * Engineering Institute, a federally funded research and development
 * center.

 * Any opinions, findings and conclusions or recommendations expressed
 * in this material are those of the author(s) and do not necessarily
 * reflect the views of the United States Department of Defense.

 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE
 * ENGINEERING INSTITUTE MATERIAL IS FURNISHED ON AN "AS-IS"
 * BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND,
 * EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT
 * LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE
 * MELLON UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH
 * RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT
 * INFRINGEMENT.

 * This material has been approved for public release and unlimited
 * distribution.

 * DM-0002494
**/

// -*- C++ -*-
// $Id$
// Definition for Win32 Export directives.
// This file is generated automatically by generate_export_file.pl -d MCDA
// ------------------------------
#ifndef MCDA_EXPORT_H
#define MCDA_EXPORT_H

#include "ace/config-all.h"

#if defined (ACE_AS_STATIC_LIBS) && !defined (MCDA_HAS_DLL)
#  define MCDA_HAS_DLL 0
#endif /* ACE_AS_STATIC_LIBS && MCDA_HAS_DLL */

#if !defined (MCDA_HAS_DLL)
#  define MCDA_HAS_DLL 1
#endif /* ! MCDA_HAS_DLL */

#if defined (MCDA_HAS_DLL) && (MCDA_HAS_DLL == 1)
#  if defined (MCDA_BUILD_DLL)
#    define MCDA_Export ACE_Proper_Export_Flag
#    define MCDA_SINGLETON_DECLARATION(T) ACE_EXPORT_SINGLETON_DECLARATION (T)
#    define MCDA_SINGLETON_DECLARE(SINGLETON_TYPE, CLASS, LOCK) ACE_EXPORT_SINGLETON_DECLARE(SINGLETON_TYPE, CLASS, LOCK)
#  else /* MCDA_BUILD_DLL */
#    define MCDA_Export ACE_Proper_Import_Flag
#    define MCDA_SINGLETON_DECLARATION(T) ACE_IMPORT_SINGLETON_DECLARATION (T)
#    define MCDA_SINGLETON_DECLARE(SINGLETON_TYPE, CLASS, LOCK) ACE_IMPORT_SINGLETON_DECLARE(SINGLETON_TYPE, CLASS, LOCK)
#  endif /* MCDA_BUILD_DLL */
#else /* MCDA_HAS_DLL == 1 */
#  define MCDA_Export
#  define MCDA_SINGLETON_DECLARATION(T)
#  define MCDA_SINGLETON_DECLARE(SINGLETON_TYPE, CLASS, LOCK)
#endif /* MCDA_HAS_DLL == 1 */

// Set MCDA_NTRACE = 0 to turn on library specific tracing even if
// tracing is turned off for ACE.
#if !defined (MCDA_NTRACE)
#  if (ACE_NTRACE == 1)
#    define MCDA_NTRACE 1
#  else /* (ACE_NTRACE == 1) */
#    define MCDA_NTRACE 0
#  endif /* (ACE_NTRACE == 1) */
#endif /* !MCDA_NTRACE */

#if (MCDA_NTRACE == 1)
#  define MCDA_TRACE(X)
#else /* (MCDA_NTRACE == 1) */
#  if !defined (ACE_HAS_TRACE)
#    define ACE_HAS_TRACE
#  endif /* ACE_HAS_TRACE */
#  define MCDA_TRACE(X) ACE_TRACE_IMPL(X)
#  include "ace/Trace.h"
#endif /* (MCDA_NTRACE == 1) */

#endif /* MCDA_EXPORT_H */

// End of auto generated file.
