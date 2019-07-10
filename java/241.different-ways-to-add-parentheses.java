class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return ans;
        }
        boolean hasSign = false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                hasSign = true;
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> res1 = diffWaysToCompute(part1);
                List<Integer> res2 = diffWaysToCompute(part2);
                for (int num1 : res1) {
                    for (int num2 : res2) {
                        if (c == '+') {
                            ans.add(num1 + num2);
                        } else if (c == '-') {
                            ans.add(num1 - num2);
                        } else if (c == '*') {
                            ans.add(num1 * num2);
                        }
                    }
                }
            }
        }
        if (!hasSign) {
            ans.add(Integer.parseInt(input));
        }
        return ans;
    }
}