//Given an encoded string, return its decoded string.
//
// The encoding rule is: k[encoded_string], where the encoded_string inside the
//square brackets is being repeated exactly k times. Note that k is guaranteed to
//be a positive integer.
//
// You may assume that the input string is always valid; No extra white spaces,
//square brackets are well-formed, etc.
//
// Furthermore, you may assume that the original data does not contain any digit
//s and that digits are only for those repeat numbers, k. For example, there won't
// be input like 3a or 2[4].
//
//
// Example 1:
// Input: s = "3[a]2[bc]"
//Output: "aaabcbc"
// Example 2:
// Input: s = "3[a2[c]]"
//Output: "accaccacc"
// Example 3:
// Input: s = "2[abc]3[cd]ef"
//Output: "abcabccdcdcdef"
// Example 4:
// Input: s = "abc3[cd]xyz"
//Output: "abccdcdcdxyz"
//
//
// Constraints:
//
//
// 1 <= s.length <= 30
// s consists of lowercase English letters, digits, and square brackets '[]'.
// s is guaranteed to be a valid input.
// All the integers in s are in the range [1, 300].
//
// Related Topics Stack Depth-first Search
// 👍 4568 👎 224


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeString(String s) {

        StringBuffer result = new StringBuffer();

        StringBuffer sub = new StringBuffer();

        int level = 0;

        int i = 0;

        int times = 0;

        while (i < s.length()) {

            char c = s.charAt(i);
            if (level == 0 && c >= '0' && c <='9') {
                times = times*10 + (c - '0');
            } else if (c == '[' ) {
                if (level == 0) {
                    result.append(sub.toString());
                    sub = new StringBuffer();
                } else {
                    sub.append(c);
                }
                level++;
            } else if (c == ']') {
                if (level == 1) {
                    String deSubStr = decodeString(sub.toString());
                    for (int j = 0; j < times; j++) {
                        result.append(deSubStr);
                    }
                    times = 0;
                    sub = new StringBuffer();
                } else {
                    sub.append(c);
                }
                level--;
            } else {
                sub.append(c);
            }

            i++;
        }

        if (sub.length() >0) {
            result.append(sub.toString());
        }
        return result.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
