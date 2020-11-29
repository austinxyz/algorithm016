//Given a string, find the first non-repeating character in it and return its in
//dex. If it doesn't exist, return -1.
//
// Examples:
//
//
//s = "leetcode"
//return 0.
//
//s = "loveleetcode"
//return 2.
//
//
//
//
// Note: You may assume the string contains only lowercase English letters.
// Related Topics Hash Table String
// 👍 2406 👎 127


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {

        if (s == null || s.length() ==0) {
            return -1;
        }

        int[] charCounts = new int[26];

        char[] chars = s.toCharArray();

        for (int i=0; i < chars.length; i++) {

            int charIndex = chars[i] - 'a';

            if (charCounts[charIndex] != 0 ) {
                charCounts[charIndex] = -1;
            } else {
                charCounts[charIndex] = i + 1;
            }
        }

        int ret = Integer.MAX_VALUE;
        for (int i=0; i<26; i++) {

            if (charCounts[i] > 0) {
                ret = Math.min(charCounts[i] - 1, ret);
            }
        }

        if (ret == Integer.MAX_VALUE) {
            ret = -1;
        }

        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
