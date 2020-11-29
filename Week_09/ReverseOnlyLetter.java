//Given a string S, return the "reversed" string where all characters that are n
//ot a letter stay in the same place, and all letters reverse their positions.
//
//
//
//
//
//
//
//
//
//
//
//
//
// Example 1:
//
//
//Input: "ab-cd"
//Output: "dc-ba"
//
//
//
// Example 2:
//
//
//Input: "a-bC-dEf-ghIj"
//Output: "j-Ih-gfE-dCba"
//
//
//
// Example 3:
//
//
//Input: "Test1ng-Leet=code-Q!"
//Output: "Qedo1ct-eeLg=ntse-T!"
//
//
//
//
//
// Note:
//
//
// S.length <= 100
// 33 <= S[i].ASCIIcode <= 122
// S doesn't contain \ or "
//
//
//
//
// Related Topics String
// 👍 680 👎 39


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseOnlyLetters(String S) {

        int first = 0;
        int last = S.length() -1;

        char[] res = new char[S.length()];

        while (first <= last) {
            char firstC = S.charAt(first);
            char lastC = S.charAt(last);
            while (!isLetter(firstC) && first <= last) {
                res[first] = firstC;
                first++;
                if (first <= last) {
                    firstC = S.charAt(first);
                }
            }

            while (!isLetter(lastC) && first <= last) {
                res[last] = lastC;
                last--;
                if (first <= last) {
                    lastC = S.charAt(last);
                }
            }

            if (first <= last) {
                res[first] = lastC;
                res[last] = firstC;
                first++;
                last--;
            }
        }

        return String.valueOf(res);
    }

    boolean isLetter(char c) {
        return (c>='a' && c <='z') || (c>='A' && c <='Z');
    }
}
//leetcode submit region end(Prohibit modification and deletion)
