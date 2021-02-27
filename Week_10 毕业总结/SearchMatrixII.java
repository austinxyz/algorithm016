//Write an efficient algorithm that searches for a target value in an m x n inte
//ger matrix. The matrix has the following properties:
//
//
// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.
//
//
//
// Example 1:
//
//
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 5
//Output: true
//
//
// Example 2:
//
//
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 20
//Output: false
//
//
//
// Constraints:
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= n, m <= 300
// -109 <= matix[i][j] <= 109
// All the integers in each row are sorted in ascending order.
// All the integers in each column are sorted in ascending order.
// -109 <= target <= 109
//
// Related Topics Binary Search Divide and Conquer
// 👍 4433 👎 86


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        for (int i=0; i<matrix.length; i++) {
            if (search(matrix[i], target)) {
                return true;
            }
        }

        return false;

    }

    private boolean search(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right)/2;

            if (arr[mid] == target) {
                return true;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }

        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
