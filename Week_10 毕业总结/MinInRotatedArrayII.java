//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand.
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
// Find the minimum element.
//
// The array may contain duplicates.
//
// Example 1:
//
//
//Input: [1,3,5]
//Output: 1
//
// Example 2:
//
//
//Input: [2,2,2,0,1]
//Output: 0
//
// Note:
//
//
// This is a follow up problem to Find Minimum in Rotated Sorted Array.
// Would allow duplicates affect the run-time complexity? How and why?
//
// Related Topics Array Binary Search
// 👍 1427 👎 267


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length-1;

        int mid;

        while (start <=end) {

            if (end-start <= 1) {
                return nums[start] < nums[end]? nums[start]:nums[end];
            }

            mid = (start + end) / 2;

            if (nums[start] == nums[mid]) {
                start++;
                continue;
            }

            if (nums[start] < nums[end]) {
                end = mid -1;
            } else if (nums[mid] <= nums[end]) {
                end = mid;
            } else {
                start = mid;
            }

        }

        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
