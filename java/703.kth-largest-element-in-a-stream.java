class KthLargest {
    
    private PriorityQueue<Integer> minHeap;
    int size;
    int capacity;
    
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        capacity = k;
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if (size < capacity) {
            minHeap.offer(val);
            size++;
        } else {
            // compare top element of heap.
            if (minHeap.peek() < val) {
                minHeap.poll();
                minHeap.add(val);
            }
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */