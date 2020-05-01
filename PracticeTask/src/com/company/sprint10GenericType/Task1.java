package com.company.sprint10GenericType;

//Create a Wrapper generic class with generic private field of type T named value.
//Also in the Wrapper class define a parametrized public constructor and access methods with setValue and getValue name.

public class Task1 {

}

class Wrapper<T>{

  private  T value;

  public Wrapper(T t){
    this.value = t;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }
}