//Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (r
//epresenting land) connected 4-directionally (horizontal or vertical.) You may as
//sume all four edges of the grid are surrounded by water.
//
// Find the maximum area of an island in the given 2D array. (If there is no isl
//and, the maximum area is 0.)
//
// Example 1:
//
//
//[[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
//
//Given the above grid, return 6. Note the answer is not 11, because the island
//must be connected 4-directionally.
//
// Example 2:
//
//
//[[0,0,0,0,0,0,0,0]]
//Given the above grid, return 0.
//
// Note: The length of each dimension in the given grid does not exceed 50.
// Related Topics Array Depth-first Search
// 👍 2765 👎 93


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;

        for (int i=0; i< grid.length; i++) {
            for (int j=0; j< grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = getArea(grid, 0, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;

    }

    private int getArea(int[][] grid, int area, int i, int j) {
        if (i <0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0) {
            return area;
        }

        grid[i][j] = 0;

        int newArea = area+1;

        newArea = getArea(grid, newArea, i-1, j);
        newArea = getArea(grid, newArea, i+1, j);
        newArea = getArea(grid, newArea, i, j-1);
        newArea = getArea(grid, newArea, i, j+1);

        return newArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
