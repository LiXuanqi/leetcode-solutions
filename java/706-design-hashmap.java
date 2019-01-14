class MyHashMap {
    class ListNode {
        int key;
        int value;
        ListNode next;
        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    int CAPACITY = 10000;
    ListNode[] bukkits = new ListNode[CAPACITY];
    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % CAPACITY;
        ListNode node = new ListNode(key, value);
        if (bukkits[index] == null) {
            bukkits[index] = node;
        } else {
            ListNode curr = bukkits[index];
            while (curr.next != null) {
                if (curr.key == key) {
                    curr.value = value;
                    break;
                }
                curr = curr.next;
            }
            if (curr.key == key) {
                curr.value = value;
            } else {
                curr.next = node;   
            }
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % CAPACITY;
        ListNode curr = bukkits[index];
        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % CAPACITY;
        if (bukkits[index] == null) {
            return;
        } else {
            ListNode dummy = new ListNode(-1, -1);
            dummy.next = bukkits[index];
            ListNode curr = dummy.next;
            ListNode prev = dummy;
            while (curr != null) {
                if (curr.key == key) {
                    prev.next = curr.next;
                    curr.next = null;
                    break;
                }
                curr = curr.next;
                prev = prev.next;
            }
            bukkits[index] = dummy.next;
        }

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */