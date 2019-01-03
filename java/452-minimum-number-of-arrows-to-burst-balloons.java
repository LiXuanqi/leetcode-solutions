class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }
        // sort by end
        Arrays.sort(points, (p1, p2) -> {
            return Integer.compare(p1[1], p2[1]);
        });
        int count = 1;
        int pos = points[0][1];
        for (int[] point : points) {
            if (point[0] <= pos) {
                continue;
            }
            count++;
            pos = point[1];
        }
        return count;
    }
}