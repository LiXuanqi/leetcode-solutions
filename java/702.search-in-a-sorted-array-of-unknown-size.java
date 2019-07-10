class Solution {
    public int search(ArrayReader reader, int target) {
        if (reader == null) {
            return -1;
        }
        // get length
        int length = 1;
        while (reader.get(length) != Integer.MAX_VALUE) {
            length *= 2;
        }
        int start = 0;
        int end = length;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) == Integer.MAX_VALUE) {
                end = mid;
            } else if (reader.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (reader.get(start) == target) {
            return start;
        }
        if (reader.get(end) == target) {
            return end;
        }
        return -1;
    }
}