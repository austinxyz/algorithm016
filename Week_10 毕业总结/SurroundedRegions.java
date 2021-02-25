//Given an m x n matrix board containing 'X' and 'O', capture all regions surrou
//nded by 'X'.
//
// A region is captured by flipping all 'O's into 'X's in that surrounded region
//.
//
//
// Example 1:
//
//
//Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O"
//,"X","X"]]
//Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X
//"]]
//Explanation: Surrounded regions should not be on the border, which means that
//any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not o
//n the border and it is not connected to an 'O' on the border will be flipped to
//'X'. Two cells are connected if they are adjacent cells connected horizontally o
//r vertically.
//
//
// Example 2:
//
//
//Input: board = [["X"]]
//Output: [["X"]]
//
//
//
// Constraints:
//
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 200
// board[i][j] is 'X' or 'O'.
//
// Related Topics Depth-first Search Breadth-first Search Union Find
// 👍 2519 👎 748


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public void solve(char[][] board) {

        int[][] visited = new int[board.length][board[0].length];

        for (int i=0; i< board.length; i++) {
            for (int j=0; j<board[0].length; j++) {

                if (board[i][j] == 'O') {

                    Set<Integer> olist = new HashSet<Integer>();

                    if (check (board, visited, i, j, olist)) {
                        for (int x: olist) {
                            board[x/board[0].length][x%board[0].length] = 'X';
                        }
                    }

                }

            }
        }

    }

    private boolean check(char[][] board, int[][] visited, int i, int j, Set<Integer> olist) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] == 1 || olist.contains(i*board[0].length +j)) {
            return true;
        }

        visited[i][j] = 1;

        if (board[i][j] == 'X') {
            visited[i][j] = 0;
            return true;
        }

        if (i == 0 || j == 0 || i == board.length-1 || j == board[0].length-1) {
            visited[i][j] = 0;
            return false;
        }

        olist.add(i*board[0].length + j);

        boolean changed = check(board, visited, i-1, j, olist) && check(board, visited, i+1, j, olist)
                && check(board, visited, i, j-1, olist) && check(board, visited, i, j+1, olist);
        visited[i][j] = 0;

        return changed;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
