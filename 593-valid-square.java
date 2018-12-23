class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int dist1 = getDist(p1, p2);
        int dist2 = getDist(p2, p3);
        int dist3 = getDist(p3, p4);
        int dist4 = getDist(p4, p1);
        int dist5 = getDist(p1, p3);
        int dist6 = getDist(p2, p4);        
        return isValid(new int[] {dist1, dist2, dist3, dist4, dist5, dist6});
    }
    private boolean isValid(int[] dists) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int dist : dists) {
            if (dist == 0) {
                return false;
            }
            map.put(dist, map.getOrDefault(dist, 0) + 1);
        }
        boolean hasTwo = false;
        boolean hasFour = false;
        for (int value : map.values()) {
            if (value == 2) {
                hasTwo = true;
            } else if (value == 4) {
                hasFour = true;
            }
        }
        return hasTwo && hasFour;
    }
    private int getDist(int[] p1, int[] p2) {
        int diffX = p1[0] - p2[0];
        int diffY = p1[1] - p2[1];
        return diffX * diffX + diffY * diffY;
    }
}