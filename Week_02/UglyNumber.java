//Write a program to find the n-th ugly number.
//
// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
//
// Example:
//
//
//Input: n = 10
//Output: 12
//Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ug
//ly numbers.
//
// Note:
//
//
// 1 is typically treated as an ugly number.
// n does not exceed 1690.
// Related Topics Math Dynamic Programming Heap
// 👍 2101 👎 128


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {

        int[] ugly = new int[n];
        ugly[0] = 1;

        int factor2 = 2;
        int factor3 = 3;
        int factor5 = 5;

        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;

        for (int i=1; i<n; i++) {

            int min = Math.min(Math.min(factor2, factor3), factor5);

            ugly[i] = min;

            if (min == factor2) {
                factor2 = ugly[++idx2] * 2;
            }

            if (min == factor3) {
                factor3 = ugly[++idx3] * 3;
            }

            if (min == factor5) {
                factor5 = ugly[++idx5] * 5;
            }
        }

        return ugly[n-1];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
