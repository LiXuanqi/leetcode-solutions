class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return true;
        }
        int min = Integer.MIN_VALUE;
        Deque<Integer> stack = new LinkedList<>();
        for (int num : preorder) {
            if (num < min) {
                return false;
            }
            while (!stack.isEmpty() && stack.peekFirst() < num) {
                min = stack.pollFirst();
            }
            stack.offerFirst(num);
            
        }
        return true;
    }
}