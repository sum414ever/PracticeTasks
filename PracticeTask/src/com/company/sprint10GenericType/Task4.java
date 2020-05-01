package com.company.sprint10GenericType;

//In the class ArrayUtil write static method named "averageValue(...)" that takes an object of
// Array type as input, and returns the average value its elements.
//
//The given method should returns value of double type and take any array,
// whose elements extends Number type.

public class Task4 {

  public static void main(String[] args) {

    //Print to display: 3.0
    Array<Integer> set1 = new Array<>(new Integer[]{1, 2, 3, 4, 5});
    double averageValue1 = ArrayUtill.averageValue(set1);
    System.out.println(averageValue1);

    //Print to display: 3.0
    Array<Double> set2 = new Array<>(new Double[]{1.0, 3.0, 5.0});
    double averageValue2 = ArrayUtill.averageValue(set2);
    System.out.println(averageValue2);

  }
}

class Array<T> {

  private T[] array;

  public Array(T[] array) {
    this.array = array;
  }

  public T get(int index) {
    return array[index];
  }

  public int length() {
    return array.length;
  }
}

class ArrayUtill {

  public static double averageValue(Array<? extends Number> array) {

    double avrg = 0.0;

    for (int i = 0; i < array.length(); i++) {
      avrg += array.get(i).doubleValue();
    }
    return avrg / array.length();
  }
}
