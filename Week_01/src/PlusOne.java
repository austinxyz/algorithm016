//Given a non-empty array of digits representing a non-negative integer, increme
//nt one to the integer.
//
// The digits are stored such that the most significant digit is at the head of
//the list, and each element in the array contains a single digit.
//
// You may assume the integer does not contain any leading zero, except the numb
//er 0 itself.
//
//
// Example 1:
//
//
//Input: digits = [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
//
//
// Example 2:
//
//
//Input: digits = [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.
//
//
// Example 3:
//
//
//Input: digits = [0]
//Output: [1]
//
//
//
// Constraints:
//
//
// 1 <= digits.length <= 100
// 0 <= digits[i] <= 9
//
// Related Topics Array
// 👍 1717 👎 2581


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {

        int inc=1;

        int[] result = new int[digits.length];

        for (int i=digits.length-1; i>=0; i--) {

            int digitValue = digits[i] + inc;

            if (digitValue > 9) {
                inc = 1;
                digitValue = digitValue - 10;
            } else {
                inc = 0;
            }

            result[i] = digitValue;
        }

        if (inc == 1) {
            result = new int[digits.length+1];
            result[0] = inc;
        }

        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
