//Given an m x n binary matrix filled with 0's and 1's, find the largest square
//containing only 1's and return its area.
//
//
// Example 1:
//
//
//Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1",
//"1"],["1","0","0","1","0"]]
//Output: 4
//
//
// Example 2:
//
//
//Input: matrix = [["0","1"],["1","0"]]
//Output: 1
//
//
// Example 3:
//
//
//Input: matrix = [["0"]]
//Output: 0
//
//
//
// Constraints:
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 300
// matrix[i][j] is '0' or '1'.
//
// Related Topics Dynamic Programming
// 👍 4529 👎 106


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {

        int[][] dp = new int[matrix.length+1][matrix[0].length+1];

        int maxLength = 0;

        for (int i =0; i< matrix.length; i++) {
            for (int j=0; j< matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    dp[i+1][j+1] = 0;
                } else {
                    dp[i+1][j+1] = Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i][j])) +1;

                    maxLength = Math.max(maxLength, dp[i+1][j+1]);
                }
            }
        }

        return maxLength*maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
