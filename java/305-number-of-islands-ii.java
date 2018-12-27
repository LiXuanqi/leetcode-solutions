class Solution {
    class UnionFind {
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        public UnionFind(int m, int n) {
            int total = m * n;
            for (int i = 0; i < total; i++) {
                father.put(i, i);
            }
        }
        int find(int x) {
            int parent = father.get(x);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
            return parent;
        }
        void union(int x, int y) {
            int faX = find(x);
            int faY = find(y);
            if (faX != faY) {
                father.put(faX, faY);
            }
        }
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if (positions == null || positions.length == 0 || positions[0].length == 0) {
            return result;
        }
        int[] directionX = {0, 0, -1, 1};
        int[] directionY = {1, -1, 0, 0};
        int[][] matrix = new int[m][n];
        int count = 0;
        UnionFind uf = new UnionFind(m, n);
        for (int[] position : positions) {
            int x = position[0];
            int y = position[1];
            if (matrix[x][y] == 1) {
                continue;
            }
            matrix[x][y] = 1;
            count++;
            int currFather = uf.find(convertToId(x, y, n));
            // 4 directions
            for (int i = 0; i < 4; i++) {
          
                int neighborX = x + directionX[i];
                int neighborY = y + directionY[i];
                if (!isValid(neighborX, neighborY, matrix) || matrix[neighborX][neighborY] != 1) {
                    continue;
                }
                int neighborFather = uf.find(convertToId(neighborX, neighborY, n));
                if (currFather != neighborFather) {
                    count--;
                    uf.union(convertToId(neighborX, neighborY, n), convertToId(x, y, n));
                }
            }
            result.add(count);
        }
        return result;
    }
    private boolean isValid(int x, int y, int[][] matrix) {
        return 0 <= x && x < matrix.length && 0 <= y && y < matrix[0].length;
    }
    private int convertToId(int x, int y, int n) {
        return x * n + y;
    }
}