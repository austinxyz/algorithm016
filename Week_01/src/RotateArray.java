//Given an array, rotate the array to the right by k steps, where k is non-negat
//ive.
//
// Follow up:
//
//
// Try to come up as many solutions as you can, there are at least 3 different w
//ays to solve this problem.
// Could you do it in-place with O(1) extra space?
//
//
//
// Example 1:
//
//
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
//
//
// Example 2:
//
//
//Input: nums = [-1,-100,3,99], k = 2
//Output: [3,99,-1,-100]
//Explanation:
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 2 * 10^4
// It's guaranteed that nums[i] fits in a 32 bit-signed integer.
// k >= 0
//
// Related Topics Array
// 👍 3188 👎 850


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    bruteforce
//    public void rotate(int[] nums, int k) {
//
//        for (int i = 0; i < k; i++) {
//            int rotatedValue= nums[nums.length-1];
//            for (int j = 0; j < nums.length; j++) {
//                int temp = nums[j];
//                nums[j] = rotatedValue;
//                rotatedValue = temp;
//            }
//        }
//    }

//    Better way
//    public void rotate(int[] nums, int k) {
//
//        k = k % nums.length;
//
//        reverse(nums, 0, nums.length -1);
//
//        reverse(nums, 0, k-1);
//
//        reverse(nums, k, nums.length-1);
//
//    }
//
//    void reverse(int[] nums, int start, int end) {
//
//        while(start < end) {
//            int temp = nums[start];
//            nums[start] = nums[end];
//            nums[end] = temp;
//            start++;
//            end--;
//        }
//    }

    public void rotate(int[] nums, int k) {

        int length = nums.length;

        k = k % length;

        if (length <= 1 || k == 0 ) {
            return;
        }

        int start = 0;
        int next = start;
        int rotatedValue = nums[start];
        int finishedCount = 0;

        while (finishedCount < length) {
            next = next + k;
            next = next>=length? next-length: next;
            int temp = nums[next];
            nums[next] = rotatedValue;
            rotatedValue = temp;
            finishedCount++;
            if (next == start) {
                start = start + 1;
                next = start;
                rotatedValue = nums[start];
            }
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
