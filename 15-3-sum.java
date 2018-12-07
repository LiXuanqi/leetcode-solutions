class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 2) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // avoid repeated answer.
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> lists = twoSum(nums, i + 1, -nums[i]);
            for (List<Integer> list : lists) {
                list.add(0, nums[i]);
                ans.add(list);
            }
        }
        return ans;
    }
    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            if (left != start && nums[left] == nums[left - 1]) {
                left++;
                continue;
            }
            if (right != nums.length - 1 && nums[right] == nums[right + 1]) {
                right--;
                continue;
            }
            int sum = nums[left] + nums[right];
            if (sum == target) {
                List<Integer> list = new LinkedList<>();
                list.add(nums[left++]);
                list.add(nums[right--]);
                ans.add(list);
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}