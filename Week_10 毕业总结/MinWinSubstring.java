//Given two strings s and t, return the minimum window in s which will contain a
//ll the characters in t. If there is no such window in s that covers all characte
//rs in t, return the empty string "".
//
// Note that If there is such a window, it is guaranteed that there will always
//be only one unique minimum window in s.
//
//
// Example 1:
// Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
// Example 2:
// Input: s = "a", t = "a"
//Output: "a"
//
//
// Constraints:
//
//
// 1 <= s.length, t.length <= 105
// s and t consist of English letters.
//
//
//
//Follow up: Could you find an algorithm that runs in O(n) time? Related Topics
//Hash Table Two Pointers String Sliding Window
// 👍 6018 👎 408


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {

        int start=0, end=0;

        int[] needs = new int[256];

        Set<Character> tSet = new HashSet<Character>();

        for (char c: t.toCharArray()) {
            needs[c]++;
            tSet.add(c);
        }

        int needsCount = t.length();

        String result = "";

        while(end < s.length()) {

            char c = s.charAt(end);

            if (tSet.contains(c) ) {
                needs[c]--;

                if (needs[c]>=0) {
                    needsCount--;
                }
            }



            if (needsCount ==0) {
                if (result.isEmpty()) {
                    result = s.substring(start, end+1);
                } else {
                    if (result.length() > (end-start)) {
                        result = s.substring(start, end+1);
                    }
                }

                while(needsCount ==0) {

                    c = s.charAt(start);

                    if (tSet.contains(c)) {
                        needs[c]++;
                    }

                    if (needs[c] > 0) {
                        needsCount++;
                    }

                    if (result.length() > (end-start)) {
                        result = s.substring(start, end+1);
                    }

                    start++;

                }
            }

            end++;

        }

        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
