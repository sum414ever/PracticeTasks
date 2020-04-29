import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract class Shape {

  private String name;

  public Shape(String name) {
    this.name = name;
  }

  public abstract double getArea();

  public String getName() {
    return name;
  }
}

class Circle extends Shape {

  private double radius;

  public Circle(String name, double radius) {
    super(name);
    this.radius = radius;
  }

  @Override
  public double getArea() {
    return Math.PI * 2 * radius;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Circle)) {
      return false;
    }
    Circle circle = (Circle) o;
    return Double.compare(circle.radius, radius) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(radius);
  }

  public double getRadius() {
    return radius;
  }

  @Override
  public String toString() {
    return "Circle[" +
        "radius=" + radius +
        ']';
  }
}

class Rectangle extends Shape {

  private double height;
  private double width;

  public Rectangle(String name, double height, double width) {
    super(name);
    this.height = height;
    this.width = width;
  }

  @Override
  public double getArea() {
    return height * width;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Rectangle)) {
      return false;
    }
    Rectangle rectangle = (Rectangle) o;
    return Double.compare(rectangle.height, height) == 0 &&
        Double.compare(rectangle.width, width) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(height, width);
  }

  public double getHeight() {
    return height;
  }

  public double getWidth() {
    return width;
  }

  @Override
  public String toString() {
    return "Rectangle[" +
        "height=" + height +
        ", width=" + width +
        ']';
  }
}

public class MyUtils {

  public List<Shape> maxAreas(List<Shape> shapes) {

    List<Shape> maxAreasList = shapes.stream()
        .filter(Objects::nonNull)
        .collect(Collectors.toList());

    double maxCircleArea = maxAreasList.stream()
        .filter(x -> x instanceof Circle)
        .map(x -> (Circle) x)
        .mapToDouble(Circle::getArea)
        .max()
        .orElse(0.00);

    double maxRectangleArea = maxAreasList.stream()
        .filter(x -> x instanceof Rectangle)
        .map(x -> (Rectangle) x)
        .mapToDouble(Rectangle::getArea)
        .max()
        .orElse(0.00);

    List<Shape> maxCircle = maxAreasList.stream()
        .filter(x -> x instanceof Circle)
        .map(x -> (Circle) x)
        .distinct()
        .filter(x -> x.getArea() == maxCircleArea)
        .map(x -> (Shape) x)
        .collect(Collectors.toList());

    List<Shape> maxRectangle = maxAreasList.stream()
        .filter(x -> x instanceof Rectangle)
        .map(x -> (Rectangle) x)
        .distinct()
        .filter(x -> x.getArea() == maxRectangleArea)
        .map(x -> (Shape) x)
        .collect(Collectors.toList());

    return Stream.concat(maxCircle.stream(), maxRectangle.stream())
        .collect(Collectors.toList());
  }
}

