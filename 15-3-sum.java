class Solution {
  class ResultType {
      int left;
      int right;
      public ResultType(int left, int right) {
          this.left = left;
          this.right = right;
      }
  }
  public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      if (nums == null) {
          return result;
      }
      Arrays.sort(nums);
      for (int i = 0; i < nums.length - 2; i++) {
          ResultType positions = twoSum(-nums[i], i + 1, nums.length - 1, nums);
          if (positions.left != -1 && positions.right != -1) {
              List<Integer> temp = new ArrayList<>();
              temp.add(nums[i]); 
              temp.add(nums[positions.left]);
              temp.add(nums[positions.right]);
              result.add(temp);
          }  
      }
      return result;
   
  }
  private ResultType twoSum(int target, int left, int right, int[] nums) {
      while (left < right) {
          if (nums[left] + nums[right] == target) {
              return new ResultType(left, right);
          }
          if (nums[left] + nums[right] < target) {
              left++;
          } else {
              right--;
          }
      }
      return new ResultType(-1, -1);
  }
}