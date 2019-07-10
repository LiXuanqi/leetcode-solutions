class Solution {
  public int majorityElement(int[] nums) {
      int candidate = 0;
      int counter = 0;
      for (int num : nums) {
          if (num == candidate) {
              counter++;
          } else {
              if (counter == 0) {
                  candidate = num;
                  counter++;
              } else {
                  counter--;
              }
          }
      }
      return candidate;
  }
}