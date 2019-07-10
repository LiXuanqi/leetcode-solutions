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
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // sort by end time.
        Arrays.sort(intervals, (i1, i2) -> {
            return Integer.compare(i1.end, i2.end);
        });
        int end = intervals[0].end;
        int count = 1; // intervals[0] is accepted.
        for (Interval interval : intervals) {
            if (interval.start >= end) {
                // accept interval.
                count++;
                end = interval.end;
            }
        }
        return intervals.length - count;
    }
}