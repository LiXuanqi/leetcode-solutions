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
    Node prev;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node dummy = new Node(-1, null, null);
        prev = dummy;
        helper(root);
        // link tail and head.
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;
    }
    private void helper(Node curr) {
        if (curr == null) {
            return;
        }
        helper(curr.left);
        curr.left = prev;
        prev.right = curr;
        prev = curr;
        helper(curr.right);
    }
}