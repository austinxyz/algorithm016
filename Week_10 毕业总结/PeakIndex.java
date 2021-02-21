//Let's call an array arr a mountain if the following properties hold:
//
//
// arr.length >= 3
// There exists some i with 0 < i < arr.length - 1 such that:
//
// arr[0] < arr[1] < ... arr[i-1] < arr[i]
// arr[i] > arr[i+1] > ... > arr[arr.length - 1]
//
//
//
//
// Given an integer array arr that is guaranteed to be a mountain, return any i
//such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr
//.length - 1].
//
//
// Example 1:
// Input: arr = [0,1,0]
//Output: 1
// Example 2:
// Input: arr = [0,2,1,0]
//Output: 1
// Example 3:
// Input: arr = [0,10,5,2]
//Output: 1
// Example 4:
// Input: arr = [3,4,5,1]
//Output: 2
// Example 5:
// Input: arr = [24,69,100,99,79,78,67,36,26,19]
//Output: 2
//
//
// Constraints:
//
//
// 3 <= arr.length <= 104
// 0 <= arr[i] <= 106
// arr is guaranteed to be a mountain array.
//
//
//
//Follow up: Finding the O(n) is straightforward, could you find an O(log(n)) so
//lution? Related Topics Binary Search
// 👍 960 👎 1339


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int peakIndexInMountainArray(int[] arr) {

        return maxIndexInArray(arr, 0, arr.length -1);

    }

    private int maxIndexInArray(int[] arr, int start, int end) {
        if (start == end) {
            return start;
        }

        if (end - start == 1) {
            return arr[start] > arr[end]? start: end;
        }

        int mid = (start + end) / 2;

        int leftIndex = maxIndexInArray(arr, start, mid);
        int rightIndex = maxIndexInArray(arr, mid, end);

        return arr[leftIndex] > arr[rightIndex]? leftIndex: rightIndex;

    }*/

    public int peakIndexInMountainArray(int[] arr) {

        if (arr == null || arr.length ==0) {
            return -1;
        }

        int start = 0;
        int end = arr.length -1;


        while (start <= end) {

            int mid = (start + end) / 2;

            if (mid == start) {
                return arr[start] > arr[end]? start:end;
            }

            if (arr[mid] < arr[mid+1]) {
                start = mid +1;
            } else if (arr[mid] < arr[mid-1]) {
                end = mid -1;
            } else {
                return mid;
            }

        }

        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
