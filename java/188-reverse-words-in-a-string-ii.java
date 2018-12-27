class Solution {
    public void reverseWords(char[] str) {
        if (str == null || str.length == 0) {
            return;
        }
        reverse(str, 0, str.length - 1);
        int left = 0;
        int right = 0;
        while (right < str.length) {
            if (str[right] != ' ') {
                right++;
            } else {
                reverse(str, left, right - 1);
                right++;
                left = right;
            }
        }
        reverse(str, left, right - 1);
    }
    private void reverse(char[] str, int left, int right) {
        while (left < right) {
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
    }
}