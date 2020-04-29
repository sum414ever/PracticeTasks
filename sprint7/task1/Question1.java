class Pizza {

  private String cheese;
  private String meat;
  private String seafood;
  private String vegetable;
  private String mushroom;

  private Pizza() {
  }

  public static PizzaBuilder base() {
    return new PizzaBuilder();
  }

  public static class PizzaBuilder {

    Pizza pizza = new Pizza();

    private PizzaBuilder() {

    }

    public PizzaBuilder addCheese(String cheese) {
      pizza.cheese = cheese;
      return PizzaBuilder.this;
    }

    public PizzaBuilder addMeat(String meat) {
      pizza.meat = meat;
      return PizzaBuilder.this;
    }

    public PizzaBuilder addSeafood(String seafood) {
      pizza.seafood = seafood;
      return PizzaBuilder.this;
    }

    public PizzaBuilder addVegetable(String vegetable) {
      pizza.vegetable = vegetable;
      return PizzaBuilder.this;
    }

    public PizzaBuilder addMushroom(String mushroom) {
      pizza.mushroom = mushroom;
      return PizzaBuilder.this;
    }

    public Pizza build() {
      return pizza;
    }
  }
}

class Oven {

  public static Pizza cook() {

    return Pizza.base().addCheese("100").addMeat("100").addMushroom("100").addSeafood("100")
        .addVegetable("100").build();
  }
}
