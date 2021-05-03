//Given two strings s and t, return the number of distinct subsequences of s whi
//ch equals t.
//
// A string's subsequence is a new string formed from the original string by del
//eting some (can be none) of the characters without disturbing the remaining char
//acters' relative positions. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC"
// is not).
//
// It is guaranteed the answer fits on a 32-bit signed integer.
//
//
// Example 1:
//
//
//Input: s = "rabbbit", t = "rabbit"
//Output: 3
//Explanation:
//As shown below, there are 3 ways you can generate "rabbit" from S.
//rabbbit
//rabbbit
//rabbbit
//
//
// Example 2:
//
//
//Input: s = "babgbag", t = "bag"
//Output: 5
//Explanation:
//As shown below, there are 5 ways you can generate "bag" from S.
//babgbag
//babgbag
//babgbag
//babgbag
//babgbag
//
//
// Constraints:
//
//
// 1 <= s.length, t.length <= 1000
// s and t consist of English letters.
//
// Related Topics String Dynamic Programming
// 👍 1914 👎 64


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDistinct(String s, String t) {

        int[][] nums = new int[t.length()+1][s.length()+1];

        for (int i=0 ; i<s.length(); i++) {
            nums[0][i] = 1;
        }

        for (int i=1; i<=t.length(); i++) {
            for (int j=1; j<=s.length(); j++) {
                if (s.charAt(j-1) == t.charAt(i-1)) {
                    nums[i][j] = nums[i-1][j-1] + nums[i][j-1];
                } else {
                    nums[i][j] = nums[i][j-1];
                }
            }
        }
        return nums[t.length()][s.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
