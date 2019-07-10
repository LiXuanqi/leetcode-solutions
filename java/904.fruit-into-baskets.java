class Solution {
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int count = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < tree.length) {
            map.put(tree[right], map.getOrDefault(tree[right], 0) + 1);
            right++;
            while (map.size() > 2) {
                map.put(tree[left], map.get(tree[left]) - 1);
                if (map.get(tree[left]) == 0) {
                    map.remove(tree[left]);
                }
                left++;
            }
            count = Math.max(count, right - left);
        }
        return count;
    }
}