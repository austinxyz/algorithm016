//A robot is located at the top-left corner of a m x n grid (marked 'Start' in t
//he diagram below).
//
// The robot can only move either down or right at any point in time. The robot
//is trying to reach the bottom-right corner of the grid (marked 'Finish' in the d
//iagram below).
//
// How many possible unique paths are there?
//
//
// Example 1:
//
//
//Input: m = 3, n = 7
//Output: 28
//
//
// Example 2:
//
//
//Input: m = 3, n = 2
//Output: 3
//Explanation:
//From the top-left corner, there are a total of 3 ways to reach the bottom-righ
//t corner:
//1. Right -> Down -> Down
//2. Down -> Down -> Right
//3. Down -> Right -> Down
//
//
// Example 3:
//
//
//Input: m = 7, n = 3
//Output: 28
//
//
// Example 4:
//
//
//Input: m = 3, n = 3
//Output: 6
//
//
//
// Constraints:
//
//
// 1 <= m, n <= 100
// It's guaranteed that the answer will be less than or equal to 2 * 109.
//
// Related Topics Array Dynamic Programming
// 👍 4643 👎 236


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePaths(int m, int n) {

        int[] path = new int[n+1];
        path[0] = 1;

        for (int i=0; i<m; i++) {
            for (int j=1; j<=n; j++) {
                path[j] = path[j-1] + (i!=0?path[j]:0);
            }
            path[0]=0;
        }

        return path[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
