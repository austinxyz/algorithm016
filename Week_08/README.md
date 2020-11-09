学习笔记

## Completed list
1. WUDU coding 7th week's problems
1. Watch Videos - Done
1. Coding homework
1. Comments and Notes

## 本周课程

### 位运算

```
x^0=x
x^1s = ~x
x^(~x) = 1s
x^x = 0
x & (~0 <<n) 最右边n位清零
(x>>n) & 1 获取x的第n位值
x & (1<<n) 获取x的第n位的幂值
x | (1<<n) 将第n位置为1
x & (~(1<<n)) 将第n位置为0
x & ()(1<<n)-1) 将x最高位至第n位清零

x%2  判断奇偶
x>>1  除2
x&(x-1) 清零最低位的1
x&-x 得到最低位的1
```

### bloom filter和LRU

- 如果不在，那么一定不在，如果在的，有可能是误判
- [Java 参考](https://github.com/lovasoa/bloomfilter/blob/master/src/main/java/BloomFilter.java)

### LRU

- Lease recently use
- Hashtable + 双向链表


### 排序算法

- [经典排序算法](https://www.cnblogs.com/onepixel/p/7674659.html)
- 比较类排序 - bibble,quick,insert,select,heap,merge,shell 
- 非比较类排序 - counting,radix,bucket

模版
Quick sort
```java
/ Java
public static void quickSort(int[] array, int begin, int end) {
    if (end <= begin) return;
    int pivot = partition(array, begin, end);
    quickSort(array, begin, pivot - 1);
    quickSort(array, pivot + 1, end);
}
static int partition(int[] a, int begin, int end) {
    // pivot: 标杆位置，counter: 小于pivot的元素的个数
    int pivot = end, counter = begin;
    for (int i = begin; i < end; i++) {
        if (a[i] < a[pivot]) {
            int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
            counter++;
        }
    }
    int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
    return counter;
}
```

Merge sort
```java
public static void mergeSort(int[] array, int left, int right) {
    if (right <= left) return;
    int mid = (left + right) >> 1; // (left + right) / 2

    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);
}

public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // 中间数组
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid)   temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
        // 也可以用 System.arraycopy(a, start1, b, start2, length)
}
```

Heap sort
```java
static void heapify(int[] array, int length, int i) {
    int left = 2 * i + 1, right = 2 * i + 2；
    int largest = i;
    if (left < length && array[left] > array[largest]) {
        largest = left;
    }
    if (right < length && array[right] > array[largest]) {
        largest = right;
    }
    if (largest != i) {
        int temp = array[i]; array[i] = array[largest]; array[largest] = temp;
        heapify(array, length, largest);
    }
}
public static void heapSort(int[] array) {
    if (array.length == 0) return;
    int length = array.length;
    for (int i = length / 2-1; i >= 0; i-) 
        heapify(array, length, i);
    for (int i = length - 1; i >= 0; i--) {
        int temp = array[0]; array[0] = array[i]; array[i] = temp;
        heapify(array, i, 0);
    }
}
```

### 特殊排序

#### 实战题目

| 题号 | 名称 | 难度 | 分类 | 备注 |
| --- | --- | --- | --- | --- |
|位1的个数|
|2的幂|
|颠倒二进制位|
|N皇后|
|N皇后II|
|比特位计数|
|LRU 缓存机制|
|数组的相对排序|
|有效的字母异位词|
|力扣排行榜|
|合并区间|
|翻转对|

## 本周作业

| 题号 | 名称 | 难度 | 分类 | 备注 |
| --- | --- | --- | --- | --- |
|191|[位1的个数](NumberOfBits.java)|
|231|[2的幂](PowerOfTwo.java)|
|190|[颠倒二进制位](ReverseBits.java)|
|1122|[数组的相对排序](RelativeSortArray.java)|
|242|[有效的字母异位词](ValidAnagram.java)|
|146|[LRU缓存机制](LRUCache.java)|
|1244|力扣排行榜|
|56|[合并区间](MergeIntervals.java)|
|N皇后|
|N皇后II|
|翻转对|


