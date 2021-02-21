//Given an array A of non-negative integers, return an array consisting of all t
//he even elements of A, followed by all the odd elements of A.
//
// You may return any answer array that satisfies this condition.
//
//
//
//
// Example 1:
//
//
//Input: [3,1,2,4]
//Output: [2,4,3,1]
//The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
//
//
//
//
// Note:
//
//
// 1 <= A.length <= 5000
// 0 <= A[i] <= 5000
//
//
// Related Topics Array
// 👍 1536 👎 85


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int[] sortArrayByParity(int[] A) {

        int[] odd = new int[A.length];
        int[] even = new int[A.length];

        int oddIndex = 0;
        int evenIndex = 0;

        for (int x: A) {
            if (x % 2 == 0) {
                even[evenIndex++] = x;
            } else {
                odd[oddIndex++] = x;
            }
        }

        for (int i=0; i<oddIndex; i++) {
            even[i+evenIndex] = odd[i];
        }

        return even;

    }*/

    public int[] sortArrayByParity(int[] A) {

        int l = 0;
        int r = A.length-1;

        while (l < r) {
            while (l<A.length && A[l] % 2 == 0) {
                l++;
            }
            while (r>=0 && A[r] % 2 == 1 ) {
                r--;
            }
            if (l < r) {
                int tmp = A[l];
                A[l] = A[r];
                A[r] = tmp;
                l++;
                r--;
            }
        }

        return A;

    }

}
//leetcode submit region end(Prohibit modification and deletion)
