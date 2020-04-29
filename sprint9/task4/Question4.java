import java.util.ArrayList;
import java.util.Collections;

public class MyUtils {

  public String differentWords(String originalText, String modifyText) {
    String checkedString = "";

    if (originalText.isEmpty()) {
      return modifyText.toUpperCase();

    } else if (modifyText.isEmpty()) { // можна не писати else, бо попередня гілка завершується з return
      return modifyText.toUpperCase(); // в чому сенс змінювати case порожнього рядку?
    }

    ArrayList<String> originalTextSplit = new ArrayList<>();
    ArrayList<String> modifyTextSplit = new ArrayList<>();

    originalText = originalText.replaceAll("\\s+", " ");

    Collections.addAll(originalTextSplit, originalText.trim().split(" "));
    Collections.addAll(modifyTextSplit, modifyText.trim().split(" "));

    while (!originalTextSplit.isEmpty()) {

      if (originalTextSplit.get(0).equals(modifyTextSplit.get(0))) {

        checkedString += originalTextSplit.get(0) + " "; // StringBuilder для додавання в кінець
                                                    // тут можуть з'являтись зайві пробіли

        originalTextSplit.remove(0); // ArrayList не підходить для операцій видалення с початку, бо при цьому 
        modifyTextSplit.remove(0);  // всі елементи копіюються ліворуч. Для того є інтерфейс Deque та імплементація ArrayDeque
                                    // якщо ж треба лише видаляти з початку, а додавати с кінця - то Queue
      } else {
        checkedString += modifyTextSplit.get(0).toUpperCase() + " "; // тут можуть з'являтись зайві пробіли
        modifyTextSplit.remove(0); // замість видалення з голови можна зсувати змінну-індекс вздовж масива
      }
    }
    return modifyTextSplit.isEmpty()
        ? checkedString.substring(0, checkedString.length() - 1)
        : checkedString + modifyTextSplit.get(0).toUpperCase(); // чому лише одне слово, а якщо там кілька доданих слів лишилось?
  }
}
