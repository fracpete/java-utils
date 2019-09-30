/*
 * StructExamples.java
 * Copyright (C) 2019 University of Waikato, Hamilton, NZ
 */

package com.github.fracpete.javautils.examples;

import com.github.fracpete.javautils.struct.MapStruct;
import com.github.fracpete.javautils.struct.Struct2;

import java.util.HashMap;
import java.util.Map;

import static com.github.fracpete.javautils.Struct.pairs;
import static com.github.fracpete.javautils.Struct.struct;

/**
 * Examples for using structs.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 */
public class StructExamples {

  public static Struct2<Integer,Integer> return2int(Integer value) {
    return struct(value, value * value);
  }

  public static void main(String[] args) throws Exception {
    System.out.println("\nSimple struct");
    int value = 12;
    System.out.println("value=" + value);
    Struct2<Integer,Integer> i2 = return2int(value);
    System.out.println("container: " + i2);
    System.out.println("value1: " + i2.value1);
    System.out.println("value2: " + i2.value2);

    System.out.println("\nMap key/value pairs");
    Map<String,String> map = new HashMap<>();
    map.put("C", "Hello");
    map.put("B", "World");
    map.put("A", "Sup!");
    for (MapStruct<String,String> s: pairs(map))
      System.out.println("k=" + s.key + ", v=" + s.value);
  }
}
