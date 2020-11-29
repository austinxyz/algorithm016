//Given an input string s, reverse the order of the words.
//
// A word is defined as a sequence of non-space characters. The words in s will
//be separated by at least one space.
//
// Return a string of the words in reverse order concatenated by a single space.
//
//
// Note that s may contain leading or trailing spaces or multiple spaces between
// two words. The returned string should only have a single space separating the w
//ords. Do not include any extra spaces.
//
//
// Example 1:
//
//
//Input: s = "the sky is blue"
//Output: "blue is sky the"
//
//
// Example 2:
//
//
//Input: s = "  hello world  "
//Output: "world hello"
//Explanation: Your reversed string should not contain leading or trailing space
//s.
//
//
// Example 3:
//
//
//Input: s = "a good   example"
//Output: "example good a"
//Explanation: You need to reduce multiple spaces between two words to a single
//space in the reversed string.
//
//
// Example 4:
//
//
//Input: s = "  Bob    Loves  Alice   "
//Output: "Alice Loves Bob"
//
//
// Example 5:
//
//
//Input: s = "Alice does not even like bob"
//Output: "bob like even not does Alice"
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 104
// s contains English letters (upper-case and lower-case), digits, and spaces '
//'.
// There is at least one word in s.
//
//
//
//
// Follow up:
//
//
// Could you solve it in-place with O(1) extra space?
//
//
//
// Related Topics String
// 👍 1352 👎 3080


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {

        int index = 0;

        List<String> words = new ArrayList<String>();

        StringBuffer sb = new StringBuffer();

        for (char c: s.toCharArray()) {
            if (c == ' ') {
                if (sb.length() > 0) {
                    words.add(sb.toString());
                    sb = new StringBuffer();
                }
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            words.add(sb.toString());
        }

        StringBuffer result = new StringBuffer();
        for (int i = words.size()-1; i >=0; i--) {
            result.append(words.get(i));

            if (i >0) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
