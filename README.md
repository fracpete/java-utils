# java-utils
Python-inspired utility functions and classes for Java.

## Enumerate

(inspired by Python's [enumerate](https://docs.python.org/3.5/library/functions.html#enumerate) function)


The static methods of the `com.github.fracpete.javautils.Enumerate` class allows 
to associate elements of an array, a `java.lang.Iterable` or `java.util.Iterator` with
an index, by outputting a container class with the two of them. You can use
different starting indices and step sizes between elements: 

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import com.github.fracpete.javautils.enumerate.Enumerated;
import static com.github.fracpete.javautils.Enumerate.enumerate;

...

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
```

Generated output:

```
Wrapping Iterable:
0: a
1: b
2: c

Wrapping Iterable (start = 1):
1: a
2: b
3: c

Wrapping Iterable (start = 0, step = -2):
0: a
-2: b
-4: c

Wrapping Iterator:
0: a
1: b
2: c
```

## Struct

(inspired by Python's [tuples](https://docs.python.org/3.5/library/functions.html#func-tuple))

The static `struct` methods of the `com.github.fracpete.javautils.Struct` class
allow you to quickly wrap two to five values in a container class. 
You can also wrap the key/value pairs of a map with that, to quickly iterate
over a map.

```java
import java.util.HashMap;
import java.util.Map;
import com.github.fracpete.javautils.struct.MapStruct;
import com.github.fracpete.javautils.struct.Struct2;
import static com.github.fracpete.javautils.Struct.pairs;
import static com.github.fracpete.javautils.Struct.struct;

...

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
```

Generated output:

```
Simple struct
value=12
container: value1=12, value2=144
value1: 12
value2: 144

Map key/value pairs
k=A, v=Sup!
k=B, v=World
k=C, v=Hello
```


## Reflection

The `com.github.fracpete.javautils.Reflection` class offers static methods
to simplify reflection a bit:

* instantiating objects: `newInstance`

  ```java
  import static com.github.fracpete.javautils.Reflection.newInstance; 

  Object file1 = newInstance("java.io.File", new Class[]{String.class}, new Object[]{System.getProperty("java.io.tmpdir")});
  System.out.println("newInstance: " + file1);

  Object file2 = newInstance("java.io.File", new Class[]{String.class}, new Object[]{System.getProperty("java.io.tmpdir") + "/some.txt"});
  System.out.println("newInstance: " + file2);
  ```

* method calls (with return value): `function` 

  ```java
  import static com.github.fracpete.javautils.Reflection.function; 

  Object name = function(file1, "getName");
  System.out.println("name: " + name);

  int comparison = function(file1, "compareTo", new Class[]{File.class}, new Object[]{file2});
  System.out.println("f1.compareTo(f2): " + comparison);
  ```

* method calls (without return value): `procedure`

  ```java
  import static com.github.fracpete.javautils.Reflection.procedure; 

  procedure(file2, "deleteOnExit");
  System.out.println("called deleteOnExit");
  ```


## Maven

Add the following dependency to your `pom.xml`:
```xml
    <dependency>
      <groupId>com.github.fracpete</groupId>
      <artifactId>java-utils</artifactId>
      <version>0.0.3</version>
    </dependency>
```
