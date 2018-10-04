class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }
        for (int j = 0; j < 26; j++) {
            if (map[j] != 0) {
                return false;
            }
        }
        return true;
    }
}