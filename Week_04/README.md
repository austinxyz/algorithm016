学习笔记

## Completed list
1. WUDU coding 3rd week's problems
1. Watch Videos - Done
1. Coding homework
1. Comments and Notes

## 本周课程

### 深度优先和广度优先搜索

#### DFS 模版
递归
```java
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if(root==null){
            return allResults;
        }
        travel(root,0,allResults);
        return allResults;
    }


    private void travel(TreeNode root,int level,List<List<Integer>> results){
        if(results.size()==level){
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        if(root.left!=null){
            travel(root.left,level+1,results);
        }
        if(root.right!=null){
            travel(root.right,level+1,results);
        }
    }
```

#### BFS 模版
```java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if (root == null) {
        return allResults;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
        int size = nodes.size();
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode node = nodes.poll();
            results.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        allResults.add(results);
    }
    return allResults;
}
```

- 深度优先常用递归，也可以用一个堆栈模拟递归来实现
- 广度优先，就是逐层遍历，通常用一个queue来保留当前层的节点
- 只有是有多个节点分叉的，都可以认为用深度或者广度优先来做，比如括号生成的问题

#### 贪心算法
- 贪心算法是希望通过当前最优解找到全局最优解。
- 和动态规划或者回溯不同的是，它不会回退，并且根据当前结果做比较。
- 贪心算法通常适合的情况比较少，但是获得的算法会比较简单，算法复杂度低

#### 实战题目


### 二分查找

#### 二发查找前提
1. 单点递增或者递减
1. 存在上下界
1. 能通过索引访问

- 模版
```java
public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right) {
        mid = (right - left) / 2 + left;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return -1;
}
```

#### 实战题目

| 题号 | 名称 | 难度 | 分类 | 备注 |
| --- | --- | --- | --- | --- |
| [102](https://leetcode.com/problems/binary-tree-level-order-traversal/discuss/?currentPage=1&orderBy=most_votes&query=) | [二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)| 🟡 中等 | 深度优先、广度优先 | - |
| [433](https://leetcode.com/problems/minimum-genetic-mutation/discuss/?currentPage=1&orderBy=most_votes&query=) | [最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation/)| 🟡 中等 | 深度优先、广度优先 | - |
| [22](https://leetcode.com/problems/generate-parentheses/discuss/?currentPage=1&orderBy=most_votes&query=) | [括号生成](https://leetcode-cn.com/problems/generate-parentheses/)| 🟡 中等 | 深度优先、广度优先 | - |
| [515](https://leetcode.com/problems/find-largest-value-in-each-tree-row/discuss/?currentPage=1&orderBy=most_votes&query=) | [在每个树行中找最大值](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/)| 🟡 中等 | 深度优先、广度优先 | - |
| [322](https://leetcode.com/problems/coin-change/discuss/?currentPage=1&orderBy=most_votes&query=) | [零钱兑换](https://leetcode-cn.com/problems/coin-change/)| 🟡 中等 | 贪心算法 | - |
| [69](https://leetcode.com/problems/sqrtx/discuss/?currentPage=1&orderBy=most_votes&query=) | [x 的平方根](https://leetcode-cn.com/problems/sqrtx/)| 🟢 简单 | 二分查找 | - |
| [367](https://leetcode.com/problems/valid-perfect-square/discuss/?currentPage=1&orderBy=most_votes&query=) | [有效的完全平方数](https://leetcode-cn.com/problems/valid-perfect-square/)| 🟢 简单 | 二分查找 | - |


## 本周作业

| 题号 | 名称 | 难度 | 分类 | 备注 |
| --- | --- | --- | --- | --- |
| [860](https://leetcode.com/problems/lemonade-change/discuss/?currentPage=1&orderBy=most_votes&query=) | [柠檬水找零](LemonadeChange.java)| 🟢 简单 | 贪心算法 | 记录手中的5分，10分的数量，尽量先找10分 |
| [122](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/discuss/?currentPage=1&orderBy=most_votes&query=) | [买卖股票的最佳时机 II](BestTimeStockII.java)| 🟢 简单 | 贪心算法 | 先确定什么时候买，如果发现目前股价比前一天贵，那么前一天的股价可以作为买入股价，如果发现目前股价比前一天便宜，如果已经有买入，那可以将前一天的股价作为卖出股价。 |
| [455](https://leetcode.com/problems/assign-cookies/discuss/?currentPage=1&orderBy=most_votes&query=) | [分发饼干](AssignCookies.java)| 🟢 简单 | 贪心算法 | 先排序，i=0，j=0, 如果小孩可以满足 i++,j++, 不然就只是j++，最后计数所有可以满足的小孩 |
| [874](https://leetcode.com/problems/walking-robot-simulation/discuss/?currentPage=1&orderBy=most_votes&query=) | [模拟行走机器人](WalkingRobot.java)| 🟢 简单 | 贪心算法 | 判断command，如果负，确定方向，如果正，根据障碍信息，确定坐标，每次都算欧几里得距离，保留最大值 |
| [127](https://leetcode.com/problems/word-ladder/discuss/?currentPage=1&orderBy=most_votes&query=) | [单词接龙](WordLadder.java)| 🟡 中等 | 深度优先、广度优先 | 广度优先，找到和当前单词差一个char的单词集合（排除那些已经使用过的），将其加在一个queue中，level+1，继续遍历这个queue，直到发现目标单词 |
| [200](https://leetcode.com/problems/number-of-islands/discuss/?currentPage=1&orderBy=most_votes&query=) | [岛屿数量](IslandsNumber.java)| 🟡 中等 | 深度优先、广度优先 | 遍历数组，如果发现当前点为'1'，那么将其变为'0'，同时将相邻为'1'也变为'0'，岛屿数量++，直到所有都是'0' |
| [529](https://leetcode.com/problems/minesweeper/discuss/?currentPage=1&orderBy=most_votes&query=) | [扫雷游戏](Minesweeper.java)| 🟡 中等 | 深度优先、广度优先 | 如果当前点是M，那么标记为X，结束，如果当前是E，那么要计算count，如果count==0，那么标记为'B'，同时计算周围的点，否则将当前点标记为count，结束|
| [55](https://leetcode.com/problems/jump-game/discuss/?currentPage=1&orderBy=most_votes&query=) | [跳跃游戏](JumpGame.java)| 🟡 中等 | 贪心算法 | 遍历数组，发现最大的i+nums[i]，如果永远大于当前i，最后大于数组长度-1，那么返回true |
| [45](https://leetcode.com/problems/jump-game-ii/discuss/?currentPage=1&orderBy=most_votes&query=) | [跳跃游戏 II](JumpGameII.java)| 🟡 中等 | 贪心算法 | 查询当前i到当前最大距离，发现最大的i+num[i]，这个就是下一个最大距离，jump+1，继续找下一个最大距离，直到距离大于数组长度-1|
| [33](https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/?currentPage=1&orderBy=most_votes&query=) | [搜索旋转排序数组](SearchRotatedSortedArray.java)| 🟡 中等 | 二分查找 | - |
| [74](https://leetcode.com/problems/search-a-2d-matrix/discuss/?currentPage=1&orderBy=most_votes&query=) | [搜索二维矩阵](Search2DMatrix.java)| 🟡 中等 | 二分查找 | - |
| [153](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/discuss/?currentPage=1&orderBy=most_votes&query=) | [寻找旋转排序数组中的最小值](FindMinInRotatedSortedArray.java)| 🟡 中等 | 二分查找 | - |
| [126](https://leetcode.com/problems/word-ladder-ii/discuss/?currentPage=1&orderBy=most_votes&query=) | [单词接龙 II]()| 🔴 困难 | 深度优先、广度优先 | - |

- 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
    - 假定是升序的 left<mid<right
    - left=0，right=6, mid=3, 1，array[mid]>array[left], 2，array[right]>array[mid] 发现 #2不符合假设，说明无序的#2， left=mid=3
    - left=3，right=6，mid=4，1，array[mid]>array[left], 2，array[right]>array[mid] 发现 #1不符合假设，说明无序的#1，right=mid=4
    - 如果right-left=1，那么已经找到无序的地方了
    
 ```java
 public int findDisOrder(int[] array) {
     
    int lowest = nums[left] > nums[right]? right: left;
   
    while (right - left >1) {
   
        int mid = left + (right-left)/2;
   
        if (nums[mid] > nums[left]) {
            left = mid;
        }
   
        if (nums[mid] < nums[right]) {
            right = mid;
        }
    }
   
    lowest = nums[lowest] > nums[right]? right: lowest;
 
    return lowest;
 }
 ```