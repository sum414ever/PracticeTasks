import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

abstract class Figure {

  public abstract double getPerimeter();
}

class Square extends Figure {

  private double width;

  public Square(double width) {
    this.width = width;
  }

  @Override
  public double getPerimeter() {
    return width * 4;

  }
}

class Rectang extends Figure {

  private double width;
  private double height;

  public Rectang(double width, double height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public double getPerimeter() {
    return (width + height) * 2;
  }
}

public class MyUtils {

  public double sumPerimeter(List<?> figures) {

    List<Figure> f = new ArrayList<>();

    for (Object o : figures) {
      f.add((Figure) o);
    }

    return f.stream()
        .filter(Objects::nonNull)
        .map(Figure::getPerimeter)
        .mapToDouble(d -> d).sum();
  }
}


