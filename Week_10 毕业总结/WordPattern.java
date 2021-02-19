//Given a pattern and a string s, find if s follows the same pattern.
//
// Here follow means a full match, such that there is a bijection between a lett
//er in pattern and a non-empty word in s.
//
//
// Example 1:
//
//
//Input: pattern = "abba", s = "dog cat cat dog"
//Output: true
//
//
// Example 2:
//
//
//Input: pattern = "abba", s = "dog cat cat fish"
//Output: false
//
//
// Example 3:
//
//
//Input: pattern = "aaaa", s = "dog cat cat dog"
//Output: false
//
//
// Example 4:
//
//
//Input: pattern = "abba", s = "dog dog dog dog"
//Output: false
//
//
//
// Constraints:
//
//
// 1 <= pattern.length <= 300
// pattern contains only lower-case English letters.
// 1 <= s.length <= 3000
// s contains only lower-case English letters and spaces ' '.
// s does not contain any leading or trailing spaces.
// All the words in s are separated by a single space.
//
// Related Topics Hash Table
// 👍 1706 👎 208


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public boolean wordPattern(String pattern, String s) {

        Map<String, Character> map = new HashMap<String, Character>();

        int[] used = new int[26];

        String[] strs = s.split(" ");

        if (strs.length != pattern.length()) {
            return false;
        }

        for (int i=0; i< pattern.length(); i++) {
            char c = pattern.charAt(i);

            String key = strs[i];

            if (map.containsKey(key)) {
                if (map.get(key).charValue() != c) {
                    return false;
                }
            } else {

                if (used[c-'a'] == 1) {
                    return false;
                } else {
                    map.put(key, c);
                    used[c-'a'] = 1;
                }
            }

        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
