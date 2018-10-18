class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        if (nums == null || nums.length == 0) {
            return new ArrayList<>(result);
        }
        dfs(nums, 0, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }
    private void dfs(int[] nums, int start, List<Integer> temp, Set<List<Integer>> result) {
      
        if (temp.size() > 1) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = start; i < nums.length; i++) {
            // if (i != start && nums[i] == nums[i - 1]) {
            //     continue;
            // }
            if (temp.size() == 0 || nums[i] >= temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
                dfs(nums, i + 1, temp, result);
                temp.remove(temp.size() - 1);
            }
       
        }
    }
}

