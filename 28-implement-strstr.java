// Rabin Karp
class Solution {
  private final int BASE = 1000000;
  public int strStr(String haystack, String needle) {
      int targetLength = needle.length();
      if (targetLength == 0) {
          return 0;
      }
      if (haystack.length() == 0 || haystack.length() < targetLength) {
          return -1;
      }
      int targetCode = calculateHashCode(needle);
      // abc => 31^2
      int help = 1;
      for (int i = 0; i < targetLength - 1; i++) {
          help = help * 31 % BASE;
      }
      int code = calculateHashCode(haystack.substring(0, targetLength));
      for (int i = 0 ; i < haystack.length() - targetLength + 1; i++) {
              // abcd
              // abc => bcd
          if (i != 0) {
             code = calculateNewHashCode(code, haystack.charAt(i - 1), haystack.charAt(i + targetLength - 1), help);
          }
          System.out.println(code);
          System.out.println(targetCode);
          if (code == targetCode) {
              if (check(needle, haystack.substring(i, i + targetLength))) {
                  return i;
              }
          } 
      }
      return -1;
  }
  private int calculateNewHashCode(int oldCode, char last, char next, int help) {
      // abc => bcd
      // bc
      int code = oldCode - last * help % BASE;
      if (code < 0) {
          code += BASE;
      }
      code = code * 31 % BASE + next;
      return code;
  }
  private int calculateHashCode(String target) {
      int m = target.length();
      int power = 0;
      for (int i = 0; i < m; i++) {
          power = (power * 31  + target.charAt(i)) % BASE;    
      }
      return power;
      // abc
      // a => 31a + b => 31(31a + b) + c = a*31^2 + b*31 + c      
  }
  private boolean check(String target, String str) {
      for (int i = 0; i < target.length(); i++) {
          if (target.charAt(i) != str.charAt(i)) {
              return false;
          }
      }
      return true;
  }
}

// Brute
// class Solution {
//     public int strStr(String haystack, String needle) {
//         if (needle.length() == 0) {
//             return 0;
//         }
//         if (haystack.length() == 0 || haystack.length() < needle.length()) {
//             return -1;
//         }
//         // 1. why 'haystack.length() - needle.length() + 1' not 'haystack.length() - needle.length()'
//         // "aa" "aa" => not enter for-loop.
//         for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
//             for (int j = 0; j < needle.length(); j++) {
//                 if (!(haystack.charAt(i + j) == needle.charAt(j))) {
//                     break;
//                 } 
//                 if (j == needle.length() - 1) {
//                     return i;
//                 }
//             }
//         }
//         return -1;
//     }
// }

