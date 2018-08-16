class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      if (nums == null) {
          return result;
      }
      Arrays.sort(nums);
      for (int i = 0; i < nums.length - 2; i++) {
          if (i > 0 && nums[i] == nums[i - 1]) {
              continue;
          }
          int target = -nums[i];
          int left = i + 1;
          int right = nums.length - 1;
          while (left < right) {
              if (nums[left] + nums[right] == target) {
                  List<Integer> temp = new ArrayList<>();
                  temp.add(nums[i]);
                  temp.add(nums[left]);
                  temp.add(nums[right]);
                  result.add(temp);
                  left++;
                  right--;
                  while (left < right && nums[left] == nums[left - 1]) {
                      left++;
                  }
                  while (left < right && nums[right] == nums[right + 1]) {
                      right--;
                  }
              } else if (nums[left] + nums[right] < target) {
                  left++;
              } else {
                  right--;
              }
          }
      }
      return result;
   
  }

}