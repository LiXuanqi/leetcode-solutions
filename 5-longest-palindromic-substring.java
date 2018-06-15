// central axis
class Solution {
  public String longestPalindrome(String s) {
      // [1, 2]
      // [1, 2, 3]
      int start = 0, len = 0, longest = 0;
      for (int i = 0; i < s.length(); i++) {
          // central axis is on the number.
          // "1 2 1 4"
          //    l
          //    r  len = 3
          len = isPalindrome(s, i, i);
          if (len > longest) {
              longest = len;
              start = i - len / 2;
          }
          // central axis is between two numbers.
          // "1 2 2 1 4"
          //    l r    len = 4
          len = isPalindrome(s, i, i + 1);
          if (len > longest) {
              longest = len;
              start = i - len / 2 + 1;
          }         
      }
      return s.substring(start, start + longest);
  }
  private int isPalindrome (String str, int left, int right) {
      int len = 0;
      while (left >= 0 && right < str.length()) {
          if (str.charAt(left) != str.charAt(right)) {
              break;
          }
          len += left == right ? 1 : 2;
          left--;
          right++;
      }
      return len;
  }
}

// Brute-force
class Solution {
  public String longestPalindrome(String s) {
      String longest = "";
      for (int i = 0; i < s.length(); i++) {
          for (int j = s.length() - 1; j >= 0; j--) {
              if (j - i + 1 < longest.length()) {
                  break;
              }
              if (isPalindrome(s, i, j)) {
                  if (j - i + 1 > longest.length()) {
                      longest = s.substring(i, j + 1);
                  }
              }
          }
      }
      return longest;
  }
  private boolean isPalindrome(String s, int start, int end) {
      while (start < end) {
          if (s.charAt(start) != s.charAt(end)) {
              return false;
          }
          start++;
          end--;
      }
      return true;
  }
}