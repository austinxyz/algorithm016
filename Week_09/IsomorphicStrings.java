//Given two strings s and t, determine if they are isomorphic.
//
// Two strings are isomorphic if the characters in s can be replaced to get t.
//
// All occurrences of a character must be replaced with another character while
//preserving the order of characters. No two characters may map to the same charac
//ter but a character may map to itself.
//
// Example 1:
//
//
//Input: s = "egg", t = "add"
//Output: true
//
//
// Example 2:
//
//
//Input: s = "foo", t = "bar"
//Output: false
//
// Example 3:
//
//
//Input: s = "paper", t = "title"
//Output: true
//
// Note:
//You may assume both s and t have the same length.
// Related Topics Hash Table
// 👍 1677 👎 414


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() == 0) {
            return true;
        }

        int[] sIndex = new int[256];
        int[] tIndex = new int[256];

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (int i=0; i<s.length(); i++) {
            if (sIndex[sChars[i]] ==0 ) {
                sIndex[sChars[i]] = i+1;
            }

            if (tIndex[tChars[i]] ==0) {
                tIndex[tChars[i]] = i+1;
            }

            if (sIndex[sChars[i]] != tIndex[tChars[i]]) {
                return false;
            }
        }

        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)