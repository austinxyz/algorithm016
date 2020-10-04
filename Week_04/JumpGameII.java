//Given an array of non-negative integers, you are initially positioned at the f
//irst index of the array.
//
// Each element in the array represents your maximum jump length at that positio
//n.
//
// Your goal is to reach the last index in the minimum number of jumps.
//
// Example:
//
//
//Input: [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2.
//    Jump 1 step from index 0 to 1, then 3 steps to the last index.
//
// Note:
//
// You can assume that you can always reach the last index.
// Related Topics Array Greedy
// 👍 3017 👎 150


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {

        if (nums.length <= 1) {
            return 0;
        }

        int i = 0;

        int maxDist = 0;

        int nextDist = nums[0];

        int jump = 0;

        while (maxDist < nums.length-1) {

            while (i <= maxDist && nextDist < nums.length -1) {
                nextDist = Math.max(nextDist, i + nums[i]);
                i++;
            }

            jump++;

            maxDist = nextDist;

        }

        return jump;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
