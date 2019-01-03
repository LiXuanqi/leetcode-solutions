class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                // read number.
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                if (sign == '+') {
                    stack.offerFirst(num);
                } else if (sign == '-') {
                    stack.offerFirst(-num);
                } else if (sign == '*') {
                    int prev = stack.pollFirst();
                    stack.offerFirst(prev * num);
                } else if (sign == '/') {
                    int prev = stack.pollFirst();
                    stack.offerFirst(prev / num);
                }
            } else if (c == ' ') {
                continue;
            } else {
                sign = c;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pollFirst();
        }
        return res;
    }
}