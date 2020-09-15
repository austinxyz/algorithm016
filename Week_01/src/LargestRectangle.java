//Given n non-negative integers representing the histogram's bar height where th
//e width of each bar is 1, find the area of largest rectangle in the histogram.
//
//
//
//
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3
//].
//
//
//
//
//The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
//
//
// Example:
//
//
//Input: [2,1,5,6,2,3]
//Output: 10
//
// Related Topics Array Stack
// 👍 4219 👎 93


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
