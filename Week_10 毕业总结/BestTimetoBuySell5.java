//Say you have an array for which the ith element is the price of a given stock
//on day i.
//
// Design an algorithm to find the maximum profit. You may complete as many tran
//sactions as you like (ie, buy one and sell one share of the stock multiple times
//) with the following restrictions:
//
//
// You may not engage in multiple transactions at the same time (ie, you must se
//ll the stock before you buy again).
// After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1
//day)
//
//
// Example:
//
//
//Input: [1,2,3,0,2]
//Output: 3
//Explanation: transactions = [buy, sell, cooldown, buy, sell]
// Related Topics Dynamic Programming
// 👍 3458 👎 109


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int[][][] profit = new int[prices.length][2][2];

        profit[0][0][0] = 0;
        profit[0][0][1] = 0;
        profit[0][1][0] = -prices[0];

        for (int i=1; i<prices.length; i++) {
            profit[i][0][0] = Math.max(profit[i-1][0][0], profit[i-1][0][1]);
            profit[i][0][1] = profit[i-1][1][0] + prices[i];
            profit[i][1][0] = Math.max(profit[i-1][1][0],  profit[i-1][0][0]-prices[i]);
        }

        return Math.max(profit[prices.length-1][0][0], profit[prices.length-1][0][1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
