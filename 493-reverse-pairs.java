class Solution {
    int ans = 0;
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        return ans;
    }
    private void mergeSort(int[] nums, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid, temp);
        mergeSort(nums, mid + 1, end, temp);
        
        helper(nums, start, end);
        
        merge(nums, start, end, temp);
    }
    // i < j , nums[i] > 2 * nums[j]
    private void helper(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        int right = mid + 1;
        int count = 0;
        for (int i = start; i <= mid; i++) {
            while (right <= end && (long) nums[i] > 2 * (long) nums[right]) {
                count++;
                right++;
            }
            ans += count;
        }
    }
    private void merge(int[] nums, int start, int end, int[] temp) {
        int mid = start + (end - start) / 2;
        int index = start;
        int pointer1 = start;
        int pointer2 = mid + 1;
        while (pointer1 <= mid && pointer2 <= end) {
            if (nums[pointer1] < nums[pointer2]) {
                temp[index++] = nums[pointer1++];
            } else {
                temp[index++] = nums[pointer2++];
            }
        }
        while (pointer1 <= mid) {
            temp[index++] = nums[pointer1++];
        }
        while (pointer2 <= end) {
            temp[index++] = nums[pointer2++];
        }
        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
    }
}