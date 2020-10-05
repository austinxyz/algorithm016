//Write an efficient algorithm that searches for a value in an m x n matrix. Thi
//s matrix has the following properties:
//
//
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previou
//s row.
//
//
// Example 1:
//
//
//Input:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//Output: true
//
//
// Example 2:
//
//
//Input:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//Output: false
// Related Topics Array Binary Search
// 👍 2193 👎 166


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length==0) {
            return false;
        }

        int left = 0;
        int right = matrix.length-1;

        while (left <= right) {

            int mid = left + (right-left)/2;

            if (matrix[mid][0] <= target && matrix[mid][matrix[0].length-1] >= target) {
                return findTarget(matrix[mid], target);

            } else if (matrix[mid][0] > target) {
                right = mid -1;
            } else if (matrix[mid][matrix[0].length-1] < target) {
                left = mid + 1;
            }
        }

        return false;
    }

    boolean findTarget(int[] nums, int target) {

        int left = 0;

        int right = nums.length-1;

        while (left<=right) {
            int mid = left + (right-left)/2;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right = mid -1;
            } else {
                left = mid+1;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
