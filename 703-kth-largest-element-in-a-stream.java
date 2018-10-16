class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int capacity;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>(k);
        capacity = k;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        if (minHeap.size() < capacity) {
            minHeap.offer(val);
        } else {
            if (minHeap.peek() < val) {
                
                minHeap.offer(val);
                minHeap.poll();
                
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