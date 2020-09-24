//Given preorder and inorder traversal of a tree, construct the binary tree.
//
// Note:
//You may assume that duplicates do not exist in the tree.
//
// For example, given
//
//
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7]
//
// Return the following binary tree:
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics Array Tree Depth-first Search
// 👍 3900 👎 103


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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int rootVal = preorder[0];

        TreeNode root = new TreeNode(preorder[0]);

        int rootIndexInorder = getIndex(inorder, rootVal);

        int[] leftInorder = null;
        if (rootIndexInorder > 0) {
            leftInorder = new int[rootIndexInorder];
            System.arraycopy(inorder, 0, leftInorder, 0, rootIndexInorder );
        }

        int[] rightInorder = null;
        if (rootIndexInorder < inorder.length -1) {
            rightInorder = new int[inorder.length - rootIndexInorder -1];
            System.arraycopy(inorder, rootIndexInorder + 1, rightInorder, 0, inorder.length - rootIndexInorder -1 );
        }

        int[] leftPreorder = null;
        if (leftInorder!=null) {
            leftPreorder = new int[leftInorder.length];
            System.arraycopy(preorder, 1, leftPreorder, 0, leftInorder.length );
        }

        int[] rightPreorder = null;
        if (rightInorder!=null) {
            rightPreorder = new int[rightInorder.length];
            System.arraycopy(preorder, 1+ (leftInorder==null? 0:leftInorder.length), rightPreorder, 0, rightInorder.length );
        }

        TreeNode left = buildTree(leftPreorder, leftInorder);

        TreeNode right = buildTree(rightPreorder, rightInorder);

        root.left = left;
        root.right = right;

        return root;

    }

    int getIndex(int[] order, int val) {
        for (int i=0; i<order.length; i++) {
            if (order[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
