//
//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
//
//
//
//For example, given n = 3, a solution set is:
//
//
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// Related Topics String Backtracking
// 👍 5987 👎 294


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> results = new ArrayList<String>();

        generate(new StringBuffer(), 0, 0, results, n);

        return results;

    }

    void generate(StringBuffer prefix, int rightCount, int leftCount, List<String> results, int total) {

        if (rightCount + leftCount == 2* total) {
            results.add(prefix.toString());
            return;
        }

        if (leftCount > rightCount) {
            prefix.append(")");
            rightCount++;
            generate(prefix, rightCount, leftCount, results, total);
            prefix.deleteCharAt(prefix.length() -1);
            rightCount--;
        }

        if (leftCount < total) {
            prefix.append("(");
            leftCount++;
            generate(prefix, rightCount, leftCount, results, total);
            prefix.deleteCharAt(prefix.length() - 1);
            leftCount--;
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
