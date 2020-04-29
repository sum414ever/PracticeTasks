class Person {

  int age;
  String healthInfo;
  String name;

  public Person(int age, String healthInfo, String name) {
    this.age = age;
    this.healthInfo = healthInfo;
    this.name = name;
  }

  String getHealthStatus() {
    return name + " " + healthInfo;
  }
}

class Child extends Person {

  String healthInfo;
  String name;
  String childIDNumber;


  public Child(int age, String healthInfo, String name, String childIDNumber) {
    super(age, healthInfo, name);
    this.healthInfo = healthInfo;
    this.name = name;
    this.childIDNumber = childIDNumber;
  }

  String getHealthStatus() {
    return name + " " + healthInfo;
  }
}

class Adult extends Person {

  String healthInfo;
  String name;
  String passportNumber;

  public Adult(int age, String healthInfo, String passportNumber, String name) {
    super(age, healthInfo, name);
    this.passportNumber = passportNumber;
    this.healthInfo = healthInfo;
    this.name = name;
  }

  String getHealthStatus() {
    return name + " " + healthInfo;
  }
}
