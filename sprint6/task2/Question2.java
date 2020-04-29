import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee {

  private String name;
  private int experience;
  private BigDecimal basePayment;

  public Employee(String name, int experience, BigDecimal basePayment) {
    this.name = name;
    this.experience = experience;
    this.basePayment = basePayment;
  }

  public String getName() {
    return name;
  }

  public int getExperience() {
    return experience;
  }

  public BigDecimal getPayment() {
    return basePayment;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Employee)) {
      return false;
    }
    Employee employee = (Employee) o;
    return experience == employee.experience &&
        Objects.equals(name, employee.name) &&
        Objects.equals(basePayment, employee.basePayment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, experience, basePayment);
  }

  @Override
  public String toString() {
    return "Employee [" +
        "name=" + name +
        ", experience=" + experience +
        ", basePayment=" + basePayment +
        ']';
  }
}

class Manager extends Employee {

  private double coefficient;

  public Manager(String name, int experience, BigDecimal basePayment, double coefficient) {
    super(name, experience, basePayment);
    this.coefficient = coefficient;
  }

  public double getCoefficient() {
    return coefficient;
  }

  @Override
  public int getExperience() {
    return super.getExperience();
  }

  @Override
  public BigDecimal getPayment() {
    return super.getPayment().multiply(BigDecimal.valueOf(coefficient));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Manager)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    if (!this.getName().equals(((Employee) o).getName())) {
      return false;
    }

    Manager manager = (Manager) o;
    return Double.compare(manager.coefficient, coefficient) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), coefficient);
  }

  @Override
  public String toString() {
    return "Manager [" +
        "name=" + this.getName() +
        ", experience=" + this.getExperience() +
        ", basePayment=" + this.getPayment() +
        ", coefficient=" + coefficient +
        ']';
  }
}

public class MyUtils {

  public List<Employee> largestEmployees(List<Employee> workers) {

    List<Employee> copyList = workers.stream()
        .filter(Objects::nonNull)
        .collect(Collectors.toList());

    int maxExperience = copyList.stream()
        .mapToInt(Employee::getExperience)
        .max()
        .orElse(0);

    int maxPayment = copyList.stream()
        .map(Employee::getPayment)
        .max(BigDecimal::compareTo)
        .orElse(new BigDecimal("0"))
        .intValue();

    List<Employee> maxEmployeeExperienceList = copyList.stream()
        .distinct()
        .filter(x -> x.getExperience() == maxExperience)
        .collect(Collectors.toList());

    List<Employee> maxEmployeePaymentList = copyList.stream()
        .distinct()
        .filter(x -> x.getPayment().intValue() == maxPayment)
        .collect(Collectors.toList());

    return Stream.concat(maxEmployeeExperienceList.stream(), maxEmployeePaymentList.stream())
        .distinct()
        .collect(Collectors.toList());
  }
}

