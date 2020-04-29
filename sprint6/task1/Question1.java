import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Person {

  private String name;

  public Person(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}

class Student extends Person {

  private String studyPlace;
  private int studyYears;

  public Student(String name, String studyPlace, int studyYears) {
    super(name);
    this.studyPlace = studyPlace;
    this.studyYears = studyYears;
  }

  public String getStudyPlace() {
    return studyPlace;
  }

  public int getStudyYears() {
    return studyYears;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Student)) {
      return false;
    }
    if (!this.getName().equals(((Student) o).getName())) {
      return false;
    }
    Student student = (Student) o;
    return studyYears == student.studyYears &&
        studyPlace.equals(student.studyPlace);
  }

  @Override
  public int hashCode() {
    return Objects.hash(studyPlace, studyYears);
  }

  @Override
  public String toString() {
    return "Student [" +
        "name=" + super.getName() +
        ", studyPlace='" + studyPlace + '\'' +
        ", studyYears=" + studyYears +
        ']';
  }
}

class Worker extends Person {

  private String workPosition;
  private int experienceYears;

  public Worker(String name, String workPosition, int experienceYears) {
    super(name);
    this.workPosition = workPosition;
    this.experienceYears = experienceYears;
  }

  public String getWorkPosition() {
    return workPosition;
  }

  public int getExperienceYears() {
    return experienceYears;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Worker)) {
      return false;
    }
    if (!this.getName().equals(((Worker) o).getName())) {
      return false;
    }
    Worker worker = (Worker) o;
    return experienceYears == worker.experienceYears &&
        workPosition.equals(worker.workPosition);
  }

  @Override
  public int hashCode() {
    return Objects.hash(workPosition, experienceYears);
  }

  @Override
  public String toString() {
    return "Worker [" +
        "name=" + super.getName() +
        ", workPosition='" + workPosition + '\'' +
        ", experienceYears=" + experienceYears +
        ']';
  }
}

public class MyUtils {

  public List<Person> maxDuration(List<Person> persons) {
    int maxStudyYears = persons.stream()
        .filter(x -> x instanceof Student)
        .map(x -> (Student) x)
        .distinct()
        .mapToInt(Student::getStudyYears)
        .max()
        .orElse(0);

    int maxExperienceYears = persons.stream()
        .filter(x -> x instanceof Worker)
        .map(x -> (Worker) x)
        .distinct()
        .mapToInt(Worker::getExperienceYears)
        .max()
        .orElse(0);

    List<Person> maxStudents = persons.stream()
        .filter(x -> x instanceof Student)
        .map(x -> (Student) x)
        .distinct()
        .filter(x -> x.getStudyYears() == maxStudyYears)
        .map(x -> (Person) x)
        .collect(Collectors.toList());

    List<Person> maxWorkers = persons.stream()
        .filter(x -> x instanceof Worker)
        .map(x -> (Worker) x)
        .distinct()
        .filter(x -> x.getExperienceYears() == maxExperienceYears)
        .map(x -> (Person) x)
        .collect(Collectors.toList());

    return Stream.concat(maxStudents.stream(), maxWorkers.stream())
        .collect(Collectors.toList());
  }
}

