// Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
class Solution {
    public boolean isPalindrome(int x) {
        
    boolean isNegative = x < 0;
    int palindrome = x;
    int reverce = 0;

    while (x != 0) {
      reverce = reverce * 10 + x % 10;
      x /= 10;
    }

    return isNegative ? false : reverce == palindrome;
  }
}
