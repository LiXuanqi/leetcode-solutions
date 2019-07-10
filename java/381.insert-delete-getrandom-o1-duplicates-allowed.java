class RandomizedCollection {
    class Entry {
        int val;
        int indexInMap;
        public Entry(int val, int indexInMap) {
            this.val = val;
            this.indexInMap = indexInMap;
        }
    }
    Map<Integer, List<Integer>> map = new HashMap<>();
    List<Entry> data = new ArrayList<>();
    Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        List<Integer> list = map.getOrDefault(val, new ArrayList<>());
        list.add(data.size());
        Entry entry = new Entry(val, list.size() - 1);
        data.add(entry);
        map.put(val, list);
        return list.size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        List<Integer> list = map.get(val);
        int indexToDelete = list.get(list.size() - 1);
        Entry tailEntry = data.get(data.size() - 1);
        
        map.get(tailEntry.val).set(tailEntry.indexInMap, indexToDelete);
        data.set(indexToDelete, tailEntry);
        
        data.remove(data.size() - 1);
        list.remove(list.size() - 1);
        if (list.size() == 0) {
            map.remove(val);
        }
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return data.get(rand.nextInt(data.size())).val;
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */