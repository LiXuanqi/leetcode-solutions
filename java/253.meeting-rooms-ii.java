/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (i1, i2) -> {
            return Integer.compare(i1.start, i2.start);
        });
        PriorityQueue<Interval> heap = new PriorityQueue<>((i1, i2) -> {
            return Integer.compare(i1.end, i2.end);
        });
        for (Interval interval : intervals) {
            if (heap.isEmpty()) {
                heap.offer(interval);
            } else {
                Interval curr = heap.peek();
                if (curr.end > interval.start) {
                    heap.offer(interval);
                } else {
                    curr.end = interval.end;
                    heap.poll();
                    heap.offer(curr);
                }
            }
        }
        return heap.size();
    }
}