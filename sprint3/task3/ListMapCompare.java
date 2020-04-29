import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyUtils {

  public boolean listMapCompare(List<String> list, Map<String, String> map) {

    Set<String> valueByMap = new HashSet<>();

    for (Map.Entry<String, String> entry : map.entrySet()) {
      valueByMap.add(entry.getValue());
    }

    valueByMap.removeAll(list);

    return valueByMap.isEmpty();
  }
}
