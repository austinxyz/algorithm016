//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one
// sorted array.
//
// Note:
//
//
// The number of elements initialized in nums1 and nums2 are m and n respectivel
//y.
// You may assume that nums1 has enough space (size that is equal to m + n) to h
//old additional elements from nums2.
//
//
// Example:
//
//
//Input:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//Output: [1,2,2,3,5,6]
//
//
//
// Constraints:
//
//
// -10^9 <= nums1[i], nums2[i] <= 10^9
// nums1.length == m + n
// nums2.length == n
//
// Related Topics Array Two Pointers
// 👍 2534 👎 4383


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int id1 = m -1  ;
//        int id2 = n -1;
//
//        int index = m+n -1;
//
//        while (id1 >=0 && id2 >=0) {
//            if (nums1[id1] > nums2[id2]) {
//                nums1[index] = nums1[id1];
//                id1--;
//            } else {
//                nums1[index] = nums2[id2];
//                id2--;
//            }
//            index--;
//        }
//
//        while(id2 >=0) {
//            nums1[index] = nums2[id2--];
//            index--;
//        }
//
//    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int n1 = m-1;
        int n2 = n-1;

        while (n1 >=0 || n2 >=0) {
            if (n1 == -1) {
                nums1[n2] = nums2[n2];
                n2--;
            } else if (n2 == -1) {
                n1 = -1;
            } else if (nums1[n1] > nums2[n2]) {
                nums1[n1+n2+1] = nums1[n1];
                n1--;
            } else if (n2 >=0 ) {
                nums1[n1+n2+1] = nums2[n2];
                n2--;
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
