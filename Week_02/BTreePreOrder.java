//Given a binary tree, return the preorder traversal of its nodes' values.
//
// Example:
//
//
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,2,3]
//
//
// Follow up: Recursive solution is trivial, could you do it iteratively?
// Related Topics Stack Tree
// 👍 1722 👎 63


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
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<Integer>();

        preorderTraversal(root, result);

        return result;

    }

    void preorderTraversal(TreeNode node, List<Integer> result) {

        if (node == null) {
            return;
        }

        result.add(node.val);

        preorderTraversal(node.left, result);
        preorderTraversal(node.right, result);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
