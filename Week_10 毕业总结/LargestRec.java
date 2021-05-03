//Given an array of integers heights representing the histogram's bar height whe
//re the width of each bar is 1, return the area of the largest rectangle in the h
//istogram.
//
//
// Example 1:
//
//
//Input: heights = [2,1,5,6,2,3]
//Output: 10
//Explanation: The above is a histogram where width of each bar is 1.
//The largest rectangle is shown in the red area, which has an area = 10 units.
//
//
// Example 2:
//
//
//Input: heights = [2,4]
//Output: 4
//
//
//
// Constraints:
//
//
// 1 <= heights.length <= 105
// 0 <= heights[i] <= 104
//
// Related Topics Array Stack
// 👍 5715 👎 112


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> leftHeights = new Stack<Integer>();

        int maxArea = 0;

        int index = 0;

        while (index <= heights.length) {

            int h = index == heights.length? 0: heights[index];

            if (leftHeights.isEmpty()) {
                leftHeights.push(index);
            } else {

                while (!leftHeights.isEmpty() && heights[leftHeights.peek()] > h) {

                    int hIndex = leftHeights.pop();

                    int leftIndex = leftHeights.isEmpty()? 0 : leftHeights.peek() + 1;

                    int area = (index - leftIndex) * heights[hIndex];

                    maxArea = Math.max(maxArea, area);
                }

                leftHeights.push(index);
            }

            index++;
        }

        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
