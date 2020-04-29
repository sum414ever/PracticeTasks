public class MyUtils {
  // все це набагато простіше робити регулярними виразами
  // Переглянь на hyperskill.org це ось уроки з практичними завданнями:
  // https://hyperskill.org/learn/step/7580
  // https://hyperskill.org/learn/step/3670
  // https://hyperskill.org/learn/step/3674
  // https://hyperskill.org/learn/step/3680
  // https://hyperskill.org/learn/step/3687
  public static boolean isConsonant(char isConsonant) {
    // в таких випадках можна створити final static Set<Character>, наповнити
    // елементами і потім перевіряти методом contains чи елемент є у множині, чи ні
    char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
        'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'};
    for (char consonant : consonants) {
      if (consonant == Character.toLowerCase(isConsonant)) {
        return true;
      }
    }
    return false;
  }

  public static boolean haveDash(String word) {
    // return word.contains("-"); зробить те саме
    char[] chars = word.toCharArray();
    for (char dash : chars) {
      if (dash == '-') {
        return true;
      }
    }
    return false;
  }

  public static boolean hasPunctuationsMarks(String word) {
    // якщо перевіряється слово, то знаки пунутуації можуть бути лише в останньому символі
    char[] punctuationsMarks = {'.', ',', '!', '?'};
    char last = word.charAt(word.length() - 1);
    for (char punctuationsMark : punctuationsMarks) {
      if (punctuationsMark == last) {
        return true;
      }
    }
    return false;
  }

  public static String changeConsonantWord(String word) {
    String addToTheEnd = "ay";
    int consonantCount = 0;

    char[] chars = word.toCharArray();
    for (char c : chars) {
      if (isConsonant(c)) {
        consonantCount++;
      } else {
        break;
      }
    }

    word = word.substring(consonantCount) + word.substring(0, consonantCount);
    return word + addToTheEnd;
  }

  public static String changeVowelWord(String word) {
    String addToTheEnd = "hay";
    return word + addToTheEnd;
  }

  public String pigLatinConverter(String text) {
    if (text.isEmpty()) {
      return "";
    }
    String[] words = text.split(" ");
    String pigLatin = "";

    for (String word : words) {

      if (haveDash(word)) {

        String first = word.split("-")[0];
        String second = word.split("-")[1];
        String dash = "-";
        String punctuationMarks = "";

        if (hasPunctuationsMarks(second)) {

          punctuationMarks = second.substring(second.length() - 1);
          second = second.substring(0, second.length() - 1);
        }

        first = isConsonant(first.charAt(0))
            ? changeConsonantWord(first)
            : changeVowelWord(first);

        second = isConsonant(second.charAt(0))
            ? changeConsonantWord(second) + punctuationMarks
            : changeVowelWord(second) + punctuationMarks;

        pigLatin += first + dash + second + " ";

      } else if (hasPunctuationsMarks(word)) {

        String punctuationMarks = word.substring(word.length() - 1);
        word = word.substring(0, word.length() - 1);

        word = isConsonant(word.charAt(0))
            ? changeConsonantWord(word) + punctuationMarks
            : changeVowelWord(word) + punctuationMarks;
        pigLatin += word + " ";
      } else {
        word = isConsonant(word.charAt(0))
            ? changeConsonantWord(word)
            : changeVowelWord(word);
        pigLatin += word + " ";
      }
    }

    return pigLatin.substring(0, pigLatin.length() - 1);
  }
}

