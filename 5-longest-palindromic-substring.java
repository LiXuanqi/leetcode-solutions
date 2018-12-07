class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String ans = "";
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int length = helper(s, i, i);
            // update ans.
            if (length > maxLength) {
                maxLength = length;
                ans = s.substring(i - length / 2, i + length / 2 + 1);
            }
            if (i != 0) {
                length = helper(s, i - 1, i);
                // update ans.
                if (length > maxLength) {
                    maxLength = length;
                    ans = s.substring(i - length / 2, i + length / 2);
                }
            }
        }
        return ans;
    }
    private int helper(String s, int left, int right) {
        int length = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            length += (left == right ? 1 : 2); // Notice left == right and update length before left-- right++.
            left--;
            right++; 
        }
        return length;
    }
}