class Solution {
  public int evalRPN(String[] tokens) {
      Stack<Integer> stack = new Stack<>();
      for (String token : tokens) {
          if (token.equals("+")) {
              int first = stack.pop();
              int second = stack.pop();
              stack.push(first + second);
          } else if (token.equals("-")) {
              int first = stack.pop();
              int second = stack.pop();
              stack.push(second - first);
          } else if (token.equals("*")) {
              int first = stack.pop();
              int second = stack.pop();
              stack.push(first * second);
          } else if (token.equals("/")) {
              int first = stack.pop();
              int second = stack.pop();
              stack.push(second / first);
          } else {
              stack.push(Integer.parseInt(token));
          }
      }
      return stack.pop();
  }
}

// Input: ["2", "1", "+", "3", "*"]
// Stack || 2 1
// +    =>    2 + 1
// Stack ||  3
// Stack ||  3   3
// *
