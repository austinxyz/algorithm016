//There is an integer array nums sorted in ascending order (with distinct values
//).
//
// Prior to being passed to your function, nums is rotated at an unknown pivot i
//ndex k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+
//1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example,
//[0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
//
// Given the array nums after the rotation and an integer target, return the ind
//ex of target if it is in nums, or -1 if it is not in nums.
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
// -104 <= nums[i] <= 104
// All values of nums are unique.
// nums is guaranteed to be rotated at some pivot.
// -104 <= target <= 104
//
//
//
//Follow up: Can you achieve this in O(log n) time complexity? Related Topics Ar
//ray Binary Search
// 👍 6996 👎 615


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*
    public int search(int[] nums, int target) {

        return search(nums, 0, nums.length-1, target);

    }

    private int search(int[] nums, int start, int end, int target) {

        if (end - start <= 1) {
            if (target == nums[start]) {
                return start;
            }

            if (target == nums[end]) {
                return end;
            }

            return -1;
        }

        int mid = (start + end) / 2;

        if (nums[start] <= target && target <= nums[mid] ) {
            return search(nums, start, mid, target);
        }

        if (nums[mid] <= target && target <= nums[end] ) {
            return search(nums, mid, end, target);
        }

        if (nums[start] >= nums[mid] && (nums[mid] >= target || nums[start] <= target)) {
            return search(nums, start, mid, target);
        }

        if (nums[mid] >= nums[end] && (nums[end] >= target || nums[mid] <=target)) {
            return search(nums, mid, end, target);
        }

        return -1;
    }
*/
public int search(int[] nums, int target) {

    if (nums == null || nums.length ==0) {
        return -1;
    }

    int start = 0;
    int end = nums.length -1;
    int mid = 0;


    while (start <= end) {

        mid = (start + end) /2;

        if (nums[mid] == target) {
            return mid;
        }

        if (nums[start] == nums[mid]) {
            start++;
            continue;
        }

        if (nums[start] < nums[mid]) {

            if (nums[start] <= target && nums[mid] > target ) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        } else {
            if (nums[mid] < target && nums[end] >= target) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }

    }

    return -1;
}
}
//leetcode submit region end(Prohibit modification and deletion)
