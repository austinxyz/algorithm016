//In a country popular for train travel, you have planned some train travelling
//one year in advance. The days of the year that you will travel is given as an ar
//ray days. Each day is an integer from 1 to 365.
//
// Train tickets are sold in 3 different ways:
//
//
// a 1-day pass is sold for costs[0] dollars;
// a 7-day pass is sold for costs[1] dollars;
// a 30-day pass is sold for costs[2] dollars.
//
//
// The passes allow that many days of consecutive travel. For example, if we get
// a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and
// 8.
//
// Return the minimum number of dollars you need to travel every day in the give
//n list of days.
//
//
//
// Example 1:
//
//
//Input: days = [1,4,6,7,8,20], costs = [2,7,15]
//Output: 11
//Explanation:
//For example, here is one way to buy passes that lets you travel your travel pl
//an:
//On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
//On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4,
//..., 9.
//On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
//In total you spent $11 and covered all the days of your travel.
//
//
//
// Example 2:
//
//
//Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
//Output: 17
//Explanation:
//For example, here is one way to buy passes that lets you travel your travel pl
//an:
//On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2,
// ..., 30.
//On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
//In total you spent $17 and covered all the days of your travel.
//
//
//
//
//
// Note:
//
//
// 1 <= days.length <= 365
// 1 <= days[i] <= 365
// days is in strictly increasing order.
// costs.length == 3
// 1 <= costs[i] <= 1000
//
// Related Topics Dynamic Programming
// 👍 2786 👎 49


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mincostTickets(int[] days, int[] costs) {

        //判断
        if(days == null || days.length == 0 ||
                costs == null || costs.length == 0) {
            return 0;
        }

        //dp表示到了当天花的最低票价
        int[] dp = new int[days[days.length - 1] + 1];

        //base case: 第0天一定不用买票 则花费0元
        dp[0] = 0;
        //标记一下需要买票的日子
        for(int day: days) {
            dp[day] = Integer.MAX_VALUE;
        }

        for(int i = 1; i < dp.length; i++) {
            //不需要买票
            if(dp[i] == 0) {
                //不需要买票花费的钱就是前一天的花费
                dp[i] = dp[i - 1];
                continue;
            }

            int n1 = dp[i - 1] + costs[0];//当天需要买票
            /**如果今天距离第一天已经超过7天了
             * 则花费: dp[i-7](7天前已经花费的钱)+cost[1](7天前买了一张7天的票)
             * 否则就是直接第一天买了一张7天票
             */
            int n2 = i > 7 ? dp[i - 7] + costs[1] : costs[1];
            //30天与7天 同理
            int n3 = i > 30 ? dp[i - 30] + costs[2] :costs[2];

            dp[i] = Math.min(n1, Math.min(n2, n3));
        }
        //最后一天花费多少钱
        return dp[days[days.length - 1]];


    }
}
//leetcode submit region end(Prohibit modification and deletion)
