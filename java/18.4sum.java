class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
 
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int num = nums[i];
            List<List<Integer>> list = threeSumFromIndex(nums, target - num, i + 1);
            for (List<Integer> l : list) {
                l.add(0, num);
                result.add(l);
            }
        }
        return result;
    }
    private List<List<Integer>> threeSumFromIndex(int[] nums, int target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = start; i < nums.length - 2; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            int num = nums[i];
            List<List<Integer>> list = twoSumFromIndex(nums, target - num, i + 1);
            for (List<Integer> l : list) {
                l.add(0, num);
                result.add(l);
            }
        }
        return result;
    }
    private List<List<Integer>> twoSumFromIndex(int[] nums, int target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        int right = nums.length - 1;
        int left = start;
        while (left < right) {
            // skip duplicate.
            if (left != start && nums[left] == nums[left - 1]) {
                left++;
                continue;
            }
            if (right != nums.length - 1 && nums[right] == nums[right + 1]) {
                right--;
                continue;
            }
            if (nums[left] + nums[right] == target) {
                List<Integer> pair = new LinkedList<>();
                pair.add(nums[left]);
                pair.add(nums[right]);
                result.add(pair);
                left++;
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
