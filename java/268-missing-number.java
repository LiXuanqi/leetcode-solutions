class Solution {
  public int missingNumber(int[] nums) {
      if (nums == null || nums.length == 0) {
          return -1;
      }
      Set<Integer> set = new HashSet<>();
      for (int num : nums) {
          set.add(num);
      }
      for (int i = 0; i < nums.length + 1; i++) {
          if (!set.contains(i)) {
              return i;
          }
      }
      return -1;
  }
}

// Time = O(n)
// Space = O(n)

// TODO: bit operation.
class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result ^= i;
            result ^= nums[i];
        }
        return result;
    }
}
// Time = O(n)
// Space = O(1)