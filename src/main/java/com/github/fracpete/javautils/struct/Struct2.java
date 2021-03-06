/*
 * Struct2.java
 * Copyright (C) 2019 University of Waikato, Hamilton, NZ
 */

package com.github.fracpete.javautils.struct;

import java.io.Serializable;

/**
 * Simple container class for two values.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 */
public class Struct2<T1,T2>
  implements Serializable {

  private static final long serialVersionUID = 8047446078844533156L;

  /** the first value. */
  public T1 value1;

  /** the second value. */
  public T2 value2;

  /**
   * Initializes the container.
   *
   * @param value1	the first value
   * @param value2	the second value
   */
  public Struct2(T1 value1, T2 value2) {
    this.value1 = value1;
    this.value2 = value2;
  }

  /**
   * Simple string representation.
   *
   * @return		the generated string
   */
  public String toString() {
    return "value1=" + value1 + ", value2=" + value2;
  }
}
