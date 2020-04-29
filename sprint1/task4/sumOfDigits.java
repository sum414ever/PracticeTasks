public static int sumOfDigits(int number) {
    
    String s = Integer.toString(number);
   
    int result = 0;

    int[] sum = new int[s.length()];

    for (int i = 0; i < s.length(); i++) {
      result += Character.getNumericValue(s.charAt(i));
    }
    return result;
}
