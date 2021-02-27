//Write a program to solve a Sudoku puzzle by filling the empty cells.
//
// A sudoku solution must satisfy all of the following rules:
//
//
// Each of the digits 1-9 must occur exactly once in each row.
// Each of the digits 1-9 must occur exactly once in each column.
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes
// of the grid.
//
//
// The '.' character indicates empty cells.
//
//
// Example 1:
//
//
//Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5"
//,".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".","."
//,".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".","."
//,"6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"
//],[".",".",".",".","8",".",".","7","9"]]
//Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4
//","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3
//"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],[
//"9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3",
//"4","5","2","8","6","1","7","9"]]
//Explanation: The input board is shown above and the only valid solution is sho
//wn below:
//
//
//
//
//
// Constraints:
//
//
// board.length == 9
// board[i].length == 9
// board[i][j] is a digit or '.'.
// It is guaranteed that the input board has only one solution.
//
// Related Topics Hash Table Backtracking
// 👍 2522 👎 100


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public void solveSudoku(char[][] board) {

        boolean[][] rowused = new boolean[9][10];
        boolean[][] colused = new boolean[9][10];
        boolean[][][] areaused = new boolean[3][3][10];

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rowused[i][num] = true;
                    colused[j][num] = true;
                    areaused[i/3][j/3][num] = true;
                }
            }
        }

        visit(board, rowused, colused, areaused, 0, 0);

    }

    private boolean visit(char[][] board, boolean[][] rowused, boolean[][] colused, boolean[][][] areaused, int row, int col) {

        if (col == 9) {
            col = 0;
            row++;

            if (row == 9) {
                return true;
            }
        }

        if (board[row][col] != '.') {
            return visit(board, rowused, colused, areaused, row, col+1);
        } else {

            for (int num = 1; num <= 9; num++) {

                if (!rowused[row][num] && !colused[col][num] && !areaused[row/3][col/3][num]) {
                    board[row][col] = (char)(num + '0');
                    rowused[row][num] = true;
                    colused[col][num] = true;
                    areaused[row/3][col/3][num] = true;

                    if(visit(board, rowused, colused, areaused, row, col+1)) {
                        return true;
                    }
                    board[row][col] = '.';
                    rowused[row][num] = false;
                    colused[col][num] = false;
                    areaused[row/3][col/3][num] = false;

                }
            }
        }

        return false;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
