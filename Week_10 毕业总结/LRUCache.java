//Design a data structure that follows the constraints of a Least Recently Used
//(LRU) cache.
//
// Implement the LRUCache class:
//
//
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
//
// int get(int key) Return the value of the key if the key exists, otherwise ret
//urn -1.
// void put(int key, int value) Update the value of the key if the key exists. O
//therwise, add the key-value pair to the cache. If the number of keys exceeds the
// capacity from this operation, evict the least recently used key.
//
//
// Follow up:
//Could you do get and put in O(1) time complexity?
//
//
// Example 1:
//
//
//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//Explanation
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
//
//
//
// Constraints:
//
//
// 1 <= capacity <= 3000
// 0 <= key <= 3000
// 0 <= value <= 104
// At most 3 * 104 calls will be made to get and put.
//
// Related Topics Design
// 👍 7759 👎 316


//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    int capacity = 0;

    int size = 0;

    Map<Integer, Integer> maps = new HashMap<Integer, Integer>();

    List<Integer> queue = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        queue = new ArrayList<Integer>(capacity);
    }

    public int get(int key) {
        if (maps.containsKey(key)) {

            for (int i=0; i<size; i++) {
                if (queue.get(i) == key) {
                    queue.remove(i);
                    queue.add(key);
                    break;
                }
            }
            return maps.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {

        if (!maps.containsKey(key)) {
            if (size == capacity) {
                int oldkey = queue.get(0);
                queue.remove(0);
                maps.remove(oldkey);
                size--;
            }
            queue.add(key);
            size++;
        } else {
            for (int i=0; i<size; i++) {
                if (queue.get(i) == key) {
                    queue.remove(i);
                    queue.add(key);
                    break;
                }
            }
        }
        maps.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
