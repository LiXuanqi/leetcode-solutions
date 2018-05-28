class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = Integer.toString(x);
        int start = 0;
        int end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
