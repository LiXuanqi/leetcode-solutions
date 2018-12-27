class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int slow = 0;
        int anchor = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            if (fast == chars.length - 1 || chars[fast + 1] != chars[fast]) {
                // time to write.
                chars[slow++] = chars[anchor];
                int length = fast - anchor + 1;
                if (length > 1) {
                    for (char c : String.valueOf(length).toCharArray()) {
                        chars[slow++] = c;
                    }
                }
                anchor = fast + 1;
            }
        }
        return slow;
    }
}