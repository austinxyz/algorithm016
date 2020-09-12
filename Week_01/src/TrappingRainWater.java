//Given n non-negative integers representing an elevation map where the width of
// each bar is 1, compute how much water it is able to trap after raining.
//
//
//The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In
//this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos
// for contributing this image!
//
// Example:
//
//
//Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
// Related Topics Array Two Pointers Stack
// 👍 8016 👎 129


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {

        if (height.length <= 1) {
            return 0;
        }

        int l = 0;
        int r = height.length-1;

        while (l<r && height[l] <= height[l+1] ) {
            l++;
        }

        while (l<r && height[r] <= height[r-1] ) {
            r--;
        }

        int res = 0;

        int left = height[l];
        int right = height[r];

        while (l < r) {

            if (left < right) {

                while (height[l] <= left && l < r) {
                    res += left - height[l];
                    l++;
                }

                left = height[l];
            } else {

                while (height[r] <= right && r > l) {
                    res += right - height[r];
                    r--;
                }
                right = height[r];
            }

        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
