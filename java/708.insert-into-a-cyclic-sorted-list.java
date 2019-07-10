/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal, null);
            node.next = node;
            return node;
        }
        Node curr = head;
        while (true) {
            if (curr.val < curr.next.val) {
                if (curr.val <= insertVal && insertVal <= curr.next.val) {
                    insertAfter(curr, insertVal);
                    break;
                }
            }
            if (curr.val > curr.next.val) {
                if (curr.val <= insertVal || insertVal <= curr.next.val) {
                    insertAfter(curr, insertVal);
                    break;
                }
            }
            if (curr.next == head) {
                insertAfter(curr, insertVal);
                break;
            }
            curr = curr.next;
        }
        return head;
    }
    private void insertAfter(Node node, int val) {
        node.next = new Node(val, node.next);
    }
}