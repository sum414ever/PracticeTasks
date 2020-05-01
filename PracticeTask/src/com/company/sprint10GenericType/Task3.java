package com.company.sprint10GenericType;

//Using Wrapper generic class from task #1, modify it so that it can only
// wrap objects that implement the Shape interface (Square, Circle, etc.).

public class Task3 {

  public static void main(String[] args) {

    Wraper<Shape> squareWraper = new Wraper<>(new Square()); //Good
//    Wraper<String > StringWraper = new Wraper<>("Hello"); //Wrong
  }
}

class Square implements Shape {

}

interface Shape {

}

class Wraper<T extends Shape> {

  private T value;

  public Wraper(T t) {
    this.value = t;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }
}