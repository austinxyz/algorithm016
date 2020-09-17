//Given an n-ary tree, return the level order traversal of its nodes' values.
//
// Nary-Tree input serialization is represented in their level order traversal,
//each group of children is separated by the null value (See examples).
//
//
// Example 1:
//
//
//
//
//Input: root = [1,null,3,2,4,null,5,6]
//Output: [[1],[3,2,4],[5,6]]
//
//
// Example 2:
//
//
//
//
//Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null
//,12,null,13,null,null,14]
//Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
//
//
//
// Constraints:
//
//
// The height of the n-ary tree is less than or equal to 1000
// The total number of nodes is between [0, 10^4]
//
// Related Topics Tree Breadth-first Search
// 👍 675 👎 47


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {

        Map<Integer, List<Integer>> levelValues = new HashMap<Integer, List<Integer>>();

        int level = 0;

        levelOrder(root, level, levelValues);

        int length = levelValues.keySet().size();

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i=0; i< length; i++ ) {

            result.add(levelValues.get(i));
        }

        return result;

    }

    void levelOrder(Node node, int level, Map<Integer, List<Integer>> levelValues) {

        if(node == null ) {
            return;
        }

        List<Integer> values = levelValues.get(level);

        if (values == null) {
            values = new ArrayList<Integer>();
            levelValues.put(level, values);
        }

        values.add(node.val);

        if (node.children == null || node.children.isEmpty()) {
            return;
        }

        for (Node child: node.children) {
            levelOrder(child, level+1, levelValues );
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
