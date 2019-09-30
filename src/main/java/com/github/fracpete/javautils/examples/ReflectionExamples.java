/*
 * ReflectionExamples.java
 * Copyright (C) 2019 University of Waikato, Hamilton, NZ
 */

package com.github.fracpete.javautils.examples;

import java.io.File;

import static com.github.fracpete.javautils.Reflection.function;
import static com.github.fracpete.javautils.Reflection.newInstance;
import static com.github.fracpete.javautils.Reflection.procedure;

/**
 * Examples for using the {@link com.github.fracpete.javautils.Reflection} class.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 */
public class ReflectionExamples {

  /**
   * Runs the example calls.
   *
   * @param args	ignored
   * @throws Exception	if example fails
   */
  public static void main(String[] args) throws Exception {
    Object file1 = newInstance("java.io.File", new Class[]{String.class}, new Object[]{System.getProperty("java.io.tmpdir")});
    System.out.println("newInstance: " + file1);

    Object name = function(file1, "getName");
    System.out.println("name: " + name);

    Object file2 = newInstance("java.io.File", new Class[]{String.class}, new Object[]{System.getProperty("java.io.tmpdir") + "/some.txt"});
    System.out.println("newInstance: " + file2);

    boolean created = function(file2, "createNewFile");
    System.out.println("createNewFile: " + created);

    boolean exists = function(file2, "exists");
    System.out.println("exists: " + exists);

    procedure(file2, "deleteOnExit");
    System.out.println("called deleteOnExit");

    int comparison = function(file1, "compareTo", new Class[]{File.class}, new Object[]{file2});
    System.out.println("f1.compareTo(f2): " + comparison);

    System.out.println("retrieving values from 'list' method");
    String[] files = function(file1, "list");
    for (String file: files)
      System.out.println(file);
  }

}
