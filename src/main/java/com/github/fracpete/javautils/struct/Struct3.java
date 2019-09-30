/*
 * Struct3.java
 * Copyright (C) 2019 University of Waikato, Hamilton, NZ
 */

package com.github.fracpete.javautils.struct;

import java.io.Serializable;

/**
 * Simple container class for three values.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 */
public class Struct3<T1,T2,T3>
  implements Serializable {

  private static final long serialVersionUID = 8047446078844533156L;

  /** the first value. */
  public T1 value1;

  /** the second value. */
  public T2 value2;

  /** the third value. */
  public T3 value3;

  /**
   * Initializes the container.
   *
   * @param value1	the first value
   * @param value2	the second value
   * @param value3	the third value
   */
  public Struct3(T1 value1, T2 value2, T3 value3) {
    this.value1 = value1;
    this.value2 = value2;
    this.value3 = value3;
  }

  /**
   * Simple string representation.
   *
   * @return		the generated string
   */
  public String toString() {
    return "value1=" + value1 + ", value2=" + value2 + ", value3=" + value3;
  }
}
