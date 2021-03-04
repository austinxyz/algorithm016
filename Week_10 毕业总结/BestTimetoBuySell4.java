//You are given an integer array prices where prices[i] is the price of a given
//stock on the ith day.
//
// Design an algorithm to find the maximum profit. You may complete at most k tr
//ansactions.
//
// Notice that you may not engage in multiple transactions simultaneously (i.e.,
// you must sell the stock before you buy again).
//
//
// Example 1:
//
//
//Input: k = 2, prices = [2,4,1]
//Output: 2
//Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit =
//4-2 = 2.
//
//
// Example 2:
//
//
//Input: k = 2, prices = [3,2,6,5,0,3]
//Output: 7
//Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit =
//6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3
//-0 = 3.
//
//
//
// Constraints:
//
//
// 0 <= k <= 100
// 0 <= prices.length <= 1000
// 0 <= prices[i] <= 1000
//
// Related Topics Dynamic Programming
// 👍 2267 👎 134


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int k, int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int K = Math.min(k, prices.length/2);

        int[][][] profit = new int[prices.length][2][K+1];

        for (int i=0; i<=K; i++) {
            profit[0][0][i] = 0;
            profit[0][1][i] = -prices[0];
        }

        for (int i=1; i<prices.length; i++) {
            for (int j=0; j<=K; j++) {
                if (j >0) {
                    profit[i][0][j] = Math.max(profit[i - 1][1][j - 1] + prices[i], profit[i - 1][0][j]);
                } else {
                    profit[i][0][0] = profit[i-1][0][0];
                }
                profit[i][1][j] = Math.max(profit[i-1][1][j], profit[i-1][0][j]-prices[i]);
            }
        }

        int result = 0;

        for (int i=0; i<=K; i++) {
            result = Math.max(profit[prices.length-1][0][i], result);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
