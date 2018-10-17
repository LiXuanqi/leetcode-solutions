/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node curr = head;
        while (curr != null) {
            if (curr.child == null) {
                curr = curr.next;
                continue;
            }
            // find the tail of child chain.
            Node temp = curr.child;
            while (temp.next != null) {
                temp = temp.next;
            }
            // connect tail with next.
            temp.next = curr.next;
            if (curr.next != null) {
                curr.next.prev = temp;
            }
            
            curr.next = curr.child;
            curr.child.prev = curr;
            curr.child = null;
        }
        return head;
    }
}