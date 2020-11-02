//Given an m x n 2d grid map of '1's (land) and '0's (water), return the number
//of islands.
//
// An island is surrounded by water and is formed by connecting adjacent lands h
//orizontally or vertically. You may assume all four edges of the grid are all sur
//rounded by water.
//
//
// Example 1:
//
//
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
//
//
// Example 2:
//
//
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
//
//
//
// Constraints:
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] is '0' or '1'.
//
// Related Topics Depth-first Search Breadth-first Search Union Find
// 👍 6788 👎 218


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class UnionFind {
        private int count = 0;
        private int[] parent;
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int find(int p) {
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

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i< grid.length; i++) {
            for (int j=0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                }
            }
        }

        UnionFind uf = new UnionFind(count);

        Map<Integer, Integer> positionMap = new HashMap<Integer, Integer>();

        int index = 0;

        for (int i = 0; i< grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    positionMap.put(i*grid[0].length + j, index);

                    if (i > 0 && grid[i-1][j] == '1') {
                        uf.union(index, positionMap.get((i-1)*grid[0].length + j));
                    }

                    if (j > 0 && grid[i][j-1] == '1') {
                        uf.union(index, positionMap.get(i*grid[0].length + j - 1));
                    }
                    index++;
                }
            }
        }

        return uf.getCount();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
