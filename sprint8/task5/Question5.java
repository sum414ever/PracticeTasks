import java.util.Set;
import java.util.function.Predicate;

class MyUtils {

  public static Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>> predicateSet) {

    return predicateSet.stream().reduce(x -> true, Predicate::and);
  }
}

