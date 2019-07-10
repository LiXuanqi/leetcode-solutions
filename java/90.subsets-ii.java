class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        dfs(nums, new boolean[nums.length], 0, new ArrayList<>(), result);
        return result;
    }
    private void dfs(int[] nums, boolean[] used, int start, List<Integer> temp, List<List<Integer>> result) {
        if (start >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        dfs(nums, used, start + 1, temp, result);
        if (start != 0 && !used[start - 1] && nums[start] == nums[start - 1]) {
            return;
        } 
        temp.add(nums[start]);
        used[start] = true;
        dfs(nums, used, start + 1, temp, result);
        temp.remove(temp.size() - 1);
        used[start] = false;         
    }
}