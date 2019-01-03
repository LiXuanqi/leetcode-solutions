class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0;
        int length = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols; // try to put word.
            if (s.charAt(start % length) == ' ') {
                start++;
            } else {
                // can't start from middle of word.
                while (start > 0 && s.charAt((start - 1) % length) != ' ') {
                    start--;
                }
            }
        }
        return start / length;
    }
}