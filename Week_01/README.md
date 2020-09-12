学习笔记

## Completed list
1. Study Guide
2. Setup IDEA and install plug-ins
3. Github account create & fork
4. Git clone and update week 1 README.md
5. Watch Videos
6. Coding
7. Comments

## 本周课程

### 如何高效学习

#### 五毒神掌
1. 5-10 分钟读题和思考，如果没有思路，看题解，默写代码
1. 马上自己写，提交LeetCode，多种解法，体会优化
1. 24 小时之后，再重复做题
1. 一周后重复做题
1. 面试前一周恢复性训练

Note：
- 如果在基础不好的情况下，应该是先看题解，熟读唐诗三百首，这样就学会了一些pattern，比较自己造车。当然坏处是以后遇到不熟的题目，可能不太有信心。所以做到一定的程度，各种类型都做过了，那就尽量自己做了。5-10分钟是一个好的时间尺度。
- 五遍的方法实际上就是和背单词差不多的，看你的基础程度，有些简单的题目可能并不需要都是五遍。

#### 切题四件套
1. 理清题意，确定题目的要求
2. 想尽可能多的解法，对比几种写法的时空复杂度，找到比较好的解法
3. 尽可能多地动手写
4. 测试用例

Note：
- 至少记住一个可行解，可能不是最好的，但是是容易比较记住的。
- Coding Style和快捷键会提高效率，减少bug，显示你的专业程度
- 边界条件，多考虑一下
- 不要写一些很短但是不容易理解的写法，还是要保证成功率第一。

### 时间空间复杂度分析
- 常用复杂度 

### 数组，链表，跳表
- 数组，链表各有优劣，数组O（1）lookup，插入删除 O（n），链表O（n）lookup，插入删除O（1）
- 跳表通过升维，将链表O（n）的lookup变成了O（logN），同时插入删除也变成了O（logN）- 至少比数组好。这样lookup，增删改都是O（logN），相对平衡，但是只能是有序数组。
- 同样二维结构，平衡二叉树比跳表实现逻辑更加复杂。他们的算法复杂度是类似。

#### 实战题目
- 移动零 - 用同侧双指针，如果当前为零，找到右边最近的非零交换
- 盛水最多的容器 - 用两侧双指针，记录当前最大值，通过移动两侧高度小的那个，使得高度变大来抵消宽度变小。
- 爬楼梯 - 用递归，但是需要用memo来消除重复计算
- 3数之和 - 先考虑两数之和。两数之和 （暴力解法双循环，HashMap两次循环，排序后两端双指针），然后用三指针，第一个指针扫描0，n-3，第2，3个指针用双端双指针。
- 环形链表 - 用快慢指针，如果快的赶上慢的。
- 反转链表 - 记住指针，加一个哨兵
- 两两交换节点 - 记住指针
- K个一组翻转链表 - 记住头尾

### 栈，队列，优先队列，双端队列
- 栈和队列，一个是先入先出，一个是先入后出，适合不同的需要。insert，delete是O（1）
- 优先队列是根据优先级插入的队列，每次取出来是最优先的元素，通常是通过Heap来实现。insert，delete是O（logN）
- 双端队列可以同时支持stack和queue

#### 实战题目
- 有效的括号 - 典型的堆栈应用，通过看到（，压入），这样可以用equals来比较。节省代码
- 最小栈 - 就是自己实现一个栈，可以通过一个数组和栈指针来实现
- 柱状图中最大矩形 - 暴力解法，双循环+找到最小值。考虑用堆栈，如果左边的数小于右边的数，那么要压栈，因为右边界还不能确定，不然右边界确定，可以算出对应下标的矩形值。
- 滑动窗口最大值 - 暴力解法，每个滑动窗口都计算，考虑使用双端队列，将当前值的下标加入队列，如果队列中对应值比这个要小，可以都移调。如果队列头的元素下标超过了窗口，那么去掉队列头元素。

## 本周作业

### 简单：
- [用 add first 或 add last 这套新的 API 改写 Deque 的代码](src/DequeExample.java)
- [分析Queue和Priority Queue的源码](QueueAndPriorityQueueAnalysis.md)
- [26](https://leetcode.com/problems/remove-duplicates-from-sorted-array/discuss/?currentPage=1&orderBy=most_votes&query=) - [删除排序数组中的重复项](src/RemoveDuplicates.java)
    - 除了返回新的数组长度，数组的值也要压缩 
    - 可以用快慢指针，快指针for循环，慢指针初始为0，只有在不等于的时候，先++，然后赋值，最后长度为慢指针+1
- [189](https://leetcode.com/problems/rotate-array/discuss/?currentPage=1&orderBy=most_votes&query=) - [旋转数组](src/RotateArray.java) 
    - 我用的是每次找到下一个要替换的位置的方法，但是要考虑可能k被n整除的情况，总共替换O（n）次，但是有不少判断条件
    - 高分的写法是通过三次reverse，把整个reverse，然后0，k-1 reverse，k，n-1 reverse，总共替换O（2n）很简洁但是不一定马上能想到
    - Brute force的写法，就是k个循环，每次移动一位，这样是O（k*n）次
- [21](https://leetcode.com/problems/merge-two-sorted-lists/discuss/?currentPage=1&orderBy=most_votes&query=)  - [合并两个有序链表](src/MergeSortedLists.java) 
    - 加入一个哨兵节点作为head，while循环到其中一个为null
    - 通过递归的方法写，比较简洁
- [88](https://leetcode.com/problems/merge-sorted-array/discuss/?currentPage=1&orderBy=most_votes&query=) - [合并两个有序数组](src/MergeSortedArray.java)
    - 从后往前merge，一个while，条件语句写的有点复杂
    - 高分写法，两个循环，先做到其中一个为-1，然后另一个循环将数组2剩余的复制过来，如果数组2已经是-1了，那就不用复制了
- [1](https://leetcode.com/problems/two-sum/discuss/?currentPage=1&orderBy=most_votes&query=)  - [两数之和](src/TwoSum.java)
    - 排序后前后指针，要保留原数组，然后找到原来的index比较麻烦一些，而且要考虑两个数相等的情况
    - 另一个解就是用hashMap
- [283](https://leetcode.com/problems/move-zeroes/discuss/?currentPage=1&orderBy=most_votes&query=)  - [移动零](src/MoveZeroes.java)
    - 用两个指针从0开始，一个指向零，一直指向非零，如果非零index大于零，那么需要交换。两个指针都往前，需要注意的是，如果非零index小于零，那么，那么零的位置保留，非零的位置往前。
    - 高分写法，记录insert指针，从零开始，发现非零，就将当前insert指针赋值，同时insert指针加1。最后将后面所有的赋为0。
- [66](https://leetcode.com/problems/plus-one/discuss/?currentPage=1&orderBy=most_votes&query=) - [加一](src/PlusOne.java)
    - 从后往前遍历，如果大于9，那么进位，如果最后一位也要进位，建一个长度+1的新数组，第一个位赋1
    - 高分写法，如果不需要进位，那么直接返回数组，如果最后一位也要进位，建一个长度+1的新数组，第一个位赋1，返回新数组

### 中等：
- [641](https://leetcode.com/problems/design-circular-deque/discuss/?currentPage=1&orderBy=most_votes&query=) - [设计循环双端队列](src/MyCircularDeque.java)
    - 记录head，tail，usedSize，和size。初始head=0，tail=size-1

### 困难：
- [42](https://leetcode.com/problems/trapping-rain-water/discuss/?currentPage=1&orderBy=most_votes&query=) - [接雨水](src/TrappingRainWater.java)
    - 双指针，找到左右两边边可以接雨水的边界，从小的一侧开始往里，如果当前值比边界小，那么差值就是雨水，否则就是新的边界