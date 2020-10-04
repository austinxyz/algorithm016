//Let's play the minesweeper game (Wikipedia, online game)!
//
// You are given a 2D char matrix representing the game board. 'M' represents an
// unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a re
//vealed blank square that has no adjacent (above, below, left, right, and all 4 d
//iagonals) mines, digit ('1' to '8') represents how many mines are adjacent to th
//is revealed square, and finally 'X' represents a revealed mine.
//
// Now given the next click position (row and column indices) among all the unre
//vealed squares ('M' or 'E'), return the board after revealing this position acco
//rding to the following rules:
//
//
// If a mine ('M') is revealed, then the game is over - change it to 'X'.
// If an empty square ('E') with no adjacent mines is revealed, then change it t
//o revealed blank ('B') and all of its adjacent unrevealed squares should be reve
//aled recursively.
// If an empty square ('E') with at least one adjacent mine is revealed, then ch
//ange it to a digit ('1' to '8') representing the number of adjacent mines.
// Return the board when no more squares will be revealed.
//
//
//
//
// Example 1:
//
//
//Input:
//
//[['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'M', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E']]
//
//Click : [3,0]
//
//Output:
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//Explanation:
//
//
//
// Example 2:
//
//
//Input:
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//Click : [1,2]
//
//Output:
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'X', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//Explanation:
//
//
//
//
//
// Note:
//
//
// The range of the input matrix's height and width is [1,50].
// The click position will only be an unrevealed square ('M' or 'E'), which also
// means the input board contains at least one clickable square.
// The input board won't be a stage when game is over (some mines have been reve
//aled).
// For simplicity, not mentioned rules should be ignored in this problem. For ex
//ample, you don't need to reveal all the unrevealed mines when the game is over,
//consider any cases that you will win the game or flag any squares.
//
// Related Topics Depth-first Search Breadth-first Search
// 👍 690 👎 554


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {

        int i = click[0];
        int j = click[1];

        if (board[i][j] == 'M') {
            board[i][j] = 'X';
        }

        if (board[i][j] == 'E') {

            int count = getCount(board, i, j);

            if (count == 0) {

                board[i][j] = 'B';

                for (int x=i-1; x<i+2; x++) {
                    for (int y = j-1; y<j+2; y++) {

                        if (x==i && y==j) {
                            continue;
                        }

                        if (x>=0 && x<board.length && y>=0 && y<board[0].length && board[x][y]=='E') {
                            int[] newclick = {x, y};
                            updateBoard(board, newclick);
                        }

                    }
                }

            } else
                board[i][j] = (char)(count + '0');
        }

        return board;
    }

    int getCount(char[][] board, int i, int j) {

        int count=0;

        for (int x=i-1; x<i+2; x++) {
            for (int y = j-1; y<j+2; y++) {

                if (x>=0 && x<board.length && y>=0 && y<board[0].length) {

                    if (x==i && y==j) {
                        continue;
                    }

                    if (board[x][y] == 'M') {
                        count++;
                    }
                }

            }
        }

        return count;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
