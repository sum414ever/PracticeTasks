package com.company.sprint14Stream;

import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task4 {

  public static void main(String[] args) {

    IntStream intNum = IntStream.of(-3, 0, 0, -13, 21, 15);
    Stream<String> strNum = Stream.of("9", "0", "-23", "0", "-32", "5");
    long out = new MyUtils4().countNumbers(intNum, strNum);
    long expected = 7;
    System.out.println(out);
    System.out.println(out == expected ? "OK" : "FALSE");
  }
}

class MyUtils4 {

  public long countNumbers(IntStream intNum, Stream<String> strNum) {

    return IntStream
        .concat(intNum, strNum
            .filter(Objects::nonNull)
            .map(x -> x.replaceAll("\\s+", ""))
            .filter(x -> !x.isEmpty())
            .map(Integer::parseInt)
            .mapToInt(value -> value))
        .map(Math::abs)
        .filter(i -> i % 3 == 0 || String.valueOf(i).contains("3"))
        .filter(i -> i != 0)
        .count();
  }
}

//  Create a int countNumbers(IntStream intNum, Stream<String> strNum) method of the MyUtils class
//to count of numbers that is divisible by 3 or contains the digit 3.
//    The parameters of the method are two Streams with integers and Strings with one number.
//    For example, for a given
//    [[3, 2, 1, 13, 21, 15], ["9", "4", "23", "0", "32", "5"]]
//    you should get 7