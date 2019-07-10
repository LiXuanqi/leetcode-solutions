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
        Collections.sort(intervals, (i1, i2) -> {
            return Integer.compare(i1.start, i2.start);
        });
        Interval last = null;
        for (Interval curr : intervals) {
            if (last == null) {
                last = curr;
            } else {
                if (last.end >= curr.start) {
                    // merge
                    last.end = Math.max(last.end, curr.end);
                } else {
                    ans.add(last);
                    last = curr;
                }
            }
        }
        ans.add(last);
        return ans;
    }
}