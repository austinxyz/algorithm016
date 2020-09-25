//Given a collection of distinct integers, return all possible permutations.
//
// Example:
//
//
//Input: [1,2,3]
//Output:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
//
// Related Topics Backtracking
// 👍 4476 👎 112


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        List<Integer> currentList = new ArrayList<Integer>();

        findNext(nums, currentList, results);

        return results;

    }

    void findNext(int[] nums, List<Integer> currentList, List<List<Integer>> results) {

        Set used = new HashSet(currentList);

        for (int i = 0; i<nums.length; i++) {
            if (!used.contains(nums[i])) {
                List<Integer> list = new ArrayList<Integer>(currentList);
                list.add(nums[i]);

                if (list.size() == nums.length) {
                    results.add(list);
                } else {
                    findNext(nums, list, results);
                }
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
