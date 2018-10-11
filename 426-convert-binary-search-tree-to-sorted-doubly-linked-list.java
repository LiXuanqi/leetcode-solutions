/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node left = treeToDoublyList(root.left);
        Node right = treeToDoublyList(root.right);
        
        root.left = root;
        root.right = root;
        
        return concatenate(concatenate(left, root), right);
        
    }
    private Node concatenate(Node leftHead, Node rightHead) {
        if (leftHead == null && rightHead == null) {
            return null;
        }
        if (leftHead == null) {
            return rightHead;
        }
        if (rightHead == null) {
            return leftHead;
        }
        Node leftTail = leftHead.left;
        Node rightTail = rightHead.left;
        
        leftTail.right = rightHead;
        rightHead.left = leftTail;
        rightTail.right = leftHead;
        leftHead.left = rightTail;
        
        return leftHead;
    }
}