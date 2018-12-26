class HitCounter {
    Deque<Integer> deque = new LinkedList<>();
    private static int INTERVAL = 300;
    /** Initialize your data structure here. */
    public HitCounter() {
         
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        deque.offerLast(timestamp);

    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!deque.isEmpty() && deque.peekFirst() <= timestamp - INTERVAL) {
            deque.pollFirst();
        }
        return deque.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */