/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
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
        Arrays.sort(intervals, (interval1, interval2) -> {
            return interval1.start < interval2.start ? -1 : 1;
        });
        PriorityQueue<Interval> heap = new PriorityQueue<>((interval1, interval2) -> {
            return interval1.end < interval2.end ? -1 : 1;
        });
        for (Interval interval : intervals) {
            if (heap.isEmpty()) {
                heap.offer(interval);
            } else {
                Interval top = heap.peek();
                // need new room
                if (top.end > interval.start) {
                    heap.offer(interval);
                } else {
                    Interval prev = heap.poll();
                    prev.end = interval.end;
                    heap.offer(prev);
                }
            }
        }
        return heap.size();
    }
}