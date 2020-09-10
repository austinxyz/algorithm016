学习笔记

Completed list
1. Study Guide
2. Setup IDEA and install plug-ins
3. Github account create & fork
4. Git clone and update week 1 README.md
5. Watch Videos
6. Coding
7. Comments

### 五毒神掌
1. 5-10 分钟读题和思考，如果没有思路，看题解，默写代码
1. 马上自己写，提交LeetCode，多种解法，体会优化
1. 24 小时之后，再重复做题
1. 一周后重复做题
1. 面试前一周恢复性训练

Note：
- 如果在基础不好的情况下，应该是先看题解，熟读唐诗三百首，这样就学会了一些pattern，比较自己造车。当然坏处是以后遇到不熟的题目，可能不太有信心。所以做到一定的程度，各种类型都做过了，那就尽量自己做了。5-10分钟是一个好的时间尺度。
- 五遍的方法实际上就是和背单词差不多的，看你的基础程度，有些简单的题目可能并不需要都是五遍。


### 切题四件套
1. 理清题意，确定题目的要求
2. 想尽可能多的解法，对比几种写法的时空复杂度，找到比较好的解法
3. 尽可能多地动手写
4. 测试用例

Note：
- 至少记住一个可行解，可能不是最好的，但是是容易比较记住的。
- Coding Style和快捷键会提高效率，减少bug，显示你的专业程度
- 边界条件，多考虑一下
- 不要写一些很短但是不容易理解的写法，还是要保证成功率第一。

### 本周作业

#### 简单：
- [用 add first 或 add last 这套新的 API 改写 Deque 的代码](src/DequeExample.java)
- [分析Queue和Priority Queue的源码](QueueAndPriorityQueueAnalysis.md)
- [26](https://leetcode.com/problems/remove-duplicates-from-sorted-array/discuss/?currentPage=1&orderBy=most_votes&query=) - [删除排序数组中的重复项](src/RemoveDuplicates.java)
    - 除了返回新的数组长度，数组的值也要压缩 
- [189](https://leetcode.com/problems/rotate-array/discuss/?currentPage=1&orderBy=most_votes&query=) - [旋转数组](src/RotateArray.java) 
    - 我用的是每次找到下一个要替换的位置的方法，但是要考虑可能k被n整除的情况，总共替换O（n）次，但是有不少判断条件
    - 高分的写法是通过三次reverse，把整个reverse，然后0，k-1 reverse，k，n-1 reverse，总共替换O（2n）很简洁但是不一定马上能想到
    - Brute force的写法，就是k个循环，每次移动一位，这样是O（k*n）次
- [21](https://leetcode.com/problems/merge-two-sorted-lists/discuss/?currentPage=1&orderBy=most_votes&query=)  - 合并两个有序链表 
- [88](https://leetcode.com/problems/merge-sorted-array/discuss/?currentPage=1&orderBy=most_votes&query=) - 合并两个有序数组
- [1](https://leetcode.com/problems/two-sum/discuss/?currentPage=1&orderBy=most_votes&query=)  - 两数之和
- [283](https://leetcode.com/problems/move-zeroes/discuss/?currentPage=1&orderBy=most_votes&query=)  - 移动零
- [66](https://leetcode.com/problems/plus-one/discuss/?currentPage=1&orderBy=most_votes&query=) - 加一

#### 中等：
- [641](https://leetcode.com/problems/design-circular-deque/discuss/?currentPage=1&orderBy=most_votes&query=) - 设计循环双端队列

#### 困难：
- [42](https://leetcode.com/problems/trapping-rain-water/discuss/?currentPage=1&orderBy=most_votes&query=) - 接雨水