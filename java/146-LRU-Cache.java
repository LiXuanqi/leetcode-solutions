class LRUCache {
    class ListNode {
        int key;
        int value;
        ListNode next;
        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    Map<Integer, ListNode> keyToPrev;
    ListNode dummy;
    ListNode tail;
    int size;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        keyToPrev = new HashMap<>();
        dummy = new ListNode(-1, -1);
        tail = dummy;
    }
    
    public int get(int key) {
        if (!keyToPrev.containsKey(key)) {
            return -1;
        }
        moveToTail(key);
        return tail.value;
    }
    
    public void put(int key, int value) {
        if (keyToPrev.containsKey(key)) {
            ListNode prev = keyToPrev.get(key);
            prev.next.value = value;
            moveToTail(prev.next.key);
        } else {
            if (size < capacity) {
                keyToPrev.put(key, tail);
                tail.next = new ListNode(key, value);
                tail = tail.next;
                size++;
            } else {
                // delete head.
                ListNode first = dummy.next;
                keyToPrev.remove(first.key);
                first.key = key;
                first.value = value;
                keyToPrev.put(key, dummy);
                moveToTail(first.key);
            }
        }
    }
    
    private void moveToTail(int key) {
        ListNode prev = keyToPrev.get(key);
        ListNode targetNode = prev.next;
        
        if (targetNode == tail) {
            return;
        }
        
        ListNode nextNode = targetNode.next;
        
        keyToPrev.remove(key);
        keyToPrev.put(key, tail);
        tail.next = targetNode;
        tail = tail.next;
        keyToPrev.put(nextNode.key, prev);
        prev.next = nextNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */