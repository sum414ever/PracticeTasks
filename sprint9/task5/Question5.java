public class MyUtils {

  public String reformatLines(String text) {
    text = text.replaceAll("\n", " ");  // тут, можливо, помилка, бо replaceAll працює з регексом, а там новий рядок задається як \n
                                        // але, щоб він став таким, в java-рядку бекслеш треба подвоювати
    text = text.replaceAll("\\s+", " "); // класс \\s включає до себе й символ нового рядку

    String ret = "";
    String meta = "";

    String[] s = text.trim().split(" "); // назви змінних мають бути читабельні, words було б OK
    for (String d : s) { // те саме, краще було б назвати for (String word : words)
      if (meta.length() + d.length() <= 60) { // константі 60 краще дати назву та винести в static final
        meta += d + " ";
      } else {
        ret += meta.substring(0, meta.length() - 1) + "\n";
        meta = d + " ";
      }
    }
    return ret + meta.substring(0, meta.length() - 1);
  }
}
