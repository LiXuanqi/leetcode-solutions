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
        List<Interval> ans = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return ans;
        }
        Collections.sort(intervals, (interval1, interval2) -> {
            return Integer.compare(interval1.start, interval2.start);
        });
        Interval prev = null;
        for (Interval curr : intervals) {
            if (prev == null) {
                prev = curr;
            } else {
                if (prev.end < curr.start) {
                    ans.add(prev);
                    prev = curr;
                } else {
                    prev.end = Math.max(prev.end, curr.end);
                }
            }
        }
        ans.add(prev);
        return ans;
    }
}