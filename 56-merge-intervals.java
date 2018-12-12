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
        Interval last = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);
            if (last.end >= next.start) {
                last.end = Math.max(last.end, next.end);
            } else {
                ans.add(last);
                last = next;
            }
        }
        ans.add(last);
        return ans;
    }
}