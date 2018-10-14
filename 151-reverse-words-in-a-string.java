public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        // head and tail space.
        char[] input = s.trim().toCharArray();
        // delete multiple space.
        int end = deleteMultipleSpaces(input);
        reverse(input, 0, input.length - 1);
        int start = input.length - end - 1;
        int slow = start;
        int fast = start;
        while (fast < input.length) {
            while (fast < input.length && input[fast] != ' ') {
                fast++;
            }
            reverse(input, slow, fast - 1);
            fast = fast + 1;
            slow = fast;
        }
        return new String(input).substring(start);
    }
    private void reverse(char[] input, int left, int right) {
        while (left < right) {
            char temp = input[left];
            input[left] = input[right];
            input[right] = temp;
            left++;
            right--;
        }
    }

    private int deleteMultipleSpaces (char[] input) {
        int slow = 0;
        int fast = 0;
        while (fast < input.length) {
            if (input[fast] != ' ') {
                input[slow++] = input[fast++];
            } else {
                if (input[fast] != input[fast - 1]) {
                    input[slow++] = input[fast++];  
                } else {
                    fast++;
                }
            }
        }
        return slow - 1;
    }
    
}