## [HashMap](http://hg.openjdk.java.net/jdk8/jdk8/jdk/file/687fd7c7986d/src/share/classes/java/util/HashMap.java)

- 保存一个table 数组，元素是HashEntry，HashEntry保存了key和value

### V get （key）

- hash方法根据key找到hash的高16位
    - hash（key），key的hashCode 高16为参与运算
- 取出table中hash相同的，如果有一个匹配的first，判断first是红黑树，还是循环链表，调用不同的方法，找到key值相同的返回，否则返回null

### put （key， value）
- hash方法根据key找到hash的高16位
    - hash（key），key的hashCode 高16为参与运算
- 如果table为空，那么要resize
- 确定table中的index位置，如果有对应index有值（hash碰撞），如果key相同，那么需要覆盖，否则需要插入，如果是红黑树，put到红黑树，如果是链表，加到尾部，如果超过阈值，需要转化给红黑树。如果在链表中存在该节点，需要替换值。
    - 容量+1，如果超过容量，需要扩容。
    - 扩容，capacity *2， 然后把原数据copy到新的数组，下标可能会有变化。

### remove （key）
- hash方法根据key找到hash的高16位
    - hash（key），key的hashCode 高16为参与运算
- table不为空，找到first node，如果first node的key为输入key，那么就是它，不然根据是红黑树或者链表，遍历找到对应key的node
    - 删除这个node，根据红黑树或者链表做相应的处理，需要缩容

