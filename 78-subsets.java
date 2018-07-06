class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result =  new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }   
        dfs(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    private void dfs(int[] nums, int level, List<Integer> temp, List<List<Integer>> solutions) {
        if (level == nums.length) {
            solutions.add(new ArrayList<Integer>(temp));
            return;
        }
        temp.add(nums[level]);
        dfs(nums, level + 1, temp, solutions);
        temp.remove(temp.size() - 1);
        dfs(nums, level + 1, temp, solutions);
        
    }
}

// Space = O(n)
// Time = O(2^n)