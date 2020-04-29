import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyUtils {

  public Map<String, List<String>> createNotebook(Map<String, String> phones) {

    Map<String, List<String>> people = new HashMap<>();

    for (Map.Entry<String, String> persone : phones.entrySet()) {

      if (people.get(persone.getValue()) == null) {

        List<String> numbers = new ArrayList<>();
        numbers.add(persone.getKey());

        people.put(persone.getValue(), numbers);
      } else {
        List<String> numbers = people.get(persone.getValue());
        numbers.add(persone.getKey());
        people.put(persone.getValue(), numbers);
      }
    }
    return people;
  }
}
