package com.company.sprint10GenericType;

//    Create classes with name PersonComparator, EmployeeComparator, DeveloperComparator that implenent the Comparator<Type> generic interface.
//
//    In the Utility class create public static method named sortPeople(...) that takes an array of Person type and derivative from it types,
//    and comparator as input, and returns the value of void type.
//
//    Also, as second argument the method sortPeople(...) can takes generic comparator for elements of Object type.
//
//    The sortPeople(...) method should sorted records by ascending. At first by name, then by age, then by salary, and then by Level (JUNIOR < MIDDLE < SENIOR)

import java.util.Arrays;
import java.util.Comparator;

enum Level {
  JUNIOR, MIDDLE, SENIOR;
}

public class Task5 {

  public static void main(String[] args) {

    //smoke test
    Person[] peopleIn = {
        new Person("Nick", 27),
        new Person("Bart", 38),
        new Person("Nick", 21),
        new Person("Sara", 24),
        new Person("Bart", 38),
    };
    Person[] peopleOut = {
        new Person("Bart", 38),
        new Person("Bart", 38),
        new Person("Nick", 21),
        new Person("Nick", 27),
        new Person("Sara", 24),
    };

    Utility.sortPeople(peopleIn, new PersonComparator());
    boolean testPeopleResult = true;
    for (int i = 0; i < peopleIn.length; i++) {
      testPeopleResult = peopleIn[i].toString().equals(peopleOut[i].toString());
    }
    System.out.println("People test is: " + testPeopleResult);

    Employee[] employeesIn = {
        new Employee("Nick", 27, 2850.55),
        new Employee("Sara", 24, 2950.35),
        new Employee("Bart", 38, 3165.75),
        new Employee("Nick", 21, 1940.25),
        new Employee("Sara", 24, 2260.65),
        new Employee("Bart", 38, 3165.75)
    };

    Employee[] employeesOut = {
        new Employee("Bart", 38, 3165.75),
        new Employee("Bart", 38, 3165.75),
        new Employee("Nick", 21, 1940.25),
        new Employee("Nick", 27, 2850.55),
        new Employee("Sara", 24, 2260.65),
        new Employee("Sara", 24, 2950.35)
    };

    Utility.sortPeople(employeesIn, new EmployeeComparator());
    boolean testEmployeeResult = true;
    for (int i = 0; i < employeesIn.length; i++) {
      testEmployeeResult = employeesIn[i].toString().equals(employeesOut[i].toString());
    }
    System.out.println("Employee test is: " + testEmployeeResult);

    Developer[] developersIn = {
        new Developer("Nick", 27, 2850.55, Level.MIDDLE),
        new Developer("Sara", 24, 2950.35, Level.SENIOR),
        new Developer("Bart", 38, 3165.75, Level.MIDDLE),
        new Developer("Nick", 21, 1940.25, Level.JUNIOR),
        new Developer("Sara", 24, 2260.65, Level.MIDDLE),
        new Developer("Bart", 38, 3165.75, Level.JUNIOR)
    };

    Developer[] developersOut = {
        new Developer("Bart", 38, 3165.75, Level.JUNIOR),
        new Developer("Bart", 38, 3165.75, Level.MIDDLE),
        new Developer("Nick", 21, 1940.25, Level.JUNIOR),
        new Developer("Nick", 27, 2850.55, Level.MIDDLE),
        new Developer("Sara", 24, 2260.65, Level.MIDDLE),
        new Developer("Sara", 24, 2950.35, Level.SENIOR)
    };

    Utility.sortPeople(developersIn, new DeveloperComparator());
    boolean testDeveloperResult = true;
    for (int i = 0; i < developersIn.length; i++) {
      testDeveloperResult = developersIn[i].toString().equals(developersOut[i].toString());
    }
    System.out.println("Developer test is: " + testDeveloperResult);
  }
}

class Person {

  protected String name;
  protected int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}

class Employee extends Person {

  private double salary;

  public Employee(String name, int age, double salary) {
    super(name, age);
    this.salary = salary;
  }

  public double getSalary() {
    return salary;
  }

  @Override
  public String toString() {
    return super.toString() +
        ", salary=" + salary +
        '}';
  }
}

class Developer extends Employee {

  private Level level;

  public Developer(String name, int age, double salary, Level level) {
    super(name, age, salary);
    this.level = level;
  }

  public Level getLevel() {
    return level;
  }

  @Override
  public String toString() {
    return super.toString() +
        "level=" + level +
        '}';
  }
}

class PersonComparator implements Comparator<Person> {

  @Override
  public int compare(Person o1, Person o2) {
    if (o1.getName().compareTo(o2.getName()) == 0) {
      return Integer.compare(o1.getAge(), o2.getAge());
    }
    return o1.getName().compareTo(o2.getName());
  }
}

class EmployeeComparator implements Comparator<Employee> {

  PersonComparator pc = new PersonComparator();

  @Override
  public int compare(Employee o1, Employee o2) {
    if (pc.compare(o1, o2) == 0) {
      return Double.compare(o1.getSalary(), o2.getSalary());
    }
    return pc.compare(o1, o2);
  }
}

class DeveloperComparator implements Comparator<Developer> {

  EmployeeComparator ec = new EmployeeComparator();

  @Override
  public int compare(Developer o1, Developer o2) {
    if (ec.compare(o1, o2) == 0) {
      return o1.getLevel().compareTo(o2.getLevel());
    }
    return ec.compare(o1, o2);
  }
}

class Utility {

  public static <T extends Person> void sortPeople(T[] a, Comparator<? super T> c) {
    Arrays.sort(a, c);
  }
}