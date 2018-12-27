class Solution {
  public int maxArea(int[] height) {
      if (height == null || height.length <= 1) {
          return 0;
      }
      int left = 0;
      int right = height.length - 1;
      int maxArea = Integer.MIN_VALUE;
      while (left < right) {
          int area = Math.min(height[left], height[right]) * (right - left);
          if (area > maxArea) {
              maxArea = area;
          }
          if (height[left] <= height[right]) {
              left++;
          } else {
              right--;
          }
      }
      return maxArea;
  }
}