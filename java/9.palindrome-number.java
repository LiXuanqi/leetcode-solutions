class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String num = "" + x;
        int start = 0;
        int end = num.length() - 1;
        while (start < end) {
            if (num.charAt(start) != num.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}