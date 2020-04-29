// Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

// Return the quotient after dividing dividend by divisor.

class Solution {
     public static int divide(int dividend, int divisor) {

    int quotient = 0;

    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;

    } else if (divisor == 1) {
      return dividend;

    } else {
      long d1 = dividend;
      long d2 = divisor;
      d1 = d1 < 0 ? -d1 : d1;
      d2 = d2 < 0 ? -d2 : d2;
      while (d1 >= d2) {
        quotient++;
        d1 -= d2;
      }

      if (dividend < 0 && divisor < 0) {
        return quotient;

      } else if (dividend < 0 || divisor < 0) {
        return -quotient;

      } else {
        return quotient;
    }
  }
}
}
