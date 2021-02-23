//Given an array equations of strings that represent relationships between varia
//bles, each string equations[i] has length 4 and takes one of two different forms
//: "a==b" or "a!=b". Here, a and b are lowercase letters (not necessarily differe
//nt) that represent one-letter variable names.
//
// Return true if and only if it is possible to assign integers to variable name
//s so as to satisfy all the given equations.
//
//
//
//
//
//
//
// Example 1:
//
//
//Input: ["a==b","b!=a"]
//Output: false
//Explanation: If we assign say, a = 1 and b = 1, then the first equation is sat
//isfied, but not the second.  There is no way to assign the variables to satisfy
//both equations.
//
//
//
// Example 2:
//
//
//Input: ["b==a","a==b"]
//Output: true
//Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
//
//
//
// Example 3:
//
//
//Input: ["a==b","b==c","a==c"]
//Output: true
//
//
//
// Example 4:
//
//
//Input: ["a==b","b!=c","c==a"]
//Output: false
//
//
//
// Example 5:
//
//
//Input: ["c==c","b==d","x!=z"]
//Output: true
//
//
//
//
// Note:
//
//
// 1 <= equations.length <= 500
// equations[i].length == 4
// equations[i][0] and equations[i][3] are lowercase letters
// equations[i][1] is either '=' or '!'
// equations[i][2] is '='
//
//
//
//
//
//
// Related Topics Union Find Graph
// 👍 745 👎 6


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


    public boolean equationsPossible(String[] equations) {

        UnionFind find = new UnionFind(26);


        for (String equ: equations) {

            char first = equ.charAt(0);
            char second = equ.charAt(3);

            boolean in = equ.charAt(1) == '=';

            if (in) {
                find.union(first-'a', second-'a');
            }

        }

        for (String equ: equations) {
            char first = equ.charAt(0);
            char second = equ.charAt(3);

            boolean in = equ.charAt(1) == '=';

            if (!in) {

                if (find.find(first-'a') == find.find(second - 'a') ) {
                    return false;
                }

            }

        }

        return true;

    }

}
//leetcode submit region end(Prohibit modification and deletion)
