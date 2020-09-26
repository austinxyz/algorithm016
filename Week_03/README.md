学习笔记

## Completed list
1. WUDU coding 2nd week's problems
1. Watch Videos - Done
1. Coding homework
1. Comments and Notes

## 本周课程

### 泛型递归，树的递归

#### 递归模版
```java
public void recur(int level, int param) { 
  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }
  // process current logic 
  process(level, param); 
  // drill down 
  recur( level: level + 1, newParam); 
  // restore current status 
 
}
```
- 拒绝人肉递归
- 要有退出条件
- 找重复子问题
- 数学归纳法
- 本质是循环的一种，可以通过堆栈来模拟递归

#### 树
- 为什么树适合递归，因为重复子结构，二维结构不适合循环

#### 实战题目

- [70](https://leetcode.com/problems/climbing-stairs/discuss/?currentPage=1&orderBy=most_votes&query=) 爬楼梯
- [22](https://leetcode.com/problems/generate-parentheses/discuss/?currentPage=1&orderBy=most_votes&query=) 括号生成
- [226](https://leetcode-cn.com/problems/invert-binary-tree/description/) 翻转二叉树
- [98](https://leetcode-cn.com/problems/validate-binary-search-tree/) 验证二叉搜索树
- [104](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/) 二叉树的最大深度
- [111](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/) 二叉树的最小深度
- [297](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/) 二叉树的序列化与反序列化

### 分治，回溯

#### 分治
- 一种特殊的递归
- 模版
```java
private static int divide_conquer(Problem problem, ) {
  
  if (problem == NULL) {
    int res = process_last_result();
    return res;     
  }
  subProblems = split_problem(problem)
  
  res0 = divide_conquer(subProblems[0])
  res1 = divide_conquer(subProblems[1])
  
  result = process_result(res0, res1);
  
  return result;
}
```

#### 回溯
- 就好像走迷宫，发现某一个不能达到目标，回推找新的路径

#### 实战题目

- [50](https://leetcode.com/problems/powx-n/discuss/?currentPage=1&orderBy=most_votes&query=) Pow(x, n)
- [78](https://leetcode.com/problems/subsets/discuss/?currentPage=1&orderBy=most_votes&query=) 子集
- [169](https://leetcode-cn.com/problems/majority-element/description/) 多数元素
- [17](https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/?currentPage=1&orderBy=most_votes&query=) 电话号码的字母组合
- [51](https://leetcode.com/problems/n-queens/discuss/?currentPage=1&orderBy=most_votes&query=) N皇后


## 本周作业

- [236](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/discuss/?currentPage=1&orderBy=most_votes&query=)  [二叉树的最近公共祖先](LCABinaryTree.java)
    - 递归，从root，如果root是q或者p，那么返回root，否则看root.left，和root.right下有没至少一个p或者q，如果都在一侧则返回LCA，如果在两侧，则返回root。

- [105](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/?currentPage=1&orderBy=most_votes&query=)  [从前序与中序遍历序列构造二叉树](BuildTreeByPreIn.java)
    - root是preorder的第一个元素，构造root node，然后找到inorder的位置，前面的元素是leftinorder，后面的是rightinorder，从1， 然后在拿相同元素个数作为leftpreoder，剩下的是rightpreoder。这样就可以递归得到left和right。
    
- [77](https://leetcode.com/problems/combinations/discuss/?currentPage=1&orderBy=most_votes&query=)  [组合](Combinations.java)
    - 因为是不考虑次序的，可以让升序排列，保留前序list，然后从list的最后元素 +1开始保证是升序的。递归到k层。
    
- [46](https://leetcode.com/problems/permutations/discuss/?currentPage=1&orderBy=most_votes&query=)  [全排列](Permutations.java)
    - 记录下前序list，考虑次序，所以每次都是for i to n，递归，因为数没有重复，用一个set来判断是不是已经用了

- [47](https://leetcode.com/problems/permutations-ii/discuss/?currentPage=1&orderBy=most_votes&query=)  [全排列 II](PermutationII.java)
    - 记录下前序的list，以及已经用过的下标集合，因为是有重合的，对数排个需，这样如果上一个list的值和下一个相同，那么就可以skip这个list。