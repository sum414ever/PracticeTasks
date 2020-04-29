import java.util.ArrayList;
import java.util.Collections;

public class MyUtils {

  public String differentWords(String originalText, String modifyText) {
    String checkedString = "";

    if (originalText.isEmpty()) {
      return modifyText.toUpperCase();

    } else if (modifyText.isEmpty()) {
      return modifyText.toUpperCase();
    }

    ArrayList<String> originalTextSplit = new ArrayList<>();
    ArrayList<String> modifyTextSplit = new ArrayList<>();

    originalText = originalText.replaceAll("\\s+", " ");

    Collections.addAll(originalTextSplit, originalText.trim().split(" "));
    Collections.addAll(modifyTextSplit, modifyText.trim().split(" "));

    while (!originalTextSplit.isEmpty()) {

      if (originalTextSplit.get(0).equals(modifyTextSplit.get(0))) {

        checkedString += originalTextSplit.get(0) + " ";

        originalTextSplit.remove(0);
        modifyTextSplit.remove(0);
      } else {
        checkedString += modifyTextSplit.get(0).toUpperCase() + " ";
        modifyTextSplit.remove(0);
      }
    }
    return modifyTextSplit.isEmpty()
        ? checkedString.substring(0, checkedString.length() - 1)
        : checkedString + modifyTextSplit.get(0).toUpperCase();
  }
}
