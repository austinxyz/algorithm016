//Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all ele
//ments in arr2 are also in arr1.
//
// Sort the elements of arr1 such that the relative ordering of items in arr1 ar
//e the same as in arr2. Elements that don't appear in arr2 should be placed at th
//e end of arr1 in ascending order.
//
//
// Example 1:
// Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//Output: [2,2,2,1,4,3,3,9,6,7,19]
//
//
// Constraints:
//
//
// arr1.length, arr2.length <= 1000
// 0 <= arr1[i], arr2[i] <= 1000
// Each arr2[i] is distinct.
// Each arr2[i] is in arr1.
//
// Related Topics Array Sort
// 👍 839 👎 61


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] counts = new int[1001];

        for (int i : arr1) {
            counts[i]++;
        }

        int k = 0;
        int[] res = new int[arr1.length];

        for (int i : arr2) {

            while(counts[i] > 0) {
                res[k] = i;
                counts[i]--;
                k++;
            }
        }

        for (int i=0; i< 1001; i++) {
            while (counts[i] >0) {
                res[k] = i;
                counts[i]--;
                k++;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
