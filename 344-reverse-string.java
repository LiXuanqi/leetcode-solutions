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