import java.util.Arrays;
import java.util.function.Predicate;

public class MyUtils {

  public static int getCount(int[] intArr, Predicate<Integer> integerPredicate) {

    return (int) Arrays.stream(intArr).filter(integerPredicate::test).count();
  }
}
