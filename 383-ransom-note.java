class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
      if (ransomNote == null || ransomNote.length() == 0) {
          return true;
      }
      if (magazine == null || magazine.length() == 0) {
          return false;
      }
      int[] map = new int[26];
      for (int i = 0; i < magazine.length(); i++) {
          int index = magazine.charAt(i) - 97;
          map[index] += 1;
      }
      for (int i = 0; i < ransomNote.length(); i++) {
          int index = ransomNote.charAt(i) - 97;
          if (map[index] <= 0) {
              return false;
          }
          map[index] -= 1;
      }
      return true;
  }
}

// Time = O(m+n);
// Space = O(26) = O(1);