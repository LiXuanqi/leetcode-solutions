class Solution {
  public String reverseWords(String s) {
      char[] input = s.toCharArray();
      int slow = 0;
      int fast = 0;
      while (fast < input.length) {
          if (fast == input.length - 1) {
              reverse(input, slow, fast);
              break;
          }
         if (input[fast] != ' ') {
             fast++;
         } else {
             reverse(input, slow, fast - 1);
             fast += 1;
             slow = fast;
         }   
      }
      return new String(input);
  }
  private void reverse(char[] str, int start, int end) {
      while (start <= end) {
          char temp = str[start];
          str[start] = str[end];
          str[end] = temp;
          start++;
          end--;
      }
  }
}

// Time = O(n)
// Space = O(1)