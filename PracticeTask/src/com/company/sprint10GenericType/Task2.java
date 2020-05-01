package com.company.sprint10GenericType;

//In the class ArrayUtil write a public static generic method named "setAndReturn(...)"
// to modify and return the element in an array from the given position.

public class Task2 {

  public static void main(String[] args) {

//    Print to display: 52
    Integer[] numbers = new Integer[3];
    int numberFromSecondPosition = ArrayUtil.<Integer>setAndReturn(numbers, 52,1);
    System.out.println(numberFromSecondPosition);

//    Print to display: "Hello"
    String[] words = new String[3];
    String wordFromSecondPosition = ArrayUtil.<String>setAndReturn(words, "Hello",1);
    System.out.println(wordFromSecondPosition);

  }
}

class ArrayUtil {

  public static <T> T setAndReturn(T[] arr, T s, int position ){

    return arr[position] = s;
  }
}
