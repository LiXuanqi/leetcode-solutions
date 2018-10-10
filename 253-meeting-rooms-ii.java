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
        if (intervals == null) {
            return -1;
        }
        if (intervals.length <= 1) {
            return intervals.length;
        }
        // sort by start;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval1, Interval interval2) {
                return interval1.start < interval2.start ? -1 : 1;
            }
        });
        // min heap for end time.
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.offer(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            int lastTime = heap.peek();
            if (lastTime <= intervals[i].start) {
                heap.poll();
            }
            heap.offer(intervals[i].end);
        }
        return heap.size();
    }
}