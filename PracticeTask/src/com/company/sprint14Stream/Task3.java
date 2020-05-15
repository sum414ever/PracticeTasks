package com.company.sprint14Stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task3 {

  public static void main(String[] args) {

    var in = Stream.of(IntStream.of(-2, -4, 1, 8, 3, 10),
        IntStream.of(2, -4, 4, 0, 3, 1),
        IntStream.of(1, -4, 3, 5, 3, 1));

    var expected = 10;
    var out = new MyUtils3().sumEven(in);
    boolean result = expected == out;
    System.out.println(result);
  }
}

class MyUtils3 {

  public int sumEven(Stream<IntStream> stream) {

    return stream
        .map(x -> x.filter(y -> y > 0))
        .map(x -> x.filter(y -> y % 2 == 0))
        .map(IntStream::sorted)
        .map(x -> x.limit(1))
        .flatMapToInt(i -> i)
        .sum();
  }
}

//  Create a int sumEven(Stream<IntStream> stream) method of the MyUtils class to sum minimal positive even numbers from all Streams.
//    Return zero if minimum positive even element was not found in stream.
//    For example, for a given
//    [[-2, -4, 1, 8, 3, 10], [2, -4, 4, 0, 3, 1], [1, -4, 3, 5, 3, 1]]
//    you should get 10 (8+2+0)