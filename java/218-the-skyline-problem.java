class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> ans = new ArrayList<>();
        List<int[]> events = new ArrayList<>();
        for (int[] building : buildings) {
            events.add(new int[] {building[0], building[2]});
            events.add(new int[] {building[1], -building[2]});
        }
        
        Collections.sort(events, (e1, e2) -> {
            return e1[0] == e2[0] ? Integer.compare(e2[1], e1[1]) : Integer.compare(e1[0], e2[0]);
        });
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        heap.offer(0);
        int prev = 0;
        for (int[] event : events) {
            boolean entering = event[1] > 0;
            int h = Math.abs(event[1]);
            if (entering) {
                heap.offer(h);
            } else {
                heap.remove(h);
            }
            int curr = heap.peek();
            if (prev != curr) {
                ans.add(new int[] {event[0], curr});
                prev = curr;
            }
        }
        return ans;
    }
}