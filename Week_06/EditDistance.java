//Given two words word1 and word2, find the minimum number of operations require
//d to convert word1 to word2.
//
// You have the following 3 operations permitted on a word:
//
//
// Insert a character
// Delete a character
// Replace a character
//
//
// Example 1:
//
//
//Input: word1 = "horse", word2 = "ros"
//Output: 3
//Explanation:
//horse -> rorse (replace 'h' with 'r')
//rorse -> rose (remove 'r')
//rose -> ros (remove 'e')
//
//
// Example 2:
//
//
//Input: word1 = "intention", word2 = "execution"
//Output: 5
//Explanation:
//intention -> inention (remove 't')
//inention -> enention (replace 'i' with 'e')
//enention -> exention (replace 'n' with 'x')
//exention -> exection (replace 'n' with 'c')
//exection -> execution (insert 'u')
//
// Related Topics String Dynamic Programming
// 👍 4632 👎 61


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {

        if (word1.length() == 0 ) {
            return word2.length();
        }

        if (word2.length() == 0) {
            return word1.length();
        }

        int[][] dp = new int[word1.length()][word2.length()];

        for (int i =0; i < word1.length(); i++) {

            for (int j=0; j< word2.length(); j++) {

                if (i==0 && j==0) {
                    dp[i][j] = word1.charAt(0) == word2.charAt(0)? 0: 1;
                } else if (i==0 ) {
                    dp[i][j] = word1.charAt(0) == word2.charAt(j)? j: dp[i][j-1] + 1;
                } else if (j==0 ) {
                    dp[i][j] = word1.charAt(i) == word2.charAt(0)? i: dp[i-1][j] + 1;
                } else {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    }
                }

            }
        }

        return dp[word1.length()-1][word2.length()-1];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
