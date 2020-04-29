public class MyUtils {

  public boolean verifyBrackets(String text) {
    text = text.replaceAll("\\\\[\\Q[](){}\\E]", "");
    //
    // це класичний алгоритм на застосування структури даних стек.
    // подивись https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
    if (text.length() % 2 != 0) {
      return false;
    } else {

      int size = 0;
      do {
        size = text.length();
        text = text.replace("{}", ""); // це працюватиме лише якщо там нема інших символів
        text = text.replace("()", ""); // до того ж для довгого рядка за одну ітерацію буде
        text = text.replace("[]", ""); // видалятись лише по два символи і створюватиметься
      } while (size != text.length()); // новий рядок. Тому ефективність буде квадратичною O(n^2)

      return text.length() == 0;
    }
  }


}
