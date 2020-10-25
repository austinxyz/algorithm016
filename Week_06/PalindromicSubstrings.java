//Given a string, your task is to count how many palindromic substrings in this
//string.
//
// The substrings with different start indexes or end indexes are counted as dif
//ferent substrings even they consist of same characters.
//
// Example 1:
//
//
//Input: "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".
//
//
//
//
// Example 2:
//
//
//Input: "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
//
//
//
//
// Note:
//
//
// The input string length won't exceed 1000.
//
//
// Related Topics String Dynamic Programming
// 👍 3177 👎 126


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {

        char[] arr = s.toCharArray();

        boolean[][] dp = new boolean[arr.length][arr.length];

        int count = 0;

        for (int i =arr.length -1; i >= 0; i--) {

            for (int j = i; j < arr.length; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    if (j-i +1 <=2) {
                        dp[i][j] = (arr[i] == arr[j]);
                    } else {
                        dp[i][j] = (arr[i] == arr[j]) && dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j]) {
                    count++;
                }
            }

        }

        return count;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
