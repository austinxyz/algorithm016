//Given an array nums of n integers, are there elements a, b, c in nums such tha
//t a + b + c = 0? Find all unique triplets in the array which gives the sum of ze
//ro.
//
// Notice that the solution set must not contain duplicate triplets.
//
//
// Example 1:
// Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
// Example 2:
// Input: nums = []
//Output: []
// Example 3:
// Input: nums = [0]
//Output: []
//
//
// Constraints:
//
//
// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
//
// Related Topics Array Two Pointers
// 👍 7890 👎 871


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        int index = 0;

        while (index < nums.length -2 ) {

            int target = -nums[index];
            int start = index+1;
            int end = nums.length-1;

            while (start < end) {
                if (nums[start]+nums[end] < target) {
                    start++;
                } else if (nums[start]+nums[end] > target) {
                    end--;
                } else {
                    ArrayList<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(-target);
                    triplet.add(nums[start]);
                    triplet.add(nums[end]);
                    result.add(triplet);
                    start++;
                    end--;
                    while (start < end && nums[start-1] == nums[start]) {
                        start++;
                    }
                    while (start < end  && nums[end] == nums[end+1]) {
                        end--;
                    }
                }
            }

            index++;
            while (index < nums.length -2 && nums[index-1] == nums[index]) {
                index++;
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
