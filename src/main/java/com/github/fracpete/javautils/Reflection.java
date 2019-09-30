/*
 * Reflection.java
 * Copyright (C) 2019 University of Waikato, Hamilton, NZ
 */

package com.github.fracpete.javautils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Helper class for reflection.
 * You can:
 * <ul>
 *   <li>instantiate objects</li>
 *   <li>call methods that return values ("function")</li>
 *   <li>call methods that don't return anything ("procedure")</li>
 * </ul>
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 */
public class Reflection {

  /** empty class array. */
  public static Class[] EMPTY_CLASS_ARRAY = new Class[0];

  /** empty object array. */
  public static Object[] EMPTY_OBJECT_ARRAY = new Object[0];

  /**
   * Instantiates a new instance of the class.
   *
   * @param cls		the name of the class to instantiate
   * @param signature	the signature of the constructor
   * @param values	the values for the constructor
   * @param <T>		the type of class to instantiate
   * @return		the new instance
   * @throws Exception        if instantiation fails
   */
  public static <T>T newInstance(String cls, Class[] signature, Object[] values) throws Exception {
    return newInstance((Class<T>) Class.forName(cls), signature, values);
  }

  /**
   * Instantiates a new instance of the class.
   *
   * @param cls		the class to instantiate
   * @param signature	the signature of the constructor
   * @param values	the values for the constructor
   * @param <T>		the type of class to instantiate
   * @return		the new instance
   * @throws Exception        if instantiation fails
   */
  public static <T>T newInstance(Class<T> cls, Class[] signature, Object[] values) throws Exception {
    T			result;
    Constructor<T> constr;

    constr = cls.getConstructor(signature);
    result = constr.newInstance(values);

    return result;
  }

  /**
   * Returns the value from the method call.
   *
   * @param obj		the object to call the invoke the method on
   * @param method	the name of the method to invoke
   * @param <T>		the type of the result
   * @return		the result of the method call
   * @throws Exception        if method call failed
   */
  public static <T> T function(Object obj, String method) throws Exception {
    return function(obj, method, EMPTY_CLASS_ARRAY, EMPTY_OBJECT_ARRAY);
  }

  /**
   * Returns the value from the method call.
   *
   * @param obj		the object to call the invoke the method on
   * @param method	the name of the method to invoke
   * @param signature	the signature of the method
   * @param values	the values for the method call
   * @param <T>		the type of the result
   * @return		the result of the method call
   * @throws Exception        if method call failed
   */
  public static <T> T function(Object obj, String method, Class[] signature, Object[] values) throws Exception {
    T		result;
    Method meth;

    if (obj == null)
      throw new IllegalStateException("No object provided!");
    meth = obj.getClass().getMethod(method, signature);
    result = (T) meth.invoke(obj, values);

    return result;
  }

  /**
   * Calls the method with the specified value(s).
   *
   * @param obj		the object to call the invoke the method on
   * @param method	the name of the method to invoke
   * @throws Exception        if method call failed
   */
  public static void procedure(Object obj, String method) throws Exception {
    procedure(obj, method, EMPTY_CLASS_ARRAY, EMPTY_OBJECT_ARRAY);
  }

  /**
   * Calls the method with the specified value(s).
   *
   * @param obj		the object to call the invoke the method on
   * @param method	the name of the method to invoke
   * @param signature	the signature of the method
   * @param values	the values for the method call
   * @throws Exception        if method call failed
   */
  public static void procedure(Object obj, String method, Class[] signature, Object[] values) throws Exception {
    Method meth;

    if (obj == null)
      throw new IllegalStateException("No object provided!");
    meth = obj.getClass().getMethod(method, signature);
    meth.invoke(obj, values);
  }
}
