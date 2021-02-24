//Given the root of a binary tree and an integer targetSum, return true if the t
//ree has a root-to-leaf path such that adding up all the values along the path eq
//uals targetSum.
//
// A leaf is a node with no children.
//
//
// Example 1:
//
//
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//Output: true
//
//
// Example 2:
//
//
//Input: root = [1,2,3], targetSum = 5
//Output: false
//
//
// Example 3:
//
//
//Input: root = [1,2], targetSum = 0
//Output: false
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
// 👍 2847 👎 583


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

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        int sum = 0;

        return pathSum(root, sum, targetSum);

    }

    private boolean pathSum(TreeNode node, int sum, int targetSum) {

        if (node.left == null && node.right == null) {
            if (sum + node.val == targetSum) {
                return true;
            }
        }

        if (node.left !=null) {
            if (pathSum(node.left, sum + node.val, targetSum)) {
                return true;
            }
        }

        if (node.right !=null) {
            if (pathSum(node.right, sum + node.val, targetSum)) {
                return true;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
