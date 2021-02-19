//You are given two strings s and t.
//
// String t is generated by random shuffling string s and then add one more lett
//er at a random position.
//
// Return the letter that was added to t.
//
//
// Example 1:
//
//
//Input: s = "abcd", t = "abcde"
//Output: "e"
//Explanation: 'e' is the letter that was added.
//
//
// Example 2:
//
//
//Input: s = "", t = "y"
//Output: "y"
//
//
// Example 3:
//
//
//Input: s = "a", t = "aa"
//Output: "a"
//
//
// Example 4:
//
//
//Input: s = "ae", t = "aea"
//Output: "a"
//
//
//
// Constraints:
//
//
// 0 <= s.length <= 1000
// t.length == s.length + 1
// s and t consist of lower-case English letters.
//
// Related Topics Hash Table Bit Manipulation
// 👍 1181 👎 312


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[] sCount = new int[26];
    int[] tCount = new int[26];

    public char findTheDifference(String s, String t) {

        for (char c: s.toCharArray()) {
            sCount[c-'a']++;
        }

        for (char c: t.toCharArray()) {
            tCount[c-'a']++;
        }

        for (int i=0; i < 26; i++) {
            if (sCount[i] != tCount[i]) {
                return (char)('a' + i);
            }
        }

        return '0';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
