class Solution {
    int count = 0;
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        return count;
    }
    private void mergeSort(int[] nums, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid, temp);
        mergeSort(nums, mid + 1, end, temp);
        
        helper(nums, start, mid, end);
        
        merge(nums, start, mid, end, temp);
    }
    private void helper(int[] nums, int start, int mid, int end) {
        int index = mid + 1;
        int c = 0;
        for (int i = start; i <= mid; i++) {
            while (index <= end && (long) nums[i] > (long) 2 * nums[index]) {
                index++;
                c++;
            }
            count = count + c;
        }
    }
    private void merge(int[] nums, int start, int mid, int end, int[] temp) {
        int index = start;
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if (nums[i] > nums[j]) {
                temp[index++] = nums[j++];
            } else {
                temp[index++] = nums[i++];
            }    
        }
        while (i <= mid) {
            temp[index++] = nums[i++];
        }
        while (j <= end) {
            temp[index++] = nums[j++];
        }
        for (int k = start; k <= end; k++) {
            nums[k] = temp[k];
        }
    }
}