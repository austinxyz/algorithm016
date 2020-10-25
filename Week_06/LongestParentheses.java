//Given a string containing just the characters '(' and ')', find the length of
//the longest valid (well-formed) parentheses substring.
//
//
// Example 1:
//
//
//Input: s = "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()".
//
//
// Example 2:
//
//
//Input: s = ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()".
//
//
// Example 3:
//
//
//Input: s = ""
//Output: 0
//
//
//
// Constraints:
//
//
// 0 <= s.length <= 3 * 104
// s[i] is '(', or ')'.
//
// Related Topics String Dynamic Programming
// 👍 4029 👎 148


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;

        int dp[] = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                int leftIndex = i - dp[i - 1] - 1;

                if (leftIndex >= 0 && s.charAt(leftIndex) == '(')
                    dp[i] = dp[i - 1] + (leftIndex - 1 >= 0 ? dp[leftIndex - 1] : 0) + 2;

                res = Math.max(res, dp[i]);
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
