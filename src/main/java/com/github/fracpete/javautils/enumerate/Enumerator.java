/*
 * Enumerator.java
 * Copyright (C) 2019 University of Waikato, Hamilton, NZ
 */

package com.github.fracpete.javautils.enumerate;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Wraps an Iterator around an iterator.
 *
 * @param <T>		the element type of the Iterator
 */
public class Enumerator<T>
  implements Iterator<Enumerated<T>>, Serializable {

  private static final long serialVersionUID = -3734546761287865157L;

  /** the base iterable object. */
  protected Iterator<T> m_Iterator;

  /** the index. */
  protected int m_Index;

  /** the starting index. */
  protected int m_Start;

  /** the step size. */
  protected int m_Step;

  /**
   * Initializes the iterator.
   * Uses starting index 0 and step size 1.
   *
   * @param iterable	the iterable
   */
  public Enumerator(Iterable<T> iterable) {
    this(iterable.iterator());
  }

  /**
   * Initializes the iterator.
   * Uses step size 1.
   *
   * @param iterable	the iterator
   * @param start 	the starting index
   */
  public Enumerator(Iterable<T> iterable, int start) {
    this(iterable.iterator(), start);
  }

  /**
   * Initializes the iterator.
   *
   * @param iterable	the iterator
   * @param start 	the starting index
   * @param step 	the steps between indices
   */
  public Enumerator(Iterable<T> iterable, int start, int step) {
    this(iterable.iterator(), start, step);
  }

  /**
   * Initializes the array.
   * Uses starting index 0 and step size 1.
   *
   * @param array	the array
   */
  public Enumerator(T[] array) {
    this(Arrays.asList(array).iterator());
  }

  /**
   * Initializes the array.
   * Uses step size 1.
   *
   * @param array	the array
   * @param start 	the starting index
   */
  public Enumerator(T[] array, int start) {
    this(Arrays.asList(array).iterator(), start);
  }

  /**
   * Initializes the array.
   *
   * @param array	the array
   * @param start 	the starting index
   * @param step 	the steps between indices
   */
  public Enumerator(T[] array, int start, int step) {
    this(Arrays.asList(array).iterator(), start, step);
  }

  /**
   * Initializes the iterator.
   * Uses starting index 0 and step size 1.
   *
   * @param iterator	the iterator
   */
  public Enumerator(Iterator<T> iterator) {
    this(iterator, 0, 1);
  }

  /**
   * Initializes the iterator.
   * Uses step size 1.
   *
   * @param iterator	the iterator
   * @param start 	the starting index
   */
  public Enumerator(Iterator<T> iterator, int start) {
    this(iterator, start, 1);
  }

  /**
   * Initializes the iterator.
   *
   * @param iterator	the iterator
   * @param start 	the starting index
   * @param step 	the steps between indices
   */
  public Enumerator(Iterator<T> iterator, int start, int step) {
    m_Iterator = iterator;
    m_Index    = start;
    m_Start    = start;
    m_Step     = step;
  }

  /**
   * Returns the starting index.
   *
   * @return    	the first index
   */
  public int getStart() {
    return m_Start;
  }

  /**
   * Returns the step size between indices of elements.
   *
   * @return		the step size
   */
  public int getStep() {
    return m_Step;
  }

  /**
   * Whether there is another element available.
   *
   * @return		true if another element available
   */
  @Override
  public boolean hasNext() {
    return m_Iterator.hasNext();
  }

  /**
   * Returns the next element wrapper.
   *
   * @return		the next wrapper
   */
  @Override
  public Enumerated<T> next() {
    Enumerated<T> 	result;

    result   = new Enumerated<>(m_Index, m_Iterator.next());
    m_Index += m_Step;

    return result;
  }

  /**
   * Returns a simple string representation of the wrapper.
   *
   * @return		the string representation
   */
  public String toString() {
    return "start=" + m_Start + ", step=" + m_Step + ", index=" + m_Index;
  }
}
