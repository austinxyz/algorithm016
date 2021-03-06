//Given an integer array nums, find the contiguous subarray (containing at least
// one number) which has the largest sum and return its sum.
//
//
// Example 1:
//
//
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
//
//
// Example 2:
//
//
//Input: nums = [1]
//Output: 1
//
//
// Example 3:
//
//
//Input: nums = [0]
//Output: 0
//
//
// Example 4:
//
//
//Input: nums = [-1]
//Output: -1
//
//
// Example 5:
//
//
//Input: nums = [-100000]
//Output: -100000
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 3 * 104
// -105 <= nums[i] <= 105
//
//
//
//Follow up: If you have figured out the O(n) solution, try coding another solut
//ion using the divide and conquer approach, which is more subtle. Related Topics
//Array Divide and Conquer Dynamic Programming
// 👍 11014 👎 525


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int sum = 0;

        int max = Integer.MIN_VALUE;

        for (int i=0; i< nums.length; i++) {

            sum = sum + nums[i];

            sum = Math.max(sum, nums[i]);

            max = Math.max(max, sum);
        }

        return max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
