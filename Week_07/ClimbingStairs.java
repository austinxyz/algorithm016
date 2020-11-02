//You are climbing a stair case. It takes n steps to reach to the top.
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can yo
//u climb to the top?
//
// Example 1:
//
//
//Input: 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
//
//
// Example 2:
//
//
//Input: 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
//
//
//
// Constraints:
//
//
// 1 <= n <= 45
//
// Related Topics Dynamic Programming
// 👍 5201 👎 168


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }

        int[] result = new int[n+1];

        result[1] = 1;
        result[2] = 2;

        return climbStairs(n, result);
    }

    int climbStairs(int n, int[] result) {
        if (n <= 2) {
            return result[n];
        }

        if (result[n-1] == 0) {
            result[n-1] = climbStairs(n-1, result);
        }

        if (result[n-2] == 0) {
            result[n-2] = climbStairs(n-2, result);
        }

        result[n] = result[n-1] + result[n-2];

        return result[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
