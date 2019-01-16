class Solution {
    class UnionFind {
        Map<Integer, Integer> parents = new HashMap<>();
        public UnionFind(int n) {
            for (int i = 0; i < n; i++) {
                parents.put(i, i);
            }
        }
        public void union(int x, int y) {
            int faX = find(x);
            int faY = find(y);
            if (faX != faY) {
                parents.put(faX, faY);
            }
        }
        public int find(int x) {
            int parent = x;
            while (parent != parents.get(parent)) {
                parent = parents.get(parent);
            }
            return parent;
        }
        public int count() {
            Set<Integer> set = new HashSet<>();
            for (int parent : parents.values()) {
                set.add(find(parent));
            }
            return set.size();
        }
    }
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.count();
    }
}