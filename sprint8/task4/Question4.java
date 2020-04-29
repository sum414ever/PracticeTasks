import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface DecisionMethod {

  boolean decide(String productName, int discount);
}

class Person {

  String name;
  DecisionMethod goShopping = (productName1, discount1) -> productName1.equals("product1")
      && discount1 > 10;

  Person(String name) {
    this.name = name;
  }
}

class Shop {

  public List<DecisionMethod> clients = new ArrayList<>();

  public int sale(String product, int percent) {

    return (int) clients.stream()
        .filter(decisionMethod -> decisionMethod.decide(product, percent))
        .count();
  }
}
