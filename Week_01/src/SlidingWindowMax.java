//Given an array nums, there is a sliding window of size k which is moving from
//the very left of the array to the very right. You can only see the k numbers in
//the window. Each time the sliding window moves right by one position. Return the
// max sliding window.
//
// Follow up:
//Could you solve it in linear time?
//
// Example:
//
//
//Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
//Output: [3,3,5,5,6,7]
//Explanation:
//
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10^5
// -10^4 <= nums[i] <= 10^4
// 1 <= k <= nums.length
//
// Related Topics Heap Sliding Window
// 👍 3956 👎 179


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> queue = new LinkedList<Integer>();

        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {

            if (queue.isEmpty()) {
                queue.addLast(i);
            } else {

                if (i - queue.peekFirst() >=k) {
                    queue.removeFirst();
                }

                while ( !queue.isEmpty() && nums[queue.peekLast()] < nums[i] ) {
                    queue.removeLast();
                }
                queue.addLast(i);
            }

            if (i >= k -1) {
                result[i - k + 1] = nums[queue.peekFirst()];
            }

        }

        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
