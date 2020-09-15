public class HeapSort {

    public HeapSort() {

    }

    public int[] sort(int[] nums) {

        if (nums ==null || nums.length <=1) {
            return nums;
        }

        int[] result = new int[nums.length];

        System.arraycopy(nums, 0, result, 0, nums.length);

        for (int i= nums.length/2 -1 ; i >=0; i--) {
            heapify(nums, nums.length, i);
        }

        int last = nums.length -1;

        for (int i=0; i < nums.length; i++) {

            result[i] = nums[0];

            nums[0] = nums[last];

            heapify(nums, last, 0);

            last--;
        }

        return result;
    }

    void heapify(int[] nums, int length, int pos) {

        int lchild = 2*pos + 1;
        int rchild = 2*pos + 2;

        int min = pos;

        if (lchild < length && nums[lchild] < nums[min]) {
            min = lchild;
        }

        if (rchild < length && nums[rchild] < nums[min]) {
            min = rchild;
        }

        if (pos != min) {
            int temp = nums[pos];
            nums[pos] = nums[min];
            nums[min] = temp;

            heapify(nums, length, min);
        }

    }

    static void printArray(int nums[]) {
        for (int n: nums) {
            System.out.print(n);
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int nums[] = {12, 11, 13, 5, 6, 7};

        HeapSort sort = new HeapSort();
        printArray(sort.sort(nums));
    }
}
