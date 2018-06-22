class Solution {
  public int lengthOfLongestSubstring(String s) {
      if (s == null || s.length() == 0) {
          return 0;
      }
      int result = 0;
      Map<Character, Integer> map = new HashMap<>();
      for (int i = 0, j = 0; j < s.length(); j++) {
          if (map.containsKey(s.charAt(j))) {
              int index = map.get(s.charAt(j));
              i = Math.max(index + 1, i);
          }
          map.put(s.charAt(j), j);
          result = Math.max(result, j - i + 1); 
      }
      return result;
  }
}

