import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class App {

  public static BinaryOperator<String> greetingOperator = (x, y) -> "Hello " + x + " " + y + "!!!";

  public static List<String> createGreetings(List<Person> people,
      BinaryOperator<String> binaryOperator) {

    return people.stream().map(x -> binaryOperator.apply(x.name, x.surname))
        .collect(Collectors.toList());
  }
}
