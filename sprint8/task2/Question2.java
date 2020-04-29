import java.util.function.Consumer;

public class App {

  public static Consumer<double[]> cons = doubles -> {
    for (int i = 0; i < doubles.length; i++) {
      if (doubles[i] > 2) {
        doubles[i] = doubles[i] * 0.8;
      } else {
        doubles[i] = doubles[i] * 0.9;
      }
    }
  };

  public static double[] getChanged(double[] initialArray, Consumer<double[]> doubleConsumer) {
    double[] in = initialArray.clone();
    doubleConsumer.accept(in);
    return in;
  }
}
