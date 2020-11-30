//
//Given a non-empty string s, you may delete at most one character. Judge whethe
//r you can make it a palindrome.
//
//
// Example 1:
//
//Input: "aba"
//Output: True
//
//
//
// Example 2:
//
//Input: "abca"
//Output: True
//Explanation: You could delete the character 'c'.
//
//
//
// Note:
//
// The string will only contain lowercase characters a-z.
//The maximum length of the string is 50000.
//
// Related Topics String
// 👍 2120 👎 132


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {

        int length = s.length() / 2;

        for (int i=0; i< length; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return isPalidrome(s.substring(i, s.length() - i -1 )) || isPalidrome(s.substring(i+1, s.length()-i));
            }
        }

        return true;

    }

    boolean isPalidrome(String s) {

        if (s.length() <= 1) {
            return true;
        }

        int length = s.length() / 2;

        for (int i=0; i< length; i++) {

            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
