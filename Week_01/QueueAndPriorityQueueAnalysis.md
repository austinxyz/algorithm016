
### Source Code Analysis

#### [Queue](http://fuseyism.com/classpath/doc/java/util/Queue-source.html)

- 是一个interface 有多种实现 
- 继承了Collection interface
- 以下是主要方法

|方法名|作用|返回值|异常|补充说明|
|-----|---|------|----|------|
|add|增加一个值到Queue中|如果添加成功返回true|超过容量，元素类型不对，空指针，非法参数||
|offer|增加一个值到Queue中|如果添加成功返回true|元素类型不对，空指针，非法参数|对于有容量限制的Queue，倾向于使用offer，因为超过容量不会抛出异常，只是返回false|
|remove|获得和移除队列顶部元素|返回元素|NoSuchElementException （队列为空）||
|poll|获得和移除队列顶部元素|返回元素，如果没有元素返回null|||
|element|获得但不移除顶部元素|返回元素|NoSuchElementException （队列为空）||
|peek|获得但不移除顶部元素|返回元素，如果没有元素返回null|||

#### [Priority Queue](http://fuseyism.com/classpath/doc/java/util/PriorityQueue-source.html)

- 继承了AbstractQueue类，AbstractQueue实现了Queue interface
- 实现了Serialziable interface，所以是可以序列化和反序列化
- 默认容量为11
- used 记录队列实际使用长度
- storage 数组是存放实际的element的
- 包含一个比较器 Comparator
- 构造函数
    1. PriorityQueue的构造函数可以传入Collection，可以是SortedSet或者PriorityQueue，容量是原来的1.1倍，或者为1（如果为空的情况）
        * SortedSet - Comparator是SortedSet的比较器，将所有元素除null之外存在storage数组中
        * PriorityQueue - Comparator是PriorityQueue的比较器，将传入PriorityQueue的storage数组做一个arraycopy复制到当前storage数组中
    2. 构造函数只传入容量
    3. 构造函数传入容量和比较器
    4. 构造函数传入PriorityQueue，调用构造函数3，然后arraycopy
    5. 构造函数传入SortedSet，调用构造函数3，将所有元素除null之外存在storage数组中
- clear 清除整个queue，storage所有元素为null，used为0
- iterator 从头iterate到used
- offer 如果插入元素为空，返回NPE，从-1开始找到第一个null的slot，将这个slot赋为插入只，used加一，调用bubbleUp保证priority正确 （用比较器父的大于子）
- peek 如果为空，返回null，不然返回第一个元素
- poll 如果为空，返回null，不然将第一个元素返回，并调用remove（0）
- remove
    1. object，找到object对应的index，然后掉remove（index），找的话返回true
    2. index， 找到index的子（2*index+1，和2*index+2），如果子为null，那么不处理，否则将比较器比较大的那个来替代当前删除的，然后继续找子的子来替代子的位置，直到长处大于used，将used-1
- size 返回used
- addAll 传入一个Collection，将每个元素放到正确的位置-类似offer的逻辑，至少插入一个返回
- bubbleUp(index)，保证子和父的比较器关系正确，不然父子互换
- findSlot - 如果容量不够了，先resize，从开始往下找，找到第一个null的slot返回。 
- resize 建一个新的数组长度加倍，将老数组array copy，然后新数组为当前storage数组
