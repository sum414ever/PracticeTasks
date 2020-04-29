import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyUtils {

  public List<String> strSort(List<String> originList) {

    List<String> sorted = new ArrayList<>(originList);

    Collections.sort(sorted);

    sorted.sort(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.length() - o2.length();
      }
    });
    return sorted;
  }
}
    
