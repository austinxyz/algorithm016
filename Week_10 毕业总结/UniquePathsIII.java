//On a 2-dimensional grid, there are 4 types of squares:
//
//
// 1 represents the starting square. There is exactly one starting square.
// 2 represents the ending square. There is exactly one ending square.
// 0 represents empty squares we can walk over.
// -1 represents obstacles that we cannot walk over.
//
//
// Return the number of 4-directional walks from the starting square to the endi
//ng square, that walk over every non-obstacle square exactly once.
//
//
//
//
// Example 1:
//
//
//Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
//Output: 2
//Explanation: We have the following two paths:
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
//2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
//
//
// Example 2:
//
//
//Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
//Output: 4
//Explanation: We have the following four paths:
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
//2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
//3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
//4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
//
//
// Example 3:
//
//
//Input: [[0,1],[2,0]]
//Output: 0
//Explanation:
//There is no path that walks over every empty square exactly once.
//Note that the starting and ending square can be anywhere in the grid.
//
//
//
//
//
//
//
// Note:
//
//
// 1 <= grid.length * grid[0].length <= 20
// Related Topics Backtracking Depth-first Search
// 👍 1296 👎 87


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int startx=0;
    int starty=0;
    int endx=0;
    int endy=0;
    int pathLength = 0;
    int count = 0;

    public int uniquePathsIII(int[][] grid) {

        int[][] used = new int[grid.length][grid[0].length];

        init(grid);

        visit(grid, used, startx, starty, 0);

        return count;
    }

    private void init(int[][] grid) {

        int count = 0;

        for (int i =0; i< grid.length; i++) {
            for (int j=0; j<grid[0].length; j++ ) {
                if (grid[i][j] != -1) {
                    count++;
                    if (grid[i][j] == 1) {
                        startx = i;
                        starty = j;
                    }

                    if (grid[i][j] == 2) {
                        endx = i;
                        endy = j;
                    }
                }
            }
        }
        pathLength = count;
    }

    private void visit(int[][] grid, int[][] used, int x, int y, int path) {

        if (x<0 || y<0 || x>=grid.length || y>=grid[0].length || used[x][y] == 1 || grid[x][y] == -1) {
            return;
        }

        if (x==endx && y==endy && path == pathLength-1) {
            count++;
            return;
        }

        used[x][y] = 1;

        visit(grid, used, x+1, y, path+1);

        visit(grid, used, x-1, y, path+1);

        visit(grid, used, x, y-1, path+1);

        visit(grid, used, x, y+1, path+1);

        used[x][y] = 0;

        return;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
