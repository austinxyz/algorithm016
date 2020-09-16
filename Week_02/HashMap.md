## [HashMap](http://fuseyism.com/classpath/doc/java/util/HashMap-source.html)

- 保存一个buckets 数组，元素是HashEntry，HashEntry保存了key和value

### V get （key）

- hash方法根据key找到index
    - hash（key），key的hashCode和buckets长度取模
- 根据index 取出buckets[index]的HashEntry，如果key和entry的key相等，那么返回value，不然根据entry的next指针找到下一个HashEntry，如果next为空，那么没找到，返回null

### put （key， value）
- hash方法根据key找到index
    - hash（key），key的hashCode和buckets长度取模
- 根据index，取出buckets[index]的HashEntry，那key的hashCode和HashEntry中的key的hashCode，以及key和key比较，如果相等，那么把这个HashEntry的value赋为新传入的value，返回 新的value。
- 如果没有找到HashEntry，那么我们需要插入一个新的Entry
    - 将Hash当前长度（modCount）加一，如果长度超过threshold，需要rehash，然后算出index，rehash过后index要出重新算
        - rehash，新的长度为老的长度 * 2 + 1， threshold = 长度* loadFactor （负载因子）
        - 遍历老的bucket中的每个元素，算出新的index，然后放在新的bucket中的对应的index位置，找到next，将next也做类似处理，放在新的位置（index根据hash方便变了） 
    - 通过addEntry（key，value，index，true）来加入新的entry
        建一个新的HashEntry，让它的next指向当前index位置的HashEntry，然后将当前位置的HashEntry改为这个新的entry

### remove （key）
- hash方法根据key找到index
    - hash（key），key的hashCode和buckets长度取模
- 根据index 取出buckets[index]的HashEntry
    - 根据HashEntry，如果key和entry的key相等，那么将这个entry删除，要修改链表的指针。
    - 否则返回null

