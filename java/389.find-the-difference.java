class Solution {
    public char findTheDifference(String s, String t) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            if (map[c - 'a'] == 0) {
                return c;
            }
            map[c - 'a'] -= 1;
        }
        return ' ';
    }
}