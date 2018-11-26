class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int left = 0;
        int right = citations.length;
        while (left + 1 < right) {         
            int mid = left + (right - left) / 2;
            if (countBiggerAndEquals(citations, mid) == mid) {
                return mid;
            } else if (countBiggerAndEquals(citations, mid) < mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (countBiggerAndEquals(citations, right) >= right) {
            return right;
        }
        return left;
    }
    private int countBiggerAndEquals(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (num >= target) {
                count++;
            }
        }
        return count;
    }
}