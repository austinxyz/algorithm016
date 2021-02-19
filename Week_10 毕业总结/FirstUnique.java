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
// 👍 2654 👎 132


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {

        int[] counts = new int[26];

        for (char c: s.toCharArray()) {
            counts[c-'a']++;
        }

        for (int i=0; i< s.length(); i++) {
            char c = s.charAt(i);

            if (counts[c-'a'] ==1) {
                return i;
            }
        }

        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
