class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        dfs(nums, 0, result);
        return result;
    }
    private void dfs(int[] nums, int level, List<List<Integer>> solutions) {
        if (level == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            solutions.add(temp);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = level; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                swap(nums, level, i);
                dfs(nums, level + 1, solutions);
                swap(nums, level, i);
            }
        }
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

//      1a(1b2)                  2(1a1b)
// 1a1b(2) 1a2(1b)              21a(1b)