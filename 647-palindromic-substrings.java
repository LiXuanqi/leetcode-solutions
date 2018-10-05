class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            findPalindrome(s, i, i);
            findPalindrome(s, i, i + 1);
        }
        findPalindrome(s, s.length() - 1, s.length() - 1);
        return count;
    }
    private void findPalindrome(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}