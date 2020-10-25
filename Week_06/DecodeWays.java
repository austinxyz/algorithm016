//A message containing letters from A-Z is being encoded to numbers using the fo
//llowing mapping:
//
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//
//
// Given a non-empty string containing only digits, determine the total number o
//f ways to decode it.
//
// The answer is guaranteed to fit in a 32-bit integer.
//
//
// Example 1:
//
//
//Input: s = "12"
//Output: 2
//Explanation: It could be decoded as "AB" (1 2) or "L" (12).
//
//
// Example 2:
//
//
//Input: s = "226"
//Output: 3
//Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6)
//.
//
//
// Example 3:
//
//
//Input: s = "0"
//Output: 0
//Explanation: There is no character that is mapped to a number starting with '0
//'. We cannot ignore a zero when we face it while decoding. So, each '0' should b
//e part of "10" --> 'J' or "20" --> 'T'.
//
//
// Example 4:
//
//
//Input: s = "1"
//Output: 1
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 100
// s contains only digits and may contain leading zero(s).
//
// Related Topics String Dynamic Programming
// 👍 3286 👎 3184


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {

        if (s.length() == 0 || s.equals("0")) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int[] dp = new int[s.length()];

        dp[0] = (s.charAt(0) == '0' ? 0: 1);

        char pres = s.charAt(0);

        char[] arr = s.toCharArray();

        for (int i = 1; i < arr.length; i++) {

            char x = arr[i];

            if (i == 1) {
                dp[i] = (x == '0'? 0:dp[0]) + (isChar(pres, x)? 1:0);
            } else {
                dp[i] = (x == '0'? 0:dp[i-1]) + (isChar(pres, x)? dp[i-2]: 0);
            }

            pres = x;
        }

        return dp[s.length()-1];

    }

    boolean isChar(char pres, char x) {
        if (pres == '1' ) {
            return true;
        }

        if (pres == '2') {
            return ((int)x - (int)'0') <= 6;
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
