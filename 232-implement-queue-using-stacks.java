class MyQueue {
  private int size;
  private Stack<Integer> stack1;
  private Stack<Integer> stack2;
  /** Initialize your data structure here. */
  public MyQueue() {
      size = 0;
      stack1 = new Stack<>();
      stack2 = new Stack<>();
  }
  
  /** Push element x to the back of queue. */
  public void push(int x) {
      while (!stack2.empty()) {
          stack1.push(stack2.pop());
      }
      stack1.push(x);
      size += 1;
  }
  
  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
      while (!stack1.empty()) {
          stack2.push(stack1.pop());
      }
      size -= 1;
      return stack2.pop();
  }
  
  /** Get the front element. */
  public int peek() {
      while (!stack1.empty()) {
          stack2.push(stack1.pop());
      }
      return stack2.peek();
  }
  
  /** Returns whether the queue is empty. */
  public boolean empty() {
      return size == 0 ? true : false;
  }
}

/**
* Your MyQueue object will be instantiated and called as such:
* MyQueue obj = new MyQueue();
* obj.push(x);
* int param_2 = obj.pop();
* int param_3 = obj.peek();
* boolean param_4 = obj.empty();
*/