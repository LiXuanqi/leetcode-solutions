class Solution {
  public int[] findErrorNums(int[] nums) {
      if (nums == null || nums.length == 0) {
          return null;
      }
      int duplicated = -1;
      int missing = -1;
      Set<Integer> set = new HashSet<>();
      for (int num : nums) {
          if (set.contains(num)) {
              duplicated = num;
          } else {
              set.add(num);
          }
      }
      for (int i = 1; i <= nums.length; i++) {
          if (!set.contains(i)) {
              missing = i;
          }
      }
      return new int[]{duplicated, missing};
  }
}

// Time = O(n)
// Space = O(n)