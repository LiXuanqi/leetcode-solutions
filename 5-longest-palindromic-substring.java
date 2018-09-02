// Manacher
class Solution {
  public String longestPalindrome(String s) {
      if (s == null || s.length() == 0) {
          return "";
      }
      
      // abc => #a#b#c#
      String str = preProcess(s);
      
      // RL[]
      int[] RL = new int[str.length()];
      int maxRight = 0;
      int pos = 0;
      int maxLength = 0;
      int mid = 0;
      for (int i = 1; i < str.length(); i++) {
          int len = 1;
          // pos < i < maxRight
          if (i < maxRight) {
              int mirrorOfI = pos - (i - pos);
              len = Math.min(RL[mirrorOfI], maxRight - i);
          } 
          // try to extend
          while (i - len >= 0 && i + len < str.length() && str.charAt(i - len) == str.charAt(i + len)) {
              len++;    
          }
          // update maxRight
          if (i + len - 1 > maxRight) {
              maxRight = i + len - i;
              pos = i;
          }
          if (len > maxLength) {
              maxLength = len;
              mid = i;
          }
      }
      // delete '#'
      maxLength = maxLength - 1;
      // # 1 # 2 # 1 # 3 #
      //       m=3    maxLength = 3
      //   1   2   1  
      //       m=1    maxLength = 2
      //   
      
      // # 1 # 2 # 2 # 1 # 4 #
      //         m=4     maxLength = 4
      //   1   2   2   1   4
      //       m=1            maxLength = 3
      
      // # b # b #
      //     m=2   maxLength = 3
      //   b   b
      //   m=0     maxLength = 2
      
      // why ?
      int start = (mid - 1) / 2 - (maxLength - 1) / 2;
      return s.substring(start, start + maxLength); 
  }
  private String preProcess(String s) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < s.length(); i++) {
          sb.append('#');
          sb.append(s.charAt(i));
      }
      sb.append('#');
      return sb.toString();
  }
}

// central axis
class Solution {
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() == 0) {
            return "";
        }
        String result = "";
        int flag = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int length = 0;
            if (i != 0) {
                length = isPalindrome(s, i - 1, i);
                if (length > flag) {
                    flag = length;
                    result = s.substring(i - length / 2, i + length / 2);
                }
            }
            length = isPalindrome(s, i, i);
            if (length > flag) {
                flag = length;
                result = s.substring(i - length / 2, i + length / 2 + 1);
            }
        }
        return result;
    }
    private int isPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count += left == right ? 1 : 2;
            left--;
            right++;

        }
        return count;
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