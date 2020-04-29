import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

class MyUtils {

  public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr) {

    int max = 0;
    for (int i = 0; i < numbers.size(); i++) {
      if (pr.test(numbers.get(i))) {
        max = numbers.get(i);
      }
    }
    return max;
  }
}

class User {

  public final List<Integer> values = new ArrayList<Integer>();

  int getFilterdValue(BiFunction<List<Integer>, Predicate<Integer>, Integer> function,
      Predicate<Integer> predicate) {

    return function.apply(values, predicate);
  }

  int getMaxValueByCondition(Predicate<Integer> pr) {
    return getFilterdValue(MyUtils::findMaxByCondition, pr);
  }
}
