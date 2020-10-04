//Given a 2d grid map of '1's (land) and '0's (water), count the number of islan
//ds. An island is surrounded by water and is formed by connecting adjacent lands
//horizontally or vertically. You may assume all four edges of the grid are all su
//rrounded by water.
//
//
// Example 1:
//
//
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
//
//
// Example 2:
//
//
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
//
// Related Topics Depth-first Search Breadth-first Search Union Find
// 👍 6519 👎 210


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {

        int count = 0;

        for (int i=0; i < grid.length; i++) {

            for (int j=0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    count++;
                    updateGrid(i, j, grid);
                }

            }
        }
        return count;

    }

    void updateGrid(int i, int j, char[][] grid) {

        if (i>=grid.length || i<0 || j>= grid[0].length || j<0 ||  grid[i][j] == '0' ) {
            return;
        }

        grid[i][j] = '0';

        updateGrid(i-1, j, grid);
        updateGrid(i+1, j, grid);
        updateGrid(i, j-1, grid);
        updateGrid(i, j+1, grid);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
