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
// 👍 6318 👎 292


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {

        List<List<String>> results = new ArrayList<List<String>>(n+1);

        List<String> result = new ArrayList<String>();
        result.add("");
        results.add(result);

        result = new ArrayList<String>();
        result.add("()");

        results.add(result);

        if (n == 1) {
            return result;
        }

        for (int i=2; i<=n; i++) {

            result = new ArrayList<String>();

            for (int j=0; j<=i-1; j++ ) {
                for (String p: results.get(j)) {
                    for (String q: results.get(i-1-j)) {
                        StringBuffer sb = new StringBuffer(p);
                        sb.append("(").append(q).append(")");
                        result.add(sb.toString());
                    }
                }

            }

            results.add(result);

        }

        return results.get(n);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
