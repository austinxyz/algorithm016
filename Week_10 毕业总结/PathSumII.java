//Given the root of a binary tree and an integer targetSum, return all root-to-l
//eaf paths where each path's sum equals targetSum.
//
// A leaf is a node with no children.
//
//
// Example 1:
//
//
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//Output: [[5,4,11,2],[5,8,4,5]]
//
//
// Example 2:
//
//
//Input: root = [1,2,3], targetSum = 5
//Output: []
//
//
// Example 3:
//
//
//Input: root = [1,2], targetSum = 0
//Output: []
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 5000].
// -1000 <= Node.val <= 1000
// -1000 <= targetSum <= 1000
//
// Related Topics Tree Depth-first Search
// 👍 2550 👎 85


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<Integer> currList = new ArrayList<Integer>();

        pathSum(root, 0, targetSum, currList, result);

        return result;
    }

    private void pathSum(TreeNode node, int sum, int targetSum, List<Integer> currList, List<List<Integer>> result) {

        if (node == null) {
            return;
        }

        currList.add(node.val);

        if (node.left == null && node.right == null) {
            if (sum + node.val == targetSum) {
                result.add(new ArrayList(currList));
            }
        }

        if (node.left !=null) {
            pathSum(node.left, sum + node.val, targetSum, currList, result);
        }

        if (node.right !=null) {
            pathSum(node.right, sum + node.val, targetSum, currList, result);
        }

        currList.remove(currList.size()-1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
