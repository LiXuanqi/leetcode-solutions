class MaxStack {
    Deque<Integer> stack;
    Deque<Integer> maxStack;
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new LinkedList<>();
        maxStack = new LinkedList<>();
    }
    
    public void push(int x) {
        stack.offerFirst(x);
        if (maxStack.isEmpty()) {
            maxStack.offerFirst(x);    
        } else {
            maxStack.offerFirst(maxStack.peekFirst() > x ? maxStack.peekFirst() : x);    
        }
        
    }
    
    public int pop() {
        maxStack.pollFirst();
        return stack.pollFirst();
    }
    
    public int top() {
        return stack.peekFirst();
    }
    
    public int peekMax() {
        return maxStack.peekFirst();
    }
    
    public int popMax() {
        Deque<Integer> temp = new LinkedList<>();
        int max = maxStack.peekFirst();
        // System.out.println(max);
        // System.out.println(stack);
        // System.out.println(maxStack);
        
        while (!stack.isEmpty() && stack.peekFirst() != max) {
            maxStack.pollFirst();
            temp.offerFirst(stack.pollFirst());
        }
        maxStack.pollFirst();
        temp.offerFirst(stack.pollFirst());
        
        // System.out.println(temp);
        temp.pollFirst();
        while (!temp.isEmpty()) {
            this.push(temp.pollFirst());
        }
        return max;
    }
}
// 4 2 5 1
// 4 4 5 5
/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */