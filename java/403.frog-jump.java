class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            int pos = stones[i];
            if (map.containsKey(pos)) {
                for (int prevStep : map.get(pos)) {
                    // k - 1
                    if (prevStep - 1 != 0 && map.containsKey(pos + prevStep - 1)) {
                        map.get(pos + prevStep - 1).add(prevStep - 1);
                    }
                    // k
                    if (map.containsKey(pos + prevStep)) {
                        map.get(pos + prevStep).add(prevStep);
                    }
                    if (map.containsKey(pos + prevStep + 1)) {
                        map.get(pos + prevStep + 1).add(prevStep + 1);
                    }
                }   
            } 
        }
        return map.get(stones[stones.length - 1]).size() != 0;
    }
}