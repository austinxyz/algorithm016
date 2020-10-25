//Given a m x n grid filled with non-negative numbers, find a path from top left
// to bottom right which minimizes the sum of all numbers along its path.
//
// Note: You can only move either down or right at any point in time.
//
// Example:
//
//
//Input:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//Output: 7
//Explanation: Because the path 1→3→1→1→1 minimizes the sum.
//
// Related Topics Array Dynamic Programming
// 👍 3696 👎 70


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {


        int[] memo = new int[grid[0].length];

        for (int j=0; j<grid.length; j++) {

            for (int i = 0; i < grid[0].length; i++) {
                if (j==0 && i ==0) {
                    memo[i] = grid[j][i];
                } else if (j==0) {
                    memo[i] = grid[j][i] + memo[i-1];
                } else if (i==0) {
                    memo[i] = grid[j][i] + memo[i];
                } else {
                    memo[i] = Math.min(memo[i], memo[i-1]) + grid[j][i];
                }
            }
        }

        return memo[grid[0].length-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
