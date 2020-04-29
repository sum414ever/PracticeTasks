public class MyUtils {

  static final String[] romanLetters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
  static final int[] numerals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

  public String intToRoman(int number) {

    StringBuilder roman = new StringBuilder();

    if (number < 0 && number > 4000) {
      throw new IllegalArgumentException();
    }

    for (int i = 0; i < romanLetters.length; i++) {

      while (number >= numerals[i]) {
        roman.append(romanLetters[i]);
        number -= numerals[i];
      }
    }
    return roman.toString();
  }
}