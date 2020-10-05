//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand.
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
// Find the minimum element.
//
// You may assume no duplicate exists in the array.
//
// Example 1:
//
//
//Input: [3,4,5,1,2]
//Output: 1
//
//
// Example 2:
//
//
//Input: [4,5,6,7,0,1,2]
//Output: 0
//
// Related Topics Array Binary Search
// 👍 2605 👎 260


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
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

        return nums[lowest];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
