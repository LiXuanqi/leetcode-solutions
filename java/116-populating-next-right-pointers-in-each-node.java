/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
// Method 1: Recurssion

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        // perfect tree must have 0 or 2 children.
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
            connect(root.left);
            connect(root.right);
        } 
    }
}

// Method 2: level order traversal with Queue
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode prev = null;
            
            for (int i = 0; i < size; i++) {
                TreeLinkNode curr = queue.poll();
                if (prev != null) {
                    prev.next = curr;
                }
                prev = curr;
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                
            }
        }
    }
}