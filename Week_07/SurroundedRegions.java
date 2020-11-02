//Given a 2D board containing 'X' and 'O' (the letter O), capture all regions su
//rrounded by 'X'.
//
// A region is captured by flipping all 'O's into 'X's in that surrounded region
//.
//
// Example:
//
//
//X X X X
//X O O X
//X X O X
//X O X X
//
//
// After running your function, the board should be:
//
//
//X X X X
//X X X X
//X X X X
//X O X X
//
//
// Explanation:
//
// Surrounded regions shouldn’t be on the border, which means that any 'O' on th
//e border of the board are not flipped to 'X'. Any 'O' that is not on the border
//and it is not connected to an 'O' on the border will be flipped to 'X'. Two cell
//s are connected if they are adjacent cells connected horizontally or vertically.
//
// Related Topics Depth-first Search Breadth-first Search Union Find
// 👍 2190 👎 717


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class UnionFind {
        private int count = 0;
        private int[] parent;
        public UnionFind(char[][] board) {

            parent = new int[board.length * board[0].length];

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j< board[0].length; j++) {
                    if (board[i][j] == 'O') {
                        parent[i* board[0].length + j] = i*board[0].length + j;
                        count++;
                    } else {
                        parent[i*board[0].length + j] = -1;
                    }
                }
            }
        }

        public int find(int p) {
            if (parent[p] == -1) {
                return -1;
            }
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }
        public int getCount() {
            return count;
        }
    }


    public void solve(char[][] board) {

        if (board.length == 0) {
            return;
        }

        UnionFind uf = new UnionFind(board);

        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    if (!inboard(i, j, board.length-1, board[0].length-1)) {
                        if (board[i - 1][j] == 'O') {
                            uf.union(i * board[0].length + j, (i - 1) * board[0].length + j);
                        }

                        if (board[i + 1][j] == 'O') {
                            uf.union(i * board[0].length + j, (i + 1) * board[0].length + j);
                        }

                        if (board[i][j - 1] == 'O') {
                            uf.union(i * board[0].length + j, i * board[0].length + j - 1);
                        }

                        if (board[i][j + 1] == 'O') {
                            uf.union(i * board[0].length + j, i * board[0].length + j + 1);
                        }

                    } else {
                        set.add(i * board[0].length + j);
                    }
                }
            }
        }

        Set<Integer> pSet = new HashSet<Integer>();
        for (int i : set) {
            pSet.add(uf.find(i));
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !pSet.contains(uf.find(i * board[0].length + j))) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    boolean inboard(int x, int y, int m, int n) {
        return  (x == 0 || x == m) || (y == 0 || y == n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
