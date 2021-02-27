//Given an m x n board and a word, find if the word exists in the grid.
//
// The word can be constructed from letters of sequentially adjacent cells, wher
//e "adjacent" cells are horizontally or vertically neighboring. The same letter c
//ell may not be used more than once.
//
//
// Example 1:
//
//
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCCED"
//Output: true
//
//
// Example 2:
//
//
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "SEE"
//Output: true
//
//
// Example 3:
//
//
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCB"
//Output: false
//
//
//
// Constraints:
//
//
// m == board.length
// n = board[i].length
// 1 <= m, n <= 200
// 1 <= word.length <= 103
// board and word consists only of lowercase and uppercase English letters.
//
// Related Topics Array Backtracking
// 👍 5241 👎 226


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean exist(char[][] board, String word) {


        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                int[][] used = new int[board.length][board[0].length];
                if (search (board, used, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean search(char[][] board, int[][] used, int i, int j, String word, int index) {

        if (i <0 || j<0 || i>= board.length || j>=board[0].length || used[i][j] == 1 ) {
            return false;
        }

        char c = word.charAt(index);

        if (board[i][j] != c) {
            return false;
        }

        if (index == word.length()-1) {
            return true;
        }

        used[i][j] = 1;

        if (search(board, used, i+1, j, word, index+1)) {
            return true;
        }

        if (search(board, used, i-1, j, word, index+1)) {
            return true;
        }

        if (search(board, used, i, j+1, word, index+1)) {
            return true;
        }

        if (search(board, used, i, j-1, word, index+1)) {
            return true;
        }

        used[i][j] = 0;

        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
