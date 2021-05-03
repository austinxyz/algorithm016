//Given a rows x cols binary matrix filled with 0's and 1's, find the largest re
//ctangle containing only 1's and return its area.
//
//
// Example 1:
//
//
//Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1",
//"1"],["1","0","0","1","0"]]
//Output: 6
//Explanation: The maximal rectangle is shown in the above picture.
//
//
// Example 2:
//
//
//Input: matrix = []
//Output: 0
//
//
// Example 3:
//
//
//Input: matrix = [["0"]]
//Output: 0
//
//
// Example 4:
//
//
//Input: matrix = [["1"]]
//Output: 1
//
//
// Example 5:
//
//
//Input: matrix = [["0","0"]]
//Output: 0
//
//
//
// Constraints:
//
//
// rows == matrix.length
// cols == matrix[i].length
// 0 <= row, cols <= 200
// matrix[i][j] is '0' or '1'.
//
// Related Topics Array Hash Table Dynamic Programming Stack
// 👍 4179 👎 88


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length + 1]; //小技巧后边讲
        int maxArea = 0;
        for (int row = 0; row < matrix.length; row++) {
            Stack<Integer> stack = new Stack<Integer>();
            heights[matrix[0].length] = 0;
            //每求一个高度就进行栈的操作
            for (int col = 0; col <= matrix[0].length; col++) {
                if (col < matrix[0].length) { //多申请了 1 个元素，所以要判断
                    if (matrix[row][col] == '1') {
                        heights[col] += 1;
                    } else {
                        heights[col] = 0;
                    }
                }
                if (stack.isEmpty() || heights[col] >= heights[stack.peek()]) {
                    stack.push(col);
                } else {
                    //每次要判断新的栈顶是否高于当前元素
                    while (!stack.isEmpty() && heights[col] < heights[stack.peek()]) {
                        int height = heights[stack.pop()];
                        int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
                        int RightLessMin = col;
                        int area = (RightLessMin - leftLessMin - 1) * height;
                        maxArea = Math.max(area, maxArea);
                    }
                    stack.push(col);
                }
            }

        }
        return maxArea;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
