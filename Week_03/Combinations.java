//Given two integers n and k, return all possible combinations of k numbers out
//of 1 ... n.
//
// You may return the answer in any order.
//
//
// Example 1:
//
//
//Input: n = 4, k = 2
//Output:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
//
//
// Example 2:
//
//
//Input: n = 1, k = 1
//Output: [[1]]
//
//
//
// Constraints:
//
//
// 1 <= n <= 20
// 1 <= k <= n
//
// Related Topics Backtracking
// 👍 1704 👎 70


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        combine(new ArrayList<Integer>(0), results, n, k);

        return results;

    }

    void combine(List<Integer> preList, List<List<Integer>> results, int n, int k) {


        int start = preList.size() ==0 ? 1: preList.get(preList.size()-1) + 1;

        for (int i = start; i <= n; i++) {
            List<Integer> list = new ArrayList<>(preList);
            list.add(i);

            if (list.size() < k) {
                combine(list, results, n, k);
            } else {
                results.add(list);
            }
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
