//Given an array A of non-negative integers, half of the integers in A are odd,
//and half of the integers are even.
//
// Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is e
//ven, i is even.
//
// You may return any answer array that satisfies this condition.
//
//
//
// Example 1:
//
//
//Input: [4,2,5,7]
//Output: [4,5,2,7]
//Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
//
//
//
//
// Note:
//
//
// 2 <= A.length <= 20000
// A.length % 2 == 0
// 0 <= A[i] <= 1000
//
//
//
//
// Related Topics Array Sort
// 👍 928 👎 57


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArrayByParityII(int[] A) {

        int odd = 1;
        int even = 0;



        while (odd < A.length && even < A.length) {

            while (even <A.length &&  A[even] % 2 == 0) {
                even=even+2;
            }

            while (odd <A.length && A[odd] % 2 == 1) {
                odd=odd+2;
            }

            if (even < A.length && odd < A.length) {
                int tmp = A[even];
                A[even] = A[odd];
                A[odd] = tmp;
                even = even + 2;
                odd = odd + 2;
            }

        }

        return A;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
