class MyLinkedList {
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    
    private ListNode dummy;
    private ListNode tail;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.dummy = new ListNode(-1);
        this.tail = dummy;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        ListNode curr = dummy.next;
        while (index > 0 && curr != null) {
            curr = curr.next;
            index--;
        }
        if (curr == null) {
            return -1;
        }
        // this.print();
        return curr.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode next = dummy.next;
        dummy.next = new ListNode(val);
        if (next == null) {
            tail = dummy.next;
        }
        dummy.next.next = next;
        // this.print();
        // System.out.println(tail.val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        tail.next = new ListNode(val);
        tail = tail.next;
        this.print();
        System.out.println(tail.val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode curr = dummy.next;
        ListNode prev = dummy;
        while (index > 0 && curr != null) {
            curr = curr.next;
            prev = prev.next;
            index--;
        }
        if (index != 0) {
            return;
        }
        prev.next = new ListNode(val);
        prev.next.next = curr;
        if (index == 0 && curr == null) {
            tail = prev.next;
        }
        // this.print();
        // System.out.println(tail.val);
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode curr = dummy.next;
        ListNode prev = dummy;
        while (index > 0 && curr != null) {
            curr = curr.next;
            prev = prev.next;
            index--;
        }
        if (curr == null) {
            return;
        }
        if (curr.next == null) {
            tail = prev;
        }
        prev.next = curr.next;
        // this.print();
        // System.out.println(tail.val);
    }
    public void print() {
        StringBuilder sb = new StringBuilder();
        ListNode curr = dummy.next;
        while (curr != null) {
            sb.append(curr.val);
            sb.append("->");
            curr = curr.next;
        }
        // System.out.println(sb.toString());
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */