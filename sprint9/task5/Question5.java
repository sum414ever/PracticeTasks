public class MyUtils {

  public String reformatLines(String text) {
    text = text.replaceAll("\n", " ");
    text = text.replaceAll("\\s+", " ");

    String ret = "";
    String meta = "";

    String[] s = text.trim().split(" ");
    for (String d : s) {
      if (meta.length() + d.length() <= 60) {
        meta += d + " ";
      } else {
        ret += meta.substring(0, meta.length() - 1) + "\n";
        meta = d + " ";
      }
    }
    return ret + meta.substring(0, meta.length() - 1);
  }
}
