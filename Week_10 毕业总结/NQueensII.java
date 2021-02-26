//The n-queens puzzle is the problem of placing n queens on an n x n chessboard
//such that no two queens attack each other.
//
// Given an integer n, return the number of distinct solutions to the n-queens p
//uzzle.
//
//
// Example 1:
//
//
//Input: n = 4
//Output: 2
//Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
//
//
//
// Example 2:
//
//
//Input: n = 1
//Output: 1
//
//
//
// Constraints:
//
//
// 1 <= n <= 9
//
// Related Topics Backtracking
// 👍 757 👎 178


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public int totalNQueens(int n) {

        int[] result = new int[n];

        return visit(result, 0, n);

    }

    private int visit(int[] result, int row, int n) {

        int count = 0;

        for (int i=0; i< n; i++) {

            result[row] = i;
            if (isValid(result, row)) {

                if (row == n-1) {
                    count++;
                } else {
                    count += visit(result, row+1, n);
                }
            }
        }
        return count;

    }

    private boolean isValid(int[] result, int row) {

        if (row == 0) {
            return true;
        }

        for (int i=0; i< row; i++) {
            if (result[i] == result[row]) {
                return false;
            }

            if (Math.abs(result[i] - result[row]) == row - i) {
                return false;
            }

        }

        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
