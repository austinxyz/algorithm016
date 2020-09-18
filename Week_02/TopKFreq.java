//Given a non-empty array of integers, return the k most frequent elements.
//
// Example 1:
//
//
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
//
//
//
// Example 2:
//
//
//Input: nums = [1], k = 1
//Output: [1]
//
//
// Note:
//
//
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// Your algorithm's time complexity must be better than O(n log n), where n is t
//he array's size.
// It's guaranteed that the answer is unique, in other words the set of the top
//k frequent elements is unique.
// You can return the answer in any order.
//
// Related Topics Hash Table Heap
// 👍 3672 👎 224


import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();

        for (int i=0; i<nums.length; i++) {

            int f = 1;

            if (freq.containsKey(nums[i])) {
                f = freq.get(nums[i]);
                f++;
            }
            freq.put(nums[i], f);

        }

        List<Integer>[] buckets = new List[nums.length+1];

        for (int i: freq.keySet()) {

            List<Integer> res = new ArrayList<Integer>();

            int f = freq.get(i);
            if (buckets[f] != null) {
                res = buckets[f];
            } else {
                buckets[f] = res;
            }
            res.add(i);
        }

        int index = nums.length;

        List<Integer> result = new ArrayList<Integer>();

        while (result.size() < k && index >=0) {
            if (buckets[index]!=null) {
                result.addAll(buckets[index]);
            }
            index--;
        }

        int[] res = new int[k];
        for (int i=0; i<k; i++) {
            res[i] = result.get(i);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
