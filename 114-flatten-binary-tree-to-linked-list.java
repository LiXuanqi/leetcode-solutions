class Solution {
    class ResultType {
        TreeNode head;
        TreeNode tail;
        public ResultType(TreeNode head, TreeNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flattenTree(root);
    }
    public ResultType flattenTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        ResultType left = flattenTree(root.left);
        ResultType right = flattenTree(root.right);
        if (left == null && right == null) {
            return new ResultType(root, root);
        }
        if (left == null) {
            return new ResultType(root, right.tail);
        }
        if (right == null) {
            return new ResultType(root, left.tail);
        }
        root.left = null;
        root.right = left.head;
        left.tail.right = right.head;
        return new ResultType(root, right.tail);
    }
    
}