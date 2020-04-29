public class MyUtils {

  public boolean verifyBrackets(String text) {
    text = text.replaceAll("\\\\[\\Q[](){}\\E]", "");

    if (text.length() % 2 != 0) {
      return false;
    } else {

      int size = 0;
      do {
        size = text.length();
        text = text.replace("{}", "");
        text = text.replace("()", "");
        text = text.replace("[]", "");
      } while (size != text.length());

      return text.length() == 0;
    }
  }


}

