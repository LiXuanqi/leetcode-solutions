class MyStack {
    Queue<Integer> data;
    Queue<Integer> temp;
    /** Initialize your data structure here. */
    public MyStack() {
        data = new LinkedList<>();
        temp = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        // move data to temp.
        while (!data.isEmpty()) {
            temp.offer(data.poll());
        }
        data.offer(x);
        // move back
        while (!temp.isEmpty()) {
            data.offer(temp.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return data.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return data.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return data.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */