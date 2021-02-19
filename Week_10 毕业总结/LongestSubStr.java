//Given a string s, find the length of the longest substring without repeating c
//haracters.
//
//
// Example 1:
//
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//
//
// Example 2:
//
//
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//
//
// Example 3:
//
//
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a
//substring.
//
//
// Example 4:
//
//
//Input: s = ""
//Output: 0
//
//
//
// Constraints:
//
//
// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.
//
// Related Topics Hash Table Two Pointers String Sliding Window
// 👍 13111 👎 683


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() ==0) {
            return 0;
        }

        int[] index = new int[256];

        for (int i =0; i<256; i++) {
            index[i] = -1;
        }

        int length = 0;

        int start = 0;

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (index[c] < start) {
                index[c] = i;
            } else {
                length = Math.max(length, i - start);
                start = index[c]+1;
                index[c]=i;
            }
        }

        length = Math.max(length, s.length()-start);

        return length;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
