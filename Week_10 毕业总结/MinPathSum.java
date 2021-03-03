//Given a m x n grid filled with non-negative numbers, find a path from top left
// to bottom right, which minimizes the sum of all numbers along its path.
//
// Note: You can only move either down or right at any point in time.
//
//
// Example 1:
//
//
//Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
//Output: 7
//Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
//
//
// Example 2:
//
//
//Input: grid = [[1,2,3],[4,5,6]]
//Output: 12
//
//
//
// Constraints:
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 200
// 0 <= grid[i][j] <= 100
//
// Related Topics Array Dynamic Programming
// 👍 4340 👎 79


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {

        int[] path = new int[grid[0].length+1];

        path[0] = 0;
        for (int i=1; i<=grid[0].length; i++) {
            path[i] = grid[0][i-1] + path[i-1];
        }

        for (int i=1; i<grid.length; i++) {
            for (int j=1; j<=grid[0].length; j++) {
                if (j==1) {
                    path[j] = path[j] + grid[i][0];
                } else {
                    path[j] = Math.min(path[j], path[j-1]) + grid[i][j-1];
                }
            }
        }


        return path[grid[0].length];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
