/*
 * Struct2.java
 * Copyright (C) 2019 University of Waikato, Hamilton, NZ
 */

package com.github.fracpete.javautils.struct;

import java.io.Serializable;

/**
 * Simple container class for key/value pairs of maps.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 */
public class MapStruct<K, V>
  implements Serializable {

  private static final long serialVersionUID = 8047446078844533156L;

  /** the key. */
  public K key;

  /** the value. */
  public V value;

  /**
   * Initializes the container.
   *
   * @param key		the key
   * @param value	the value
   */
  public MapStruct(K key, V value) {
    this.key = key;
    this.value = value;
  }

  /**
   * Simple string representation.
   *
   * @return		the generated string
   */
  public String toString() {
    return "key=" + key + ", value=" + value;
  }
}
