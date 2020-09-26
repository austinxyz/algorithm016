//Given an array of size n, find the majority element. The majority element is t
//he element that appears more than ⌊ n/2 ⌋ times.
//
// You may assume that the array is non-empty and the majority element always ex
//ist in the array.
//
// Example 1:
//
//
//Input: [3,2,3]
//Output: 3
//
// Example 2:
//
//
//Input: [2,2,1,1,1,2,2]
//Output: 2
//
// Related Topics Array Divide and Conquer Bit Manipulation
// 👍 3735 👎 231


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int majorityElement(int[] nums) {

        Map<Integer, Integer> numMaps = new HashMap<Integer, Integer>();

        for (int i=0; i<nums.length; i++) {
            int count = 1;

            if (numMaps.containsKey(nums[i])) {
                count = numMaps.get(nums[i])+1;
            }

            numMaps.put(nums[i], count);

            if (count > nums.length/2) {
                return nums[i];
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
