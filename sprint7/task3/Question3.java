  public static void addAtoB(int a, int b) {
    execute(a, b, Integer::sum);
  }

  public static void subtractBfromA(int a, int b) {

    execute(a, b, (a1, b1) -> a1 - b1);
  }

  public static void multiplyAbyB(int a, int b) {

    execute(a, b, (a1, b1) -> a1 * b1);
  }

  public static void divideAbyB(int a, int b) {
    execute(a, b, (a1, b1) -> a1 / b1);
  }
