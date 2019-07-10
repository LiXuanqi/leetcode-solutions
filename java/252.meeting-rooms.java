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
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, (interval1, interval2) -> {
            return Integer.compare(interval1.start, interval2.start);
        });
        int lastEnd = -1;
        for (Interval interval : intervals) {
            if (interval.start < lastEnd) {
                return false;
            }
            lastEnd = interval.end;
        }
        return true;
    }
}