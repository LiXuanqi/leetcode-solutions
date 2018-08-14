class Solution {
  public List<Integer> majorityElement(int[] nums) {
      int candidate1 = 0;
      int candidate2 = 0;
      int counter1 = 0;
      int counter2 = 0;
      for (int num : nums) {
          if (num == candidate1) {
              counter1++;
          }
          if (num == candidate2) {
              counter2++;
          }
          if (num != candidate1 && num != candidate2) {
              if (counter1 == 0) {
                  candidate1 = num;
                  counter1++;
                  continue;
              } 
              if (counter2 == 0) {
                  candidate2 = num;
                  counter2++;
                  continue;
              }
              counter1--;
              counter2--;
          }
      }
      counter1 = 0;
      counter2 = 0;
      for (int num : nums) {
          if (num == candidate1) {
              counter1++;
          }
          if (num == candidate2) {
              counter2++;
          }
      }
      List<Integer> result = new ArrayList<>();
      if (counter1 > nums.length / 3) {
          result.add(candidate1);
      }
      if (counter2 > nums.length / 3 && candidate2 != candidate1) {
          result.add(candidate2);
      }
      return result;
  }
}