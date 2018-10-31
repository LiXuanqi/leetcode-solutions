class Solution {
    class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }    
        List<Coordinate> people = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    people.add(new Coordinate(i, j));
                }
            }
        }
        Coordinate bestPosition = findBestPosition(people);
        int ans = 0;
        for (Coordinate person : people) {
            ans += getDistance(bestPosition, person);
        }
        // System.out.println(bestPosition.x);
        // System.out.println(bestPosition.y);
        return ans;
        
    }
    private int getDistance(Coordinate c1, Coordinate c2) {
        return Math.abs(c1.y - c2.y) + Math.abs(c1.x - c2.x);
    }
    private Coordinate findBestPosition(List<Coordinate> people) {
        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();
        int sumX = 0;
        int sumY = 0;
        for (Coordinate person : people) {
            xs.add(person.x);
            ys.add(person.y);
        }
        return new Coordinate(findMedian(xs), findMedian(ys));
    }
    private int findMedian(List<Integer> nums) {
        Collections.sort(nums);
        return nums.get(nums.size() / 2);
    }
    
}