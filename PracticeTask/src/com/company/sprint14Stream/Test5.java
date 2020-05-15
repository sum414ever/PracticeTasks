package com.company.sprint14Stream;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test5 {

  public static void main(String[] args) {

    Stream<Integer> stream = Stream.of(3, -2, 1, 2, 1, 12, 3,2, 3, -2);
    Stream<Integer> expected = Stream.of( -2, 1, 2, 3);
    Stream<Integer> out = new MyUtils().duplicateElements(stream);

    boolean result = Arrays.equals(expected.toArray(), out.toArray());
    System.out.println(result ? "OK" : "FAIL");
  }

}

class MyUtils {

  public Stream<Integer> duplicateElements(Stream<Integer> stream) {

    return stream.filter(Objects::nonNull)
        .collect(Collectors.groupingBy(Function.identity()
        , Collectors.counting()))
        .entrySet().stream()
        .filter(m -> m.getValue() > 1)
        .map(Entry::getKey)
        .sorted();
  }
}

//  Create a Stream<Integer> duplicateElements(Stream<Integer> stream) method of the MyUtils class
//to return a sorted stream of duplicated elements of the input stream.
//    For example, for a given elements
//    [3, 2, 1, 1, 12, 3, 8, 2, 4, 2]
//    you should get
//    [1, 2, 3]