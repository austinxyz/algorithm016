//Given a string, you need to reverse the order of characters in each word withi
//n a sentence while still preserving whitespace and initial word order.
//
// Example 1:
//
//Input: "Let's take LeetCode contest"
//Output: "s'teL ekat edoCteeL tsetnoc"
//
//
//
// Note:
//In the string, each word is separated by single space and there will not be an
//y extra space in the string.
// Related Topics String
// 👍 1233 👎 96


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        int index = 0;

        List<String> words = new ArrayList<String>();

        StringBuffer sb = new StringBuffer();

        for (char c: s.toCharArray()) {
            if (c == ' ') {
                if (sb.length() > 0) {
                    words.add(sb.toString());
                    sb = new StringBuffer();
                }
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            words.add(sb.toString());
        }

        StringBuffer result = new StringBuffer();
        for (int i = 0 ; i < words.size(); i++) {
            result.append(reverseString(words.get(i)));

            if (i < words.size()-1) {
                result.append(" ");
            }
        }

        return result.toString();
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
