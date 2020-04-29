import java.time.LocalDateTime;

class User {

  protected String name;
  protected String surname;

  public User(String name, String surname) {
    this.name = name;
    this.surname = surname;
  }

  public String getFullName() {
    return name + " " + surname;
  }
}

class Student extends User {

  protected int year;

  public Student(int year, String name, String surname) {
    super(name, surname);
    this.year = year;
  }

  public int getCourseNumber() {
    int diff = LocalDateTime.now().getYear() == year ? 1 : LocalDateTime.now().getYear() - year + 1;
    return diff < 7 && diff > 0 ? diff : -1;
  }
}
