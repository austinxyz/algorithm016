//Given an array of strings strs, group the anagrams together. You can return th
//e answer in any order.
//
// An Anagram is a word or phrase formed by rearranging the letters of a differe
//nt word or phrase, typically using all the original letters exactly once.
//
//
// Example 1:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Example 2:
// Input: strs = [""]
//Output: [[""]]
// Example 3:
// Input: strs = ["a"]
//Output: [["a"]]
//
//
// Constraints:
//
//
// 1 <= strs.length <= 104
// 0 <= strs[i].length <= 100
// strs[i] consists of lower-case English letters.
//
// Related Topics Hash Table String
// 👍 4014 👎 197


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> groups = new HashMap<String, List<String>>();

        for (int i =0; i < strs.length; i++) {

            String key = getKey(strs[i]);

            if (groups.containsKey(key)) {
                List<String> group = groups.get(key);
                group.add(strs[i]);
            } else {
                List<String> group = new ArrayList<String>();
                group.add(strs[i]);
                groups.put(key, group);
            }

        }

        List<List<String>> result = new ArrayList<List<String>>();

        for (List<String> group : groups.values()) {
            result.add(group);
        }

        return result;
    }

    String getKey(String str) {

        char[] sArr = str.toCharArray();
        Arrays.sort(sArr);
        return Arrays.toString(sArr);

    }

}
//leetcode submit region end(Prohibit modification and deletion)
