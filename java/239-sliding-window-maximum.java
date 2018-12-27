class Solution {
    void inDeque(Deque<Integer> deque, int index, int[] nums) {
        while (!deque.isEmpty() && nums[deque.peekLast()] < nums[index]) {
            deque.pollLast();
        }
        deque.offerLast(index);
    }
    void outDeque(Deque<Integer> deque, int index) {
        if (deque.peekFirst() == index) {
            deque.pollFirst();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k - 1; i++) {
            inDeque(deque, i, nums);
        }

        for (int i = k - 1; i < nums.length; i++) {
            inDeque(deque, i, nums);

            result[i - k + 1] = nums[deque.peekFirst()];

            outDeque(deque, i - k + 1);
        }
        return result;
    }
}