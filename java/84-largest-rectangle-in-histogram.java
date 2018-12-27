class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerFirst(-1);
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peekFirst() != -1 && heights[stack.peekFirst()] >= heights[i]) {
                int height = heights[stack.pollFirst()];
                int width = i - stack.peekFirst() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.offerFirst(i);
        }
        while (stack.peekFirst() != -1) {
            int height = heights[stack.pollFirst()];
            int width = heights.length - stack.peekFirst() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }
}