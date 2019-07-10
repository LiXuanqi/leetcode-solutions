class Solution {
  public int myAtoi(String str) {
      if (str == null) {
          return 0;
      }
      // skip all whitespace.
      int pointer = 0;
      while (pointer < str.length() && str.charAt(pointer) == ' ') {
          pointer++;
      }
      if (pointer == str.length() || str.charAt(pointer) != '-' && str.charAt(pointer) != '+' && !Character.isDigit(str.charAt(pointer))) {
          return 0;
      }
      boolean isNegative = false;

      if (str.charAt(pointer) == '-' || str.charAt(pointer) == '+') {
          if (str.charAt(pointer) == '-') {
              isNegative = true;
          }
          pointer++;
      }
      int start = pointer;
      int end = pointer;
      while (end < str.length() && Character.isDigit(str.charAt(end))) {
          end++;
      }
      // string to int
      long sum = 0;
      while (start < end) {
          sum = (str.charAt(start) - '0') + sum * 10;
          start++;
          // check overflow.
          if (sum > Integer.MAX_VALUE) {
             break;
          }
      }
      sum = isNegative ? 0 - sum : sum;
      if (sum > Integer.MAX_VALUE) {
          return Integer.MAX_VALUE;
      }
      if (sum < Integer.MIN_VALUE) {
          return Integer.MIN_VALUE;
      }
      return (int)sum;
  }
}