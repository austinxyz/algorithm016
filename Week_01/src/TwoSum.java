//Given an array of integers nums and an integer target, return indices of the t
//wo numbers such that they add up to target.
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice.
//
// You can return the answer in any order.
//
//
// Example 1:
//
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].
//
//
// Example 2:
//
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//
//
// Example 3:
//
//
//Input: nums = [3,3], target = 6
//Output: [0,1]
//
//
//
// Constraints:
//
//
// 2 <= nums.length <= 105
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// Only one valid answer exists.
//
// Related Topics Array Hash Table
// 👍 16738 👎 605


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

//    Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
//
//    public int[] twoSum(int[] nums, int target) {
//
//        for (int i=0; i < nums.length; i++) {
//            numMap.put(nums[i], i);
//        }
//
//        for (int i=0; i< nums.length; i++) {
//            if (numMap.containsKey(target - nums[i])) {
//                int[] result = new int[2];
//                result[0] = i;
//                result[1] = numMap.get(target - nums[i]);
//                if (result[0] != result[1]) {
//                    return result;
//                }
//            }
//        }
//
//        return null;
//    }

    public int[] twoSum(int[] nums, int target) {

        int[] orginalNums = Arrays.copyOf(nums, nums.length);

        Arrays.sort(nums);

        int start = 0;
        int end = nums.length -1;


        while (start < end) {
            int value = nums[start] + nums[end];
            if ( value > target) {
                end--;
            } else if (value < target) {
                start ++;
            } else {
                int[] result = new int[2];
                result[0] = findIndex(orginalNums, nums[start], -1);
                result[1] = findIndex(orginalNums, nums[end], result[0]);
                return result;
            }
        }
        return null;
    }

    int findIndex(int[] nums, int value, int ignoreIndex) {
        for (int i =0; i < nums.length; i++) {

            if (nums[i] == value && i != ignoreIndex) {
                return i;
            }

        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
