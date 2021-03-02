//Find the kth largest element in an unsorted array. Note that it is the kth lar
//gest element in the sorted order, not the kth distinct element.
//
// Example 1:
//
//
//Input: [3,2,1,5,6,4] and k = 2
//Output: 5
//
//
// Example 2:
//
//
//Input: [3,2,3,1,2,4,5,5,6] and k = 4
//Output: 4
//
// Note:
//You may assume k is always valid, 1 ≤ k ≤ array's length.
// Related Topics Divide and Conquer Heap
// 👍 5205 👎 336


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*
    public int findKthLargest(int[] nums, int k) {

        return find(nums, k-1, 0, nums.length-1);

    }

    private int find(int[] nums, int k, int start, int end) {

        int left = start;
        int right = end;

        int pilot = nums[k];

        while (left < right ) {
            while (left < right && nums[left] > pilot) {
                left++;
            }

            while (right > left && nums[right] < pilot) {
                right--;
            }

            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }

        if (k == left+1) {
            return nums[left];
        }

        if (k > left+1) {
            return find(nums, k, left+1, end);
        } else {
            return find(nums, k, start, left-1);
        }

    }
*/

    public int findKthLargest(int[] nums,int k){
        int length = nums.length;
        if(length == 0)
            return 0;
        int left = 0,right = length - 1;
        while(left < right){
            int pos = partition(nums,left,right);
            if(pos == k - 1)
                break;
            if(pos < k - 1)
                left = pos + 1;
            else
                right = pos - 1;
        }
        return nums[k-1];
    }

    public int partition(int[] nums,int left,int right){
        int temp = nums[left];
        while (left < right){
            while (left < right && nums[right] <= temp){
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] >= temp){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
