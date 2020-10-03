//A robot on an infinite grid starts at point (0, 0) and faces north. The robot
//can receive one of three possible types of commands:
//
//
// -2: turn left 90 degrees
// -1: turn right 90 degrees
// 1 <= x <= 9: move forward x units
//
//
// Some of the grid squares are obstacles.
//
// The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])
//
// If the robot would try to move onto them, the robot stays on the previous gri
//d square instead (but still continues following the rest of the route.)
//
// Return the square of the maximum Euclidean distance that the robot will be fr
//om the origin.
//
//
//
// Example 1:
//
//
//Input: commands = [4,-1,3], obstacles = []
//Output: 25
//Explanation: robot will go to (3, 4)
//
//
//
// Example 2:
//
//
//Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//Output: 65
//Explanation: robot will be stuck at (1, 4) before turning left and going to (1
//, 8)
//
//
//
//
//
// Note:
//
//
// 0 <= commands.length <= 10000
// 0 <= obstacles.length <= 10000
// -30000 <= obstacle[i][0] <= 30000
// -30000 <= obstacle[i][1] <= 30000
// The answer is guaranteed to be less than 2 ^ 31.
//
// Related Topics Greedy
// 👍 185 👎 852


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0;
        int y = 0;

        int direction = 0;

        int maxDist = 0;

        for (int i =0; i< commands.length; i++) {

            if (commands[i] < 0) {
                direction = getNewDirection(direction, commands[i]);
            } else {

                x = getNewX(commands[i], x, y,  direction, obstacles);
                y = getNewY(commands[i], y, x, direction, obstacles);

                maxDist = Math.max(maxDist, x*x+y*y);

            }

        }

        return maxDist;

    }

    int getNewX(int cmd, int x, int y, int direction, int[][] obstacles) {

        if (direction == 1) { // east

            int obsX = 30001;

            for (int[] loc: obstacles ) {
                if (y == loc[1]) {
                    if (loc[0] > x && loc[0] <= x+cmd) {
                        obsX = Math.min(obsX, loc[0]);
                    }
                }
            }

            if (obsX > x && obsX <= x+cmd) {
                x = obsX -1;
            } else {
                x = x + cmd;
            }
        }

        if (direction == 3) { //west

            int obsX = -30001;

            for (int[] loc: obstacles ) {
                if (y == loc[1]) {
                    if (loc[0] < x && loc[0] >= x-cmd) {
                        obsX = Math.max(obsX, loc[0]);
                    }
                }
            }

            if (obsX < x && obsX >= x-cmd) {
                x = obsX +1;
            } else {
                x = x - cmd;
            }

        }

        return x;

    }

    int getNewY(int cmd, int y, int x, int direction, int[][] obstacles) {

        if (direction == 0) { // north

            int obsY = 30001;

            for (int[] loc: obstacles ) {
                if (x == loc[0]) {
                    if (loc[1] > y && loc[1] <= y+cmd) {
                        obsY = Math.min(obsY, loc[1]);
                    }
                }
            }

            if (obsY > y && obsY <= y+cmd) {
                y = obsY -1;
            } else {
                y = y + cmd;
            }
        }

        if (direction == 2) { //south

            int obsY = -30001;

            for (int[] loc: obstacles ) {
                if (x == loc[0]) {
                    if (loc[1] < y && loc[1] >= y-cmd) {
                        obsY = Math.max(obsY, loc[1]);
                    }
                }
            }

            if (obsY < y && obsY >= y-cmd) {
                y = obsY +1;
            } else {
                y = y - cmd;
            }

        }

        return y;

    }

    int getNewDirection(int direction, int cmd) {
        if (cmd == -1) {
            direction++;
        }

        if (cmd == -2) {
            direction--;
        }

        if (direction == 4 ) {
            direction = 0;
        }

        if (direction == -1) {
            direction = 3;
        }

        return direction;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
