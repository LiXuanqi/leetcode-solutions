/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private TreeNode help;
    Deque<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        help = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return help != null || !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {

        while (help != null) {
            stack.offerFirst(help);
            help = help.left;
        }
        TreeNode curr = stack.pollFirst();
        int result = curr.val;
        help = curr.right;
      
        return result;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */