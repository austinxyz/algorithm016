//You are given an integer array nums sorted in ascending order, and an integer
//target.
//
// Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [
//0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
// If target is found in the array return its index, otherwise, return -1.
//
//
// Example 1:
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// Example 2:
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Example 3:
// Input: nums = [1], target = 0
//Output: -1
//
//
// Constraints:
//
//
// 1 <= nums.length <= 5000
// -10^4 <= nums[i] <= 10^4
// All values of nums are unique.
// nums is guranteed to be rotated at some pivot.
// -10^4 <= target <= 10^4
//
// Related Topics Array Binary Search
// 👍 5904 👎 512


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {

        if (nums.length == 1) {
            return nums[0] == target? 0: -1;
        }


        int left = 0;
        int right = nums.length -1;

        int lowest = nums[left] > nums[right]? right: left;

        while (right - left >1) {

            int mid = left + (right-left)/2;

            if (nums[mid] > nums[left]) {
                left = mid;
            }

            if (nums[mid] < nums[right]) {
                right = mid;
            }
        }

        lowest = nums[lowest] > nums[right]? right: lowest;

        if (target == nums[nums.length-1]) {
            return nums.length-1;
        } else if (target < nums[nums.length-1]) {
            left = lowest;
            right = nums.length -1;
        } else {
            left = 0;
            right = lowest -1;
        }

        if (nums[left] > target) {
            return -1;
        }

        while (left <= right) {
            int mid = left + (right-left)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else {
                left =  mid+1;
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
