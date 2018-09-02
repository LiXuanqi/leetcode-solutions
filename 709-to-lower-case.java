class Solution {
    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] input = str.toCharArray();
        for (int i = 0; i < input.length; i++) {
            if (input[i] >= 'A' && input[i] <= 'Z') {
                input[i] = (char) (input[i] - ('A' - 'a'));
            }
        }
        return new String(input);
    }
}

// Time = O(n)
// Space = O(n) 