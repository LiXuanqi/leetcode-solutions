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
        // sort by start time.
        Arrays.sort(intervals, (interval1, interval2) -> {
            return Integer.compare(interval1.start, interval2.start);
        });
        PriorityQueue<Interval> heap = new PriorityQueue<>((interval1, interval2) -> {
            return Integer.compare(interval1.end, interval2.end);
        });
        for (Interval interval : intervals) {
            if (heap.isEmpty()) {
                heap.offer(interval);
            } else {
                if (heap.peek().end <= interval.start) {
                    Interval curr = heap.poll();
                    curr.end = interval.end;
                    heap.offer(curr);
                } else {
                    heap.offer(interval);
                }
            }
        }
        return heap.size();
    }
}