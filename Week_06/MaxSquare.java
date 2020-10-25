//Given a 2D binary matrix filled with 0's and 1's, find the largest square cont
//aining only 1's and return its area.
//
// Example:
//
//
//Input:
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//Output: 4
// Related Topics Dynamic Programming
// 👍 3622 👎 93


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {

        if (matrix.length < 1) {
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];

        int max = 0;

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j< matrix[0].length; j++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = (matrix[i][j] == '1'? 1: 0);
                } else {
                    dp[i][j] = (matrix[i][j] == '1'? (1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]))): 0);
                }

                max = Math.max(max, dp[i][j]);
            }
        }

        return max*max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
