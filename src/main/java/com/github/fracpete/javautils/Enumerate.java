/*
 * Enumerate.java
 * Copyright (C) 2019 University of Waikato, Hamilton, New Zealand
 */

package com.github.fracpete.javautils;

import com.github.fracpete.javautils.enumerate.Enumerated;
import com.github.fracpete.javautils.enumerate.Enumeration;
import com.github.fracpete.javautils.enumerate.Enumerator;

import java.util.Iterator;

/**
 * For generating a tuple of index and value for objects which classes
 * implemented {@link java.lang.Iterable}.
 * <pre>
 * import java.util.ArrayList;
 * import java.util.List;
 * import static com.github.fracpete.javautils.Enumerate.enumerate;
 *
 * List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
 * for (Enumerated<String> e: enumerate(list))
 *   System.out.println(e.index + ": " + e.value);
 * </pre>
 *
 * @author  fracpete (fracpete at waikato dot ac dot nz)
 * @see com.github.fracpete.javautils.examples.EnumerateExamples
 */
public class Enumerate {

  /**
   * Returns an Iterable wrapper around an Iterable that combines index
   * (starting at 0 with step 1) and value of the Iterable in the returned
   * container object ({@link Enumeration}).
   *
   * @param iterable	the iterable to wrap
   * @param <E>		the type of the iterable's objects
   * @return		the iterable wrapper
   */
  public static <E> Iterable<Enumerated<E>> enumerate(Iterable<E> iterable) {
    return new Enumeration<>(iterable);
  }

  /**
   * Returns an Iterable wrapper around an Iterable that combines index
   * (starting at "start" with step 1) and value of the Iterable in the returned
   * container object ({@link Enumeration}).
   *
   * @param iterable	the iterable to wrap
   * @param start	the starting index
   * @param <E>		the type of the iterable's objects
   * @return		the iterable wrapper
   */
  public static <E> Iterable<Enumerated<E>> enumerate(Iterable<E> iterable, int start) {
    return new Enumeration<>(iterable, start);
  }

  /**
   * Returns an Iterable wrapper around an Iterable that combines index
   * (starting at "start" with step size "step") and value of the Iterable in the returned
   * container object ({@link Enumeration}).
   *
   * @param iterable	the iterable to wrap
   * @param start	the starting index
   * @param step 	the step size
   * @param <E>		the type of the iterable's objects
   * @return		the iterable wrapper
   */
  public static <E> Iterable<Enumerated<E>> enumerate(Iterable<E> iterable, int start, int step) {
    return new Enumeration<>(iterable, start, step);
  }

  /**
   * Returns an Iterable wrapper around an Iterator that combines index
   * (starting at 0 with step 1) and value of the Iterable in the returned
   * container object ({@link Enumeration}).
   *
   * @param iterable	the Iterator to wrap
   * @param <E>		the type of the Iterator's objects
   * @return		the Iterator wrapper
   */
  public static <E> Iterator<Enumerated<E>> enumerate(Iterator<E> iterable) {
    return new Enumerator<>(iterable);
  }

  /**
   * Returns an Iterable wrapper around an Iterator that combines index
   * (starting at "start" with step 1) and value of the Iterable in the returned
   * container object ({@link Enumeration}).
   *
   * @param iterable	the Iterator to wrap
   * @param start	the starting index
   * @param <E>		the type of the Iterator's objects
   * @return		the Iterator wrapper
   */
  public static <E> Iterator<Enumerated<E>> enumerate(Iterator<E> iterable, int start) {
    return new Enumerator<>(iterable, start);
  }

  /**
   * Returns an Iterable wrapper around an Iterator that combines index
   * (starting at "start" with step size "step") and value of the Iterable in the returned
   * container object ({@link Enumeration}).
   *
   * @param iterable	the Iterator to wrap
   * @param start	the starting index
   * @param step 	the step size
   * @param <E>		the type of the Iterator's objects
   * @return		the Iterator wrapper
   */
  public static <E> Iterator<Enumerated<E>> enumerate(Iterator<E> iterable, int start, int step) {
    return new Enumerator<>(iterable, start, step);
  }
}
