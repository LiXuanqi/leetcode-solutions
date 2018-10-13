class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) {
            return result;
        }
        // count invalid parentheses.
        int invalidLeft = 0;
        int invalidRight = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                invalidLeft++;
            } else if (s.charAt(i) == ')') {
                invalidLeft--;
            }
            if (invalidLeft < 0) {
                // skip invalid parenthese.
                invalidRight++;
                invalidLeft = 0;
            }
        }
        delete(s, invalidLeft, invalidRight, 0, result);
        return result;
    }
    private void delete(String str, int left, int right, int start, List<String> solutions) {
        if (left == 0 && right == 0) {
            if (isValid(str)) {
                solutions.add(str);
            }
        }
        for (int i = start; i < str.length(); i++) {
            // only delete first.
            if (i != start && str.charAt(i - 1) == str.charAt(i)) {
                continue;
            }
            // delete right parenthese firstly.
            if (right > 0) {
                if (str.charAt(i) == ')') {
                    delete(deleteCharAt(str, i), left, right - 1, i, solutions);
                } 
                continue;
            }
            if (left > 0) {
                if (str.charAt(i) == '(') {
                    delete(deleteCharAt(str,i), left - 1, right, i, solutions);
                }
                continue;
            }
        }    
    }
    private boolean isValid (String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (count < 0) {
                return false;
            }
            if (str.charAt(i) == '(') {
                count++;
            } else if (str.charAt(i) == ')') {
                count--;
            }
        }
        return count == 0;
    }
    
    private String deleteCharAt(String str, int index) {
        return str.substring(0, index) + str.substring(index + 1, str.length());
    }
 
}