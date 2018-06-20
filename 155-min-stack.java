class MinStack {
  Stack<Integer> stack1;
  Stack<Integer> stack2;
  /** initialize your data structure here. */
  public MinStack() {
      stack1 = new Stack<>();
      stack2 = new Stack<>();

  }
  
  public void push(int x) {
      stack1.push(x);
      if (stack2.empty()) {
          stack2.push(x);
      } else {
          stack2.push(Math.min(stack2.peek(), x));
      }
  }
  
  public void pop() {
      stack1.pop();
      stack2.pop();
  }
  
  public int top() {
      return stack1.peek();
  }
  
  public int getMin() {
      return stack2.peek();
  }
}

// Stack1 || 2 1 2 2 1 4 4                
// Stack2 || 2 1 1 1 1 1 1 