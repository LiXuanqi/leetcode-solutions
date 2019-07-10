class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int sum = 0;
        int leftMax = height[left];
        int rightMax = height[right];
        while (left + 1 < right) {
            if (leftMax < rightMax) {
                left++;
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    sum += leftMax - height[left];
                }
            } else {
                right--;
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else{
                    sum += rightMax - height[right];    
                }   
            }
        }
        return sum;
    }
}