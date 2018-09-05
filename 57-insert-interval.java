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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
        int startIndex = findStartIndex(intervals, newInterval.start);
        int endIndex = findEndIndex(intervals, newInterval.end);
        System.out.println(startIndex);
        System.out.println(endIndex);
        for (int i = 0; i <= startIndex; i++) {
            result.add(intervals.get(i));
        }
        int newIntervalStart = 0;
        if (startIndex + 1 <= intervals.size() - 1) {
            newIntervalStart = Math.min(intervals.get(startIndex + 1).start, newInterval.start);
        } else {
            newIntervalStart = newInterval.start;
        }
        int newIntervalEnd = 0;
        if (endIndex - 1 >= 0) {
            newIntervalEnd = Math.max(intervals.get(endIndex - 1).end, newInterval.end);
        } else {
            newIntervalEnd = newInterval.end;
        }
  
        result.add(new Interval(newIntervalStart, newIntervalEnd));
        for (int i = endIndex; i < intervals.size(); i++) {
            result.add(intervals.get(i));
        }
        return result;
    }
    private int findStartIndex(List<Interval> intervals, int target) {
        int start = 0;
        int end = intervals.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (intervals.get(mid).end >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (intervals.get(end).end < target) {
            return end;
        }
        if (intervals.get(start).end < target) {
            return start;
        }
        return -1;
    }
    private int findEndIndex(List<Interval> intervals, int target) {
        int start = 0;
        int end = intervals.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (intervals.get(mid).start <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (intervals.get(start).start > target) {
            return start;
        }
        if (intervals.get(end).start > target) {
            return end;
        }
        return intervals.size();
    }
}