/*
 * Struct.java
 * Copyright (C) 2019 University of Waikato, Hamilton, NZ
 */

package com.github.fracpete.javautils;

import com.github.fracpete.javautils.struct.MapStruct;
import com.github.fracpete.javautils.struct.Struct2;
import com.github.fracpete.javautils.struct.Struct3;
import com.github.fracpete.javautils.struct.Struct4;
import com.github.fracpete.javautils.struct.Struct5;

import java.util.Iterator;
import java.util.Map;

/**
 * For wrapping multiple objects in container objects.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 * @see com.github.fracpete.javautils.examples.StructExamples
 */
public class Struct {

  /**
   * Wraps two elements in struct container.
   *
   * @param value1	the first value
   * @param value2	the second value
   * @param <T1>	the first type
   * @param <T2>	the second type
   * @return		the generated container
   */
  public static <T1,T2> Struct2<T1,T2> struct(T1 value1, T2 value2) {
    return new Struct2<>(value1, value2);
  }

  /**
   * Wraps three elements in struct container.
   *
   * @param value1	the first value
   * @param value2	the second value
   * @param value3	the third value
   * @param <T1>	the first type
   * @param <T2>	the second type
   * @param <T3>	the third type
   * @return		the generated container
   */
  public static <T1,T2,T3> Struct3<T1,T2,T3> struct(T1 value1, T2 value2, T3 value3) {
    return new Struct3<>(value1, value2, value3);
  }

  /**
   * Wraps four elements in struct container.
   *
   * @param value1	the first value
   * @param value2	the second value
   * @param value3	the third value
   * @param value4	the fourth value
   * @param <T1>	the first type
   * @param <T2>	the second type
   * @param <T3>	the third type
   * @param <T4>	the fourth type
   * @return		the generated container
   */
  public static <T1,T2,T3,T4> Struct4<T1,T2,T3,T4> struct(T1 value1, T2 value2, T3 value3, T4 value4) {
    return new Struct4<>(value1, value2, value3, value4);
  }

  /**
   * Wraps five elements in struct container.
   *
   * @param value1	the first value
   * @param value2	the second value
   * @param value3	the third value
   * @param value4	the fourth value
   * @param value5	the fifth value
   * @param <T1>	the first type
   * @param <T2>	the second type
   * @param <T3>	the third type
   * @param <T4>	the fourth type
   * @param <T5>	the fifth type
   * @return		the generated container
   */
  public static <T1,T2,T3,T4,T5> Struct5<T1,T2,T3,T4,T5> struct(T1 value1, T2 value2, T3 value3, T4 value4, T5 value5) {
    return new Struct5<>(value1, value2, value3, value4, value5);
  }

  /**
   * Wraps the key/value pairs of a map in a struct container.
   *
   * @param map		the map
   * @param <T1>	the key type
   * @param <T2>	the value type
   * @return		the generated container
   */
  public static <T1,T2> Iterable<MapStruct<T1,T2>> pairs(final Map<T1,T2> map) {
    return new Iterable<MapStruct<T1,T2>>() {
      @Override
      public Iterator<MapStruct<T1, T2>> iterator() {
        return new Iterator<MapStruct<T1,T2>>() {
          Iterator<T1> keys = map.keySet().iterator();
          @Override
          public boolean hasNext() {
            return keys.hasNext();
          }
          @Override
          public MapStruct<T1, T2> next() {
            T1 key = keys.next();
            return new MapStruct<>(key, map.get(key));
          }
        };
      }
    };
  }
}
