//Given two strings word1 and word2, return the minimum number of operations req
//uired to convert word1 to word2.
//
// You have the following three operations permitted on a word:
//
//
// Insert a character
// Delete a character
// Replace a character
//
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
//
//
// Constraints:
//
//
// 0 <= word1.length, word2.length <= 500
// word1 and word2 consist of lowercase English letters.
//
// Related Topics String Dynamic Programming
// 👍 5545 👎 66


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {

        int[][] distance = new int[word1.length()+1][word2.length()+1];

        for (int i=0; i<=word1.length(); i++) {
            distance[i][0] = i;
        }

        for (int j=0; j<=word2.length(); j++) {
            distance[0][j] = j;
        }


        for (int i=0; i<word1.length(); i++) {
            for (int j=0; j<word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j) ) {
                    distance[i+1][j+1] = distance[i][j];
                } else {
                    distance[i+1][j+1] = Math.min(distance[i][j], Math.min(distance[i+1][j], distance[i][j+1])) + 1;
                }
            }
        }

        return distance[word1.length()][word2.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
