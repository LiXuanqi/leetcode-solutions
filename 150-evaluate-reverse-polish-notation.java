class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Deque<Integer> nums = new LinkedList<>();
        String sign = "+-*/";
        for (String token : tokens) {
            if (sign.indexOf(token) != -1) {
                int num1 = nums.pollFirst();
                int num2 = nums.pollFirst();
                if (token.equals("+")) {
                    nums.offerFirst(num1 + num2);
                } else if (token.equals("-")) {
                    nums.offerFirst(num2 - num1);
                } else if (token.equals("*")) {
                    nums.offerFirst(num2 * num1);
                } else if (token.equals("/")) {
                    nums.offerFirst(num2 / num1);
                }
            } else {
                nums.offerFirst(Integer.parseInt(token));
            }
        }
        return nums.pollFirst();
    }
}