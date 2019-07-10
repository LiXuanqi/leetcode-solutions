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

 class HitCounter {
    
    private static final int INTERVAL = 300;
    
    private int[] times;
    private int[] hits;
    
    /** Initialize your data structure here. */
    public HitCounter() {
        times = new int[INTERVAL];
        hits = new int[INTERVAL];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % INTERVAL;
        if (times[index] == timestamp) {
            hits[index]++;
        } else {
            hits[index] = 1;
            times[index] = timestamp;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < hits.length; i++) {
            if (timestamp - times[i] < INTERVAL) {
                total += hits[i];
            }
        }
        return total;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */