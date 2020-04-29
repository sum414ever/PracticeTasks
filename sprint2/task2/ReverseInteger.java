// Given a 32-bit signed integer, reverse digits of an integer.
class Solution {
    public int reverse(int x) {
    
    long reverce = 0;

    while (x != 0) {
      reverce = reverce * 10 + x % 10;
      x /= 10;
    }
    
    return reverce < Integer.MIN_VALUE || reverce > Integer.MAX_VALUE ? 0 : (int) reverce;
    }
}
