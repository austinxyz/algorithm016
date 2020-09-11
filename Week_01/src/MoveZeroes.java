//Given an array nums, write a function to move all 0's to the end of it while m
//aintaining the relative order of the non-zero elements.
//
// Example:
//
//
//Input: [0,1,0,3,12]
//Output: [1,3,12,0,0]
//
// Note:
//
//
// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.
// Related Topics Array Two Pointers
// 👍 4185 👎 132


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {

        if (nums.length <= 1) {
            return;
        }

        int zPos = 0;
        int nzPos = 0;

        while (zPos < nums.length  && nzPos < nums.length) {

            while (zPos < nums.length && nums[zPos] != 0 ) {
                zPos++;
            }

            while (nzPos < nums.length && nums[nzPos] == 0 ) {
                nzPos++;
            }

            if (nzPos > zPos && nzPos < nums.length) {
                nums[zPos] = nums[nzPos];
                nums[nzPos] = 0;
                zPos++;
            }

            nzPos++;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
