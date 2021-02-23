//There are n cities. Some of them are connected, while some are not. If city a
//is connected directly with city b, and city b is connected directly with city c,
// then city a is connected indirectly with city c.
//
// A province is a group of directly or indirectly connected cities and no other
// cities outside of the group.
//
// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
//ith city and the jth city are directly connected, and isConnected[i][j] = 0 othe
//rwise.
//
// Return the total number of provinces.
//
//
// Example 1:
//
//
//Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//Output: 2
//
//
// Example 2:
//
//
//Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//Output: 3
//
//
//
// Constraints:
//
//
// 1 <= n <= 200
// n == isConnected.length
// n == isConnected[i].length
// isConnected[i][j] is 1 or 0.
// isConnected[i][i] == 1
// isConnected[i][j] == isConnected[j][i]
//
// Related Topics Depth-first Search Union Find
// 👍 2745 👎 170


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class FindUnion {

        int count;
        int[] parents;

        FindUnion(int n) {
            count = n;
            parents = new int[n];

            for (int i=0; i<n; i++) {
                parents[i] = i;
            }

        }

        public int find(int p) {

            int x = p;

            while (parents[x] != x) {
                x = parents[x];
            }

            return x;

        }

        public void unin(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) {
                return;
            }
            parents[rootP] = rootQ;
            count--;
        }

        public int getCount() {
            return count;
        }

    }


    public int findCircleNum(int[][] isConnected) {

        FindUnion find = new FindUnion(isConnected.length);

        for (int i = 0; i< isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    find.unin(i, j);
                }
            }
        }

        return find.getCount();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
