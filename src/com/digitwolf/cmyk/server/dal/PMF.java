// Copyright 2008 Google Inc. All Rights Reserved.
package com.digitwolf.cmyk.server.dal;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

/**
 * @author Max Ross <maxr@google.com>
 */
public final class PMF {

  private static final PersistenceManagerFactory INSTANCE =
      JDOHelper.getPersistenceManagerFactory("transactions-optional");

  public static PersistenceManagerFactory get() {
    return INSTANCE;
  }

  private PMF() {}
}
