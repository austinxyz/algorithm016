//Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rec
//tangle in the matrix such that its sum is no larger than k.
//
// Example:
//
//
//Input: matrix = [[1,0,1],[0,-2,3]], k = 2
//Output: 2
//Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
//             and 2 is the max number no larger than k (k = 2).
//
// Note:
//
//
// The rectangle inside the matrix must have an area > 0.
// What if the number of rows is much larger than the number of columns?
// Related Topics Binary Search Dynamic Programming Queue
// 👍 908 👎 68


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {

        int row = matrix.length;

        int col = matrix[0].length;

        int[][] sum = new int[row+1][col+1];

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                sum[i+1][j+1] = sum[i+1][j] + sum[i][j+1] - sum[i][j] + matrix[i][j];
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i=0; i<col; i++) {
            for (int j = i+1; j<=col; j++) {
                TreeSet<Integer> sums = new TreeSet<Integer>();
                sums.add(0);

                for (int l=1; l<= row; l++) {

                    int areaSum = sum[l][j] - sum[0][j] - sum[l][i] + sum[0][i];

                    Integer lower = sums.ceiling(areaSum - k);

                    if (lower !=null ) {
                        result = Math.max(result, areaSum - lower);
                    }
                    sums.add(areaSum);
                }

            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
