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
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) {
            return null;
        }
        if (intervals.size() <= 1) {
            return intervals;
        }
        List<Interval> result = new ArrayList<>();
        PriorityQueue<Interval> pQueue = new PriorityQueue<Interval>(intervals.size(), new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start < i2.start ? -1 : 1;
            }
        });
        for (Interval interval : intervals) {
            pQueue.offer(interval);
        }
        Interval curr = pQueue.poll();
        while (!pQueue.isEmpty()) {
            Interval next = pQueue.poll();
            if (next.start > curr.end) {
                result.add(curr);
                curr = next;
            } else {
                curr.start = Math.min(curr.start, next.start);
                curr.end = Math.max(curr.end, next.end);
            }
        }
        result.add(curr);
        return result;
    }
}