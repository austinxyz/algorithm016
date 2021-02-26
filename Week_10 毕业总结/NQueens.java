//The n-queens puzzle is the problem of placing n queens on an n x n chessboard
//such that no two queens attack each other.
//
// Given an integer n, return all distinct solutions to the n-queens puzzle.
//
// Each solution contains a distinct board configuration of the n-queens' placem
//ent, where 'Q' and '.' both indicate a queen and an empty space, respectively.
//
//
// Example 1:
//
//
//Input: n = 4
//Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as show
//n above
//
//
// Example 2:
//
//
//Input: n = 1
//Output: [["Q"]]
//
//
//
// Constraints:
//
//
// 1 <= n <= 9
//
// Related Topics Backtracking
// 👍 2673 👎 98


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> solutions = new ArrayList<List<String>>();
        int[] result = new int[n];
        visit(result, 0, solutions);

        return solutions;

    }

    private void visit(int[] result, int row, List<List<String>> solutions) {
        int n = result.length;

        for (int i=0; i<n; i++) {
            result[row] = i;
            if (isValid(result, row)) {
                if (row==n-1) {
                    solutions.add(toList(result));
                } else {
                    visit(result, row+1, solutions);
                }
            }
        }

        return;
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

    private List<String> toList(int[] result) {
        int n = result.length;
        List<String> res = new ArrayList<String>();
        StringBuffer sb = null;
        for (int i=0; i<n; i++) {
            sb = new StringBuffer();
            for (int j=0; j<n; j++) {
                if (result[i] == j) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
