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
 * Enumerated.java
 * Copyright (C) 2019 University of Waikato, Hamilton, NZ
 */

package com.github.fracpete.javautils.enumerate;

/**
 * Container class for enumerating {@link java.lang.Iterable} objects.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 */
public class Enumerated<E> {

  /** the index. */
  public int index;

  /** the associated value. */
  public E value;

  /**
   * Initializes the container.
   *
   * @param index 	the index
   * @param value	the value
   */
  public Enumerated(int index, E value) {
    this.index = index;
    this.value = value;
  }

  /**
   * Simple string representation.
   *
   * @return		the generated string
   */
  public String toString() {
    return index + ": " + value;
  }
}
