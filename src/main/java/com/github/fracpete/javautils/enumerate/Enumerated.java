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
