class Solution {
    public boolean checkValidString(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int leftRange = 0;
        int rightRange = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftRange++;
                rightRange++;
            } else if (s.charAt(i) == '*') {
                leftRange--;
                rightRange++;
            } else if (s.charAt(i) == ')') {
                leftRange--;
                rightRange--;
            }
            if (rightRange < 0) {
                return false;
            }
            leftRange = Math.max(leftRange, 0);
        }
        return leftRange == 0;
    }
}