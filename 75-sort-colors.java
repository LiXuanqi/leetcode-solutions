class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        // [left, right] should be judged.
        int curr = 0;
        while (left <= curr && curr <= right) {
            if (nums[curr] == 0) {
                nums[curr] = nums[left];
                nums[left++] = 0;
                curr++; // why?
            } else if (nums[curr] == 2) {
                nums[curr] = nums[right];
                nums[right--] = 2;
                
            } else {
                curr++;
            }
        }
        
    }
}