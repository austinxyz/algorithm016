//Design your implementation of the circular double-ended queue (deque).
//
// Your implementation should support following operations:
//
//
// MyCircularDeque(k): Constructor, set the size of the deque to be k.
// insertFront(): Adds an item at the front of Deque. Return true if the operati
//on is successful.
// insertLast(): Adds an item at the rear of Deque. Return true if the operation
// is successful.
// deleteFront(): Deletes an item from the front of Deque. Return true if the op
//eration is successful.
// deleteLast(): Deletes an item from the rear of Deque. Return true if the oper
//ation is successful.
// getFront(): Gets the front item from the Deque. If the deque is empty, return
// -1.
// getRear(): Gets the last item from Deque. If the deque is empty, return -1.
// isEmpty(): Checks whether Deque is empty or not.
// isFull(): Checks whether Deque is full or not.
//
//
//
//
// Example:
//
//
//MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be
//3
//circularDeque.insertLast(1);			// return true
//circularDeque.insertLast(2);			// return true
//circularDeque.insertFront(3);			// return true
//circularDeque.insertFront(4);			// return false, the queue is full
//circularDeque.getRear();  			// return 2
//circularDeque.isFull();				// return true
//circularDeque.deleteLast();			// return true
//circularDeque.insertFront(4);			// return true
//circularDeque.getFront();			// return 4
//
//
//
//
// Note:
//
//
// All values will be in the range of [0, 1000].
// The number of operations will be in the range of [1, 1000].
// Please do not use the built-in Deque library.
//
// Related Topics Design Queue
// 👍 279 👎 41


//leetcode submit region begin(Prohibit modification and deletion)
class MyCircularDeque {

    int[] deque = null ;
    int head = 0;
    int tail = 0;
    int usedSize = 0;
    int size = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        deque = new int[k];
        size = k;
        tail = size -1;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (usedSize == size) {
            return false;
        }

        if (head == 0) {
            head = size-1;
        } else {
            head--;
        }

        deque[head] = value;
        usedSize++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (usedSize == size) {
            return false;
        }

        if (tail == size-1 ) {
            tail = 0;
        } else {
            tail++;
        }

        deque[tail] = value;
        usedSize++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (usedSize == 0) {
            return false;
        }

        if (head == size-1) {
            head = 0;
        } else {
            head++;
        }

        usedSize--;
        return true;

    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {

        if (usedSize == 0) {
            return false;
        }

        if (tail == 0) {
            tail = size -1;
        } else {
            tail--;
        }

        usedSize--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (usedSize == 0) {
            return -1;
        }

        return deque[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {

        if (usedSize == 0) {
            return -1;
        }

        return deque[tail];

    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return usedSize == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return usedSize == size;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)
