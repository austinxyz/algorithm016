//You are given coins of different denominations and a total amount of money amo
//unt. Write a function to compute the fewest number of coins that you need to mak
//e up that amount. If that amount of money cannot be made up by any combination o
//f the coins, return -1.
//
// You may assume that you have an infinite number of each kind of coin.
//
//
// Example 1:
//
//
//Input: coins = [1,2,5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
//
//
// Example 2:
//
//
//Input: coins = [2], amount = 3
//Output: -1
//
//
// Example 3:
//
//
//Input: coins = [1], amount = 0
//Output: 0
//
//
// Example 4:
//
//
//Input: coins = [1], amount = 1
//Output: 1
//
//
// Example 5:
//
//
//Input: coins = [1], amount = 2
//Output: 2
//
//
//
// Constraints:
//
//
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104
//
// Related Topics Dynamic Programming
// 👍 6156 👎 189


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] memo = new int[amount+1];

        for (int i=1; i<=amount; i++) {

            memo[i] = Integer.MAX_VALUE;

            for (int j=0; j<coins.length; j++) {
                if (i >= coins[j]) {
                    memo[i] = Math.min(memo[i-coins[j]], memo[i]);
                }
            }
            if (memo[i] != Integer.MAX_VALUE) {
                memo[i] = memo[i] +1;
            }

        }

        if (memo[amount] == Integer.MAX_VALUE) {
            return -1;
        }

        return memo[amount];

    }

}
//leetcode submit region end(Prohibit modification and deletion)
