//Given two strings s and t , write a function to determine if t is an anagram o
//f s.
//
// Example 1:
//
//
//Input: s = "anagram", t = "nagaram"
//Output: true
//
//
// Example 2:
//
//
//Input: s = "rat", t = "car"
//Output: false
//
//
// Note:
//You may assume the string contains only lowercase alphabets.
//
// Follow up:
//What if the inputs contain unicode characters? How would you adapt your soluti
//on to such case?
// Related Topics Hash Table Sort
// 👍 1931 👎 152


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {

        int[] counts1 = new int[256];
        int[] counts2 = new int[256];

        for (char c: s.toCharArray()) {
            counts1[c]++;
        }

        for (char c : t.toCharArray()) {
            counts2[c]++;
        }

        for (int i =0; i < 256; i++) {
            if (counts1[i] != counts2[i]) {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
