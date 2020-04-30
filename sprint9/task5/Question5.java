public class MyUtils {

  static final int MAX_LENGTH = 60;

  public String reformatLines(String text) {
    text = text.replaceAll("\\s+", " ");

    String ret = "";
    String meta = "";

    String[] words = text.trim().split(" ");
    for (String word : words) {
      if (meta.length() + word.length() <= MAX_LENGTH) {
        meta += word + " ";
      } else {
        ret += meta.substring(0, meta.length() - 1) + "\n";
        meta = word + " ";
      }
    }
    return ret + meta.substring(0, meta.length() - 1);
  }
}
