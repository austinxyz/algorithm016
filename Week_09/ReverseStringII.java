//
//Given a string and an integer k, you need to reverse the first k characters fo
//r every 2k characters counting from the start of the string. If there are less t
//han k characters left, reverse all of them. If there are less than 2k but greate
//r than or equal to k characters, then reverse the first k characters and left th
//e other as original.
//
//
// Example:
//
//Input: s = "abcdefg", k = 2
//Output: "bacdfeg"
//
//
//
//Restrictions:
//
// The string consists of lower English letters only.
// Length of the given string and k will in the range [1, 10000]
// Related Topics String
// 👍 506 👎 1425


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {

        StringBuffer res = new StringBuffer();

        int index = 0;

        boolean reverse = true;

        while (index < s.length()) {

            int next = index + k > s.length()? s.length() : index+k;

            String subS = s.substring(index, next);

            res.append(reverse? reverseString(subS): subS);

            index = next;

            reverse = !reverse;

        }

        return res.toString();
    }

    String reverseString(String subS) {

        StringBuffer res = new StringBuffer();

        char[] subArray = subS.toCharArray();
        for (int i = subArray.length-1; i >=0; i--) {
            res.append(subArray[i]);
        }

        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
