class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int sign = 1; // '1' represents '+', '-1' represents '-'
        int res = 0; // store temp result.
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                // read number and calculate.
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--; // notice!
                res += sign * num;
            } else if (c == '+') {
                sign = 1;
                
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                // open a new space for calculating.
                stack.offerFirst(sign); // sign before '('
                stack.offerFirst(res);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                int prevNum = stack.pollFirst();
                int signBeforeParenthese = stack.pollFirst();
                res = prevNum + signBeforeParenthese * res;
            } 
        }
        return res;
    }
}