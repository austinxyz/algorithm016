//Write an efficient algorithm that searches for a value in an m x n matrix. Thi
//s matrix has the following properties:
//
//
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previou
//s row.
//
//
//
// Example 1:
//
//
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true
//
//
// Example 2:
//
//
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//Output: false
//
//
//
// Constraints:
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -104 <= matrix[i][j], target <= 104
//
// Related Topics Array Binary Search
// 👍 2916 👎 194


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null) {
            return false;
        }

        int start = 0;
        int end = matrix.length * matrix[0].length -1;

        while (start <=end) {
            int mid = (start + end)/2;

            int midValue = getValue(matrix, matrix[0].length, mid);

            if (midValue == target) {
                return true;
            } else if (target > midValue) {
                start = mid +1;
            } else {
                end = mid - 1;
            }
        }

        return false;

    }

    private int getValue(int[][] matrix, int colsize, int index) {

        int col = index / colsize;
        int row = index % colsize;

        return matrix[col][row];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
