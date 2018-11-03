class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return isValidPalindrome(s, start + 1, end) || isValidPalindrome(s, start, end - 1);
            }
            start++;
            end--;
        }
        return true;
    }
    private boolean isValidPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}