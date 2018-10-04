class TwoSum {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    /** Initialize your data structure here. */
    public TwoSum() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        list.add(number);
        map.put(number, list.size() - 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int i = 0; i < list.size(); i++) {
            int wanted = value - list.get(i);
            if (map.containsKey(wanted) && map.get(wanted) != i) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */

// if keep sorted: add O(n); find O(n);
// if hashmap: add O(1); find O(n);
