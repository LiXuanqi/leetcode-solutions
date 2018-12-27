class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        Deque<Long> operands = new LinkedList<>();
        Deque<Character> signs = new LinkedList<>();
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                long num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = 10 * num + s.charAt(i) - '0';
                    i++;
                }
                i--;
                if (sign == '+') {
                    operands.offerFirst(num);
                } else if (sign == '-') {
                    operands.offerFirst(-num);
                } else if (sign == '*') {
                    long prev = operands.pollFirst();
                    operands.offerFirst(prev * num);
                } else if (sign == '/') {
                    long prev = operands.pollFirst();
                    operands.offerFirst(prev / num);
                }
            } else if (c == ' ') {
                continue;
            } else if (c == '(') {
                signs.offerFirst(sign);
                sign = '+';
                operands.offerFirst(Long.MAX_VALUE);
            } else if (c == ')') {
                long pollNumber = 0;
                long sum = 0;
                while (pollNumber != Long.MAX_VALUE) {
                    pollNumber = operands.pollFirst();
                    sum += pollNumber != Long.MAX_VALUE ? pollNumber : 0;
                }
                char prevSign = signs.pollFirst();
                if (prevSign == '+') {
                    operands.offerFirst(sum);
                } else if (prevSign == '-') {
                    operands.offerFirst(-sum);
                } else if (prevSign == '*') {
                    operands.offerFirst(operands.pollFirst() * sum);
                } else if (prevSign == '/') {
                    operands.offerFirst(operands.pollFirst() / sum);
                }
                sign = '+';
            } else {
                sign = c;
            }
        }
        while (!operands.isEmpty()) {
            result += operands.pollFirst();
        }
        return result;
    }
    
}