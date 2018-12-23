public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        s = s.trim();
        s = reverse(s);
        String[] words = s.split(" +");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(reverse(word) + " ");    
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    private String reverse(String str) {
        char[] input = str.toCharArray();
        int start = 0;
        int end = input.length - 1;
        while (start < end) {
            char temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }
        return new String(input);
    }
}