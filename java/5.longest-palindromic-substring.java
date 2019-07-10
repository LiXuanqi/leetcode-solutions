class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String ans = "";
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            // 1  2  1
            int length = helper(s, i, i);
            if (length > maxLength) {
                maxLength = length;
                ans = s.substring(i - length / 2, i + length / 2 + 1);
            }
            if (i > 0) {
                length = helper(s, i - 1, i);
                // 1 2 2 1
                if (length > maxLength) {
                    maxLength = length;
                    ans = s.substring(i - length / 2, i + length / 2);
                }
            }
        }
        return ans;
    }
    private int helper(String str, int left, int right) {
        int length = 0;
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            length += left == right ? 1 : 2;
            left--;
            right++;
        }
        return length;
    }
}