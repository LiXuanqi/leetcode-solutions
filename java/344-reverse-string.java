class Solution {
  public String reverseString(String s) {
      if (s == null || s.length() == 0) {
          return s;
      }
      char[] input = s.toCharArray();
      int left = 0;
      int right = input.length - 1;
      while (left <= right) {
          swap(input, left, right);
          left++;
          right--;
      }
      return new String(input);   
  }
  private void swap(char[] str, int left, int right) {
      char temp = str[left];
      str[left] = str[right];
      str[right] = temp;
  }
}

// recursion (Memory Limit Exceeded)
class Solution {
  public String reverseString(String s) {
      if (s == null) {
          return null;
      }
      if (s.length() <= 1) {
          return s;
      }
      return s.charAt(s.length() - 1) + reverseString(s.substring(1, s.length() - 1)) + s.charAt(0); 
  }
}