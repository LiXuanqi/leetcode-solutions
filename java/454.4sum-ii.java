class Solution {
    class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || B == null || C == null || D == null) {
            return 0;
        }
        int count = 0;
        Map<Integer, Integer> mapAB = getMap(A, B);
        Map<Integer, Integer> mapCD = getMap(C, D);
        for (int sumAB : mapAB.keySet()) {
            int numAB = mapAB.get(sumAB);
            if (mapCD.containsKey(-sumAB)) {
                int numCD = mapCD.get(-sumAB);
                count += numAB * numCD;
            }
        }
        return count;
    }
    private Map<Integer, Integer> getMap(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        return map;
    }
}