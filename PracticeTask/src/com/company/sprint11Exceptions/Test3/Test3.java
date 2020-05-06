package com.company.sprint11Exceptions.Test3;


//Suppose, we class Plant from the task2, which includes private fields String name,
//    Color color and Type type, and constructor with three String parameters where these fields are initialized.
//    Color and Type are Enum.
//    Color contains White, Red, Blue entries.
//    Type contains Rare and Available entries.
//
//    And we have classes ColorException and TypeException as derived from Exception.
//
//    The constructor of Plant throws a corresponding exception whenever an inappropriate parameter is passed.
//    (public Plant(String type, String color, String name) throws ColorException, TypeException)
//
//    Write a static tryCreatePlant method that takes 3 string parameters - type,
//    color and name and returns an instance of Plant, created based on passed params.
//    (Don't create any classes, write as if you are already inside a class.)
//    The tryCreatePlant method should catch exceptions that can be thrown.
//    If inappropriate type passed as a parameter, a Plant object should be returned anyway, with Ordinary type.
//    If an inappropriate color is passed, set Red color for created instance.

import java.util.Arrays;

public class Test3 {

  public static void main(String[] args) {
    Plant p = Plant.tryCreatePlant("re", "ed", "name");
    System.out.println(p.toString());
  }
}

enum Color {
  White, Red, Blue
}

enum Type {
  Rare,Ordinary
}

class Plant {

  private String name;
  private Color color;
  private Type type;

  public Plant(String type, String color, String name) throws ColorException, TypeException {
    this.name = name;

    long checkColor = Arrays.stream(Color.values())
        .filter(c -> c.name().equals(color))
        .count();
    if(checkColor > 0){
      this.color = Enum.valueOf(Color.class,color);
    }else {
      throw new ColorException("Color is wrong");
    }

    long checkType = Arrays.stream(Type.values())
        .filter(c -> c.name().equals(type))
        .count();
    if(checkType > 0){
      this.type = Enum.valueOf(Type.class,type);
    }else {
      throw new TypeException("Type is wrong");
    }
  }


  public static Plant tryCreatePlant(String type, String color, String name){
    try {
      return new Plant(type,color,name);
    } catch (ColorException e) {
      color = Color.Red.toString();
      return tryCreatePlant(type,color,name);
    } catch (TypeException e) {
      type = Type.Ordinary.toString();
      return tryCreatePlant(type,color,name);
    }
  }

  @Override
  public String toString() {
    return "{type: " + type + ", color: " + color + ", name: " + name;
  }
}

class ColorException extends Exception {

  public ColorException(String message) {
    super(message);
  }

}

class TypeException extends Exception {

  public TypeException(String message) {
    super(message);
  }
}
