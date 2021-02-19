//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid.
//
// An input string is valid if:
//
//
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
//
//
//
// Example 1:
//
//
//Input: s = "()"
//Output: true
//
//
// Example 2:
//
//
//Input: s = "()[]{}"
//Output: true
//
//
// Example 3:
//
//
//Input: s = "(]"
//Output: false
//
//
// Example 4:
//
//
//Input: s = "([)]"
//Output: false
//
//
// Example 5:
//
//
//Input: s = "{[]}"
//Output: true
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.
//
// Related Topics String Stack
// 👍 6786 👎 276


import com.sun.tools.javac.jvm.Code;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {

        Stack<Character> parenth = new Stack<Character>();

        for (char c: s.toCharArray()) {
            if (c == '{') {
                parenth.push ('}');
            }
            if (c == '[') {
                parenth.push (']');
            }
            if (c == '(') {
                parenth.push (')');
            }

            if (c == '}' || c == ')' || c == ']') {

                if (parenth.isEmpty()) {
                    return false;
                }
                char x = parenth.pop();
                if (x != c) {
                    return false;
                }
            }
        }
        return parenth.isEmpty();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
