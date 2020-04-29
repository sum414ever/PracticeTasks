import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface DrinkReceipt {

  String getName();

  DrinkReceipt addComponent(String componentName, int componentCount);
}


interface DrinkPreparation {

  Map<String, Integer> makeDrink();
}

interface Rating {

  int getRating();
}


class Caffee implements DrinkReceipt, DrinkPreparation, Rating {

  private String name;
  private int rating;
  private Map<String, Integer> ingredients;

  public Caffee(String name, int rating) {
    this.name = name;
    this.rating = rating;

    makeDrink();
  }

  @Override
  public DrinkReceipt addComponent(String componentName, int componentCount) {
    ingredients.put(componentName, componentCount);
    return this;
  }

  @Override
  public Map<String, Integer> makeDrink() {

    ingredients = new HashMap<>();
    addComponent("Water", 100);
    addComponent("Arabica", 20);
    return ingredients;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getRating() {
    return rating;
  }

  public Map<String, Integer> getIngredients() {
    return ingredients;
  }


  @Override
  public String toString() {
    return "Caffee[" +
        "name='" + name + '\'' +
        ", rating=" + rating +
        ", ingredients=" + ingredients +
        ']';
  }
}

class Espresso extends Caffee {

  private Map<String, Integer> ingredients;

  public Espresso(String name, int rating) {
    super(name, rating);

    makeDrink();
  }

  @Override
  public DrinkReceipt addComponent(String componentName, int componentCount) {
    ingredients.put(componentName, componentCount);
    return this;
  }

  @Override
  public Map<String, Integer> makeDrink() {
    ingredients = new HashMap<>();
    addComponent("Water", 50);
    addComponent("Arabica", 20);
    return ingredients;
  }

}

class Cappuccino extends Caffee {

  private Map<String, Integer> ingredients;

  public Cappuccino(String name, int rating) {
    super(name, rating);

    makeDrink();
  }

  @Override
  public DrinkReceipt addComponent(String componentName, int componentCount) {
    ingredients.put(componentName, componentCount);
    return this;
  }

  @Override
  public Map<String, Integer> makeDrink() {

    ingredients = new HashMap<>();
    addComponent("Water", 100);
    addComponent("Arabica", 20);
    addComponent("Milk", 50);
    return ingredients;
  }
}

public class MyUtils {

  public Map<String, Double> averageRating(List<Caffee> coffees) {

    Map<String, Double> averageRating = new HashMap<>();

    for (Caffee caffee : coffees) {
      if (averageRating.containsKey(caffee.getName())) {
        Double avg = (averageRating.get(caffee.getName()) + (double) caffee.getRating()) / 2;
        averageRating.put(caffee.getName(), avg);
      } else {
        averageRating.put(caffee.getName(), (double) caffee.getRating());
      }
    }
    return averageRating;
  }
}

