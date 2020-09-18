学习笔记

## Completed list
1. WUDU coding 1st week's problems
1. Watch Videos - Done
1. Coding homework
1. Comments and Notes

## 本周课程

### Hash表，映射，集合
- Hash， O（1），最差情况 O（n）- 如果都hash在一起了
- 出现Hash碰撞的，可以保存为链表，或者红黑树

#### 实战题目

- [242](https://leetcode.com/problems/valid-anagram/discuss/?currentPage=1&orderBy=most_votes&query=) 有效的字母异位词
- [49](https://leetcode.com/problems/group-anagrams/discuss/?currentPage=1&orderBy=most_votes&query=) 字母异位词分组
- [1](https://leetcode.com/problems/two-sum/discuss/?currentPage=1&orderBy=most_votes&query=)  两数之和

### 树，二叉树，二叉搜索树
- 二维结构，为什么有树，来源于现实
- 二叉树，如果只有一个儿子，退化为链表
- 二叉搜索树， 左子树所有值都比根大，右子树所有值都比根小，插入，删除 O（logN）
- 树通常用递归来解，没法用循环来遍历
- 前，中，后，是说根节点的位置

#### 实战题目

- [94](https://leetcode.com/problems/binary-tree-inorder-traversal/discuss/?currentPage=1&orderBy=most_votes&query=)  二叉树的中序遍历
- [144](https://leetcode.com/problems/binary-tree-preorder-traversal/discuss/?currentPage=1&orderBy=most_votes&query=) 二叉树的前序遍历
- [590](https://leetcode.com/problems/n-ary-tree-postorder-traversal/discuss/?currentPage=1&orderBy=most_votes&query=) N叉树的后序遍历
- [589](https://leetcode.com/problems/n-ary-tree-preorder-traversal/discuss/?currentPage=1&orderBy=most_votes&query=) N叉树的前序遍历
- [429](https://leetcode.com/problems/n-ary-tree-level-order-traversal/discuss/?currentPage=1&orderBy=most_votes&query=) N叉树的层序遍历

### 堆，二叉堆，图
- 堆，小顶堆，大顶堆，用完全二叉树（数组）来表示，插入删除 O（logN），取最大/最小元素 O（1）
- 图， 临接矩阵，临接表，深度优先，广度优先，记录下visited set

#### 实战题目
- [40 最小的K个数](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/) 
- [239 滑动窗口最大值](https://leetcode.com/problems/sliding-window-maximum/discuss/?currentPage=1&orderBy=most_votes&query=) 

## 本周作业

### 简单
- [关于HashMap的小总结](HashMap.md)
- [242](https://leetcode.com/problems/valid-anagram/discuss/?currentPage=1&orderBy=most_votes&query=) [有效的字母异位词](ValidAnagram.java)
    - 建一个26的数组，分别统计a-z的个数，s的话++，t的话--，最后看有没有都是0

- [1](https://leetcode.com/problems/two-sum/discuss/?currentPage=1&orderBy=most_votes&query=)  [两数之和](TwoSum.java)
    - 将数组值为key，index在value放在Map中，然后再遍历数组，如果target-当前元素在Map的keySet中，同时value不是当前index，那么就是符合要求的两数

- [589](https://leetcode.com/problems/n-ary-tree-preorder-traversal/discuss/?currentPage=1&orderBy=most_votes&query=) [N叉树的前序遍历](NTreePreorder.java) 
    - 先根后子

- [HeapSort](src/HeapSort.java)
    - 将0-（n/2-1）做heapify，这样保证符合最小堆的要求，然后每次取出堆顶元素，将最后一个数放在堆顶重新heapify。

### 中等：
- [49](https://leetcode.com/problems/group-anagrams/discuss/?currentPage=1&orderBy=most_votes&query=) [字母异位词分组](GroupAnagrams.java)
    - 将每个string排序作为key，然后维持一个Map，保留原始的list，将string加到list中，最后输出所有value作为一个list
    - 高分写法，int[26]数组记录每个char的个数，convert成string作为key，维持一个map保留原始的list，将string加到list中，最后输出所有value作为一个list
- [94](https://leetcode.com/problems/binary-tree-inorder-traversal/discuss/?currentPage=1&orderBy=most_votes&query=)  [二叉树的中序遍历](BTreeInOrder.java)
- [144](https://leetcode.com/problems/binary-tree-preorder-traversal/discuss/?currentPage=1&orderBy=most_votes&query=) [二叉树的前序遍历](BTreePreOrder.java)
- [429](https://leetcode.com/problems/n-ary-tree-level-order-traversal/discuss/?currentPage=1&orderBy=most_votes&query=) [N叉树的层序遍历](NTreeLevelOrder.java)
- [264](https://leetcode.com/problems/ugly-number-ii/discuss/?currentPage=1&orderBy=most_votes&query=) [丑数](UglyNumber.java)
- [347](https://leetcode.com/problems/top-k-frequent-elements/discuss/?currentPage=1&orderBy=most_votes&query=) [前 K 个高频元素](TopKFreq.java)