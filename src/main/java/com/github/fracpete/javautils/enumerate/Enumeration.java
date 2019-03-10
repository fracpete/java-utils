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
 * Enumeration.java
 * Copyright (C) 2019 University of Waikato, Hamilton, NZ
 */

package com.github.fracpete.javautils.enumerate;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Provides an enumerated wrapper around an Iterable/Iterator object.
 *
 * @param <T>		the element type of the Iterable/Iterator
 */
public class Enumeration<T>
  implements Iterable<Enumerated<T>>, Serializable {

  private static final long serialVersionUID = -6874019120085387575L;

  /** the iterator to wrap. */
  protected Iterator<T> m_Iterator;

  /** the starting index. */
  protected int m_Start;

  /** the step size. */
  protected int m_Step;

  /**
   * Initializes the wrapper.
   *
   * @param iterable	the iterable to wrap
   */
  public Enumeration(Iterable<T> iterable) {
    this(iterable.iterator());
  }

  /**
   * Initializes the wrapper.
   *
   * @param iterable	the iterable to wrap
   */
  public Enumeration(Iterable<T> iterable, int start) {
    this(iterable.iterator(), start);
  }

  /**
   * Initializes the wrapper.
   *
   * @param iterable	the iterable to wrap
   */
  public Enumeration(Iterable<T> iterable, int start, int step) {
    this(iterable.iterator(), start, step);
  }

  /**
   * Initializes the wrapper.
   *
   * @param iterator	the iterator to wrap
   */
  public Enumeration(Iterator<T> iterator) {
    this(iterator, 0, 1);
  }

  /**
   * Initializes the wrapper.
   *
   * @param iterator	the iterator to wrap
   */
  public Enumeration(Iterator<T> iterator, int start) {
    this(iterator, start, 1);
  }

  /**
   * Initializes the wrapper.
   *
   * @param iterator	the iterator to wrap
   */
  public Enumeration(Iterator<T> iterator, int start, int step) {
    m_Iterator = iterator;
    m_Start    = start;
    m_Step     = step;
  }

  /**
   * Returns the iterator.
   *
   * @return		the iterator
   */
  @Override
  public Iterator<Enumerated<T>> iterator() {
    return new Enumerator<>(m_Iterator, m_Start, m_Step);
  }

  /**
   * Returns a simple string representation of the wrapper.
   *
   * @return		the string representation
   */
  public String toString() {
    return "start=" + m_Start + ", step=" + m_Step;
  }
}
