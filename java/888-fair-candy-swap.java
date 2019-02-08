class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            sumA += num;
        }
        for (int num : B) {
            sumB += num;
            set.add(num);
        }
        int delta = (sumB - sumA) / 2;
        for (int num : A) {
            int want = num + delta;
            if (set.contains(want)) {
                return new int[] {num, want};
            }
        }
        return null;
    }
}