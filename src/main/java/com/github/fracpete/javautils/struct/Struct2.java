/*
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
