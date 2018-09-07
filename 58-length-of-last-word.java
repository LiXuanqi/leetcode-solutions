class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int pointer = s.length() - 1;
        // find first non-empty character from end of the string.
        while (pointer >= 0 && !Character.isLetter(s.charAt(pointer))) {
            pointer--;
        }
        // count the length
        int count = 0;
        while (pointer >= 0 && Character.isLetter(s.charAt(pointer))) {
            count++;
            pointer--;
        }
        return count;
    }
}
// LeetCode 58
// Time = O(n)
// Space = O(1)