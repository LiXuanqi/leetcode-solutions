class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null) {
            return null;
        }
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[nums.length];
        for (int i = nums.length * 2 - 1; i >= 0; i--) {
            int num = nums[i % nums.length];
            while (!stack.isEmpty() && stack.peekFirst() <= num) {
                stack.pollFirst();
            }
            ans[i % nums.length] = stack.isEmpty() ? -1 : stack.peekFirst();
            stack.offerFirst(num);
        }
        return ans;
    }
}