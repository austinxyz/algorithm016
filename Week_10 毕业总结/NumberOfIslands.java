//Given an m x n 2d grid map of '1's (land) and '0's (water), return the number
//of islands.
//
// An island is surrounded by water and is formed by connecting adjacent lands h
//orizontally or vertically. You may assume all four edges of the grid are all sur
//rounded by water.
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
//
//
// Constraints:
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] is '0' or '1'.
//
// Related Topics Depth-first Search Breadth-first Search Union Find
// 👍 7743 👎 237


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int numIslands(char[][] grid) {

        int count = 0;
        int[][] visited = new int[grid.length][grid[0].length];

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    search(grid, visited, i, j);
                }
            }
        }

        return count;
    }

    private void search(char[][] grid, int[][] visited, int i, int j) {

        if (i <0 || j <0 || i >= grid.length || j >=grid[0].length || grid[i][j] == '0') {
            return;
        }

        if (grid[i][j] == '1') {
            grid[i][j] = '0';
        }

        search(grid, visited, i+1, j);
        search(grid, visited, i-1, j);
        search(grid, visited, i, j+1);
        search(grid, visited, i, j-1);

        return;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
