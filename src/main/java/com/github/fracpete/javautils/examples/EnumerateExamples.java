/*
 * EnumerateExamples.java
 * Copyright (C) 2019 University of Waikato, Hamilton, NZ
 */

package com.github.fracpete.javautils.examples;

import com.github.fracpete.javautils.enumerate.Enumerated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static com.github.fracpete.javautils.Enumerate.enumerate;

/**
 * Examples for using the "Enumerate.enumerate" methods.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 */
public class EnumerateExamples {

  public static void main(String[] args) throws Exception {
    String[] array = new String[]{"a", "b", "c"};
    List<String> list = new ArrayList<>(Arrays.asList(array));

    // Array
    System.out.println("\nWrapping Array:");
    for (Enumerated<String> e: enumerate(array))
      System.out.println(e.index + ": " + e.value);

    // Iterable
    System.out.println("\nWrapping Iterable:");
    for (Enumerated<String> e: enumerate(list))
      System.out.println(e.index + ": " + e.value);

    // Iterable (start=1)
    System.out.println("\nWrapping Iterable (start = 1):");
    for (Enumerated<String> e: enumerate(list, 1))
      System.out.println(e.index + ": " + e.value);

    // Iterable (start=0, step = -1)
    System.out.println("\nWrapping Iterable (start = 0, step = -2):");
    for (Enumerated<String> e: enumerate(list, 0, -2))
      System.out.println(e.index + ": " + e.value);

    // Iterator
    System.out.println("\nWrapping Iterator:");
    Iterator<String> iter = list.iterator();
    for (Iterator<Enumerated<String>> it = enumerate(iter); it.hasNext(); ) {
      Enumerated<String> e = it.next();
      System.out.println(e.index + ": " + e.value);
    }
  }
}
