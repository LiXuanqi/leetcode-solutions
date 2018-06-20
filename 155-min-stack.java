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

class MinStack {
  class Pair {
      public final int left;
      public final int right;
      public Pair(int left, int right) {
          this.left = left;
          this.right = right;
      }
  }
  
  Stack<Integer> stack1;
  Stack<Pair> stack2;
  /** initialize your data structure here. */
  public MinStack() {
      stack1 = new Stack<>();
      stack2 = new Stack<>();
  }
  
  public void push(int x) {
      stack1.push(x);
      Pair pair = null;
      if (!stack2.empty()) {
          pair = stack2.peek();  
      }
      if ( pair == null || pair.left > x) {
          stack2.push(new Pair(x, stack1.size() - 1));
      }
  }
  
  public void pop() {
      Pair pair = stack2.peek();    
      if (pair.left == stack1.peek() && pair.right == stack1.size() - 1) {
      
          stack2.pop();
      }
      stack1.pop();
      
  }
  
  public int top() {
      return stack1.peek();
  }
  
  public int getMin() {
      return stack2.peek().left;
  }
}

// Follow up: how to optimize the space usage of stack2 assumpting there are a lot of duplicate element?

// Stack1 ||   2       1    2 2 1 4 4                
// Stack2 || <2,0>   <1,1>