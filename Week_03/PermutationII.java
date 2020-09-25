//Given a collection of numbers that might contain duplicates, return all possib
//le unique permutations.
//
// Example:
//
//
//Input: [1,1,2]
//Output:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
//
// Related Topics Backtracking
// 👍 2182 👎 65


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        List<Integer> currentList = new ArrayList<Integer>();

        Set<Integer> currentIndex = new HashSet<Integer>();

        Arrays.sort(nums);

        findNext(nums, currentIndex, currentList, results);

        return results;
    }

    void findNext(int[] nums, Set<Integer> currentIndex, List<Integer> currentList, List<List<Integer>> results) {


        int previous = Integer.MIN_VALUE;

        for (int i = 0; i<nums.length; i++) {


            if (!currentIndex.contains(i)) {

                if (nums[i] == previous) {
                    continue;
                }

                currentList.add(nums[i]);

                previous = nums[i];

                currentIndex.add(i);

                if (currentList.size() == nums.length) {
                    results.add(new ArrayList<Integer>(currentList));
                } else {
                    findNext(nums, currentIndex, currentList, results);
                }
                currentList.remove(currentList.size()-1);
                currentIndex.remove(i);
            }

        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
