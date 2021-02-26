//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
//
//
// Example 1:
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:
// Input: n = 1
//Output: ["()"]
//
//
// Constraints:
//
//
// 1 <= n <= 8
//
// Related Topics String Backtracking
// 👍 7195 👎 312


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();

        generate(result, 0, new StringBuffer(), 0, 0,  n);

        return result;

    }

    private void generate(List<String> result, int i, StringBuffer prefix, int leftCount, int rightCount, int n) {

        if (i == 2 * n) {
            result.add(prefix.toString());
            return;
        }

        if (leftCount < n) {
            generate(result, i + 1, prefix.append("("), leftCount + 1, rightCount, n);
            prefix.deleteCharAt(prefix.length() - 1);
        }

        if (leftCount > rightCount){
            generate(result, i + 1, prefix.append(")"), leftCount, rightCount+1, n);
            prefix.deleteCharAt(prefix.length()-1);
        }

        return;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
