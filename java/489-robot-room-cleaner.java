/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    public void cleanRoom(Robot robot) {
        Set<String> set = new HashSet<>();
        dfs(robot, 0, 0, 0, set);
    }
    private void dfs(Robot robot, int x, int y, int currDirection, Set<String> set) {
        String temp = x + "," + y;
        if (set.contains(temp)) {
            return;
        }
        robot.clean();
        set.add(temp);
        for (int i = 0; i < 4; i++) {
            // 4 directions
            if (robot.move()) {
                int nextX = x;
                int nextY = y;
                switch(currDirection) {
                    case 0:
                        nextX--;
                        break;
                    case 90:
                        nextY++;
                        break;
                    case 180:
                        nextX++;
                        break;
                    case 270:
                        nextY--;
                        break;
                    default:
                        break;
                }
                dfs(robot, nextX, nextY, currDirection, set);
                // move back
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
            currDirection += 90;
            currDirection %= 360;
        }
    }
}