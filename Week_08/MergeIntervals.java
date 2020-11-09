//Given a collection of intervals, merge all overlapping intervals.
//
// Example 1:
//
//
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//
//
// Example 2:
//
//
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//
// NOTE: input types have been changed on April 15, 2019. Please reset to defaul
//t code definition to get new method signature.
//
//
// Constraints:
//
//
// intervals[i][0] <= intervals[i][1]
//
// Related Topics Array Sort
// 👍 5499 👎 332


import java.util.Arrays;
import java.util.Comparator;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] == o2[0]) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        int[][] result = new int[intervals.length][2];

        if (intervals.length <= 1) {
            return intervals;
        }

        int begin = intervals[0][0];
        int end = intervals[0][1];

        int index =0;

        for (int i = 1; i < intervals.length; i++) {

            int nBegin = intervals[i][0];
            int nEnd = intervals[i][1];

            if (nBegin <= end) {
                end = Math.max(end, nEnd);
            } else {
                result[index][0] = begin;
                result[index][1] = end;
                begin = nBegin;
                end = nEnd;
                index++;
            }
        }

        result[index][0] = begin;
        result[index][1] = end;

        int[][] res = new int[index+1][2];

        for (int i=0; i <= index; i++) {
            res[i] = result[i];
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
