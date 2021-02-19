//Given the head of a linked list, rotate the list to the right by k places.
//
//
// Example 1:
//
//
//Input: head = [1,2,3,4,5], k = 2
//Output: [4,5,1,2,3]
//
//
// Example 2:
//
//
//Input: head = [0,1,2], k = 4
//Output: [2,0,1]
//
//
//
// Constraints:
//
//
// The number of nodes in the list is in the range [0, 500].
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 109
//
// Related Topics Linked List Two Pointers
// 👍 2087 👎 1127


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
/*
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        if (k == 0) {
            return head;
        }

        ListNode current = head;
        ListNode prev = null;

        int index = 0;

        while (current!=null) {
            prev = current;
            current = current.next;
            index++;
        }

        current = head;
        int length = index;

        if (prev !=null) {
            prev.next = head;
        }

        index = 0;

        while (index < length - k % length -1) {
            prev = current;
            current = current.next;
            index++;
        }

        if (current !=null) {
            head = current.next;
            current.next = null;
        }

        return head;

    }
*/


    public ListNode rotateRight(ListNode head, int k) {

        ListNode curr = head;

        if (curr == null) {
            return head;
        }

        int size = 1;

        while (curr.next!=null) {
            curr = curr.next;
            size++;
        }

        curr.next = head;

        int steps = size - k % size;

        ListNode prev = null;
        curr = head;
        int index = 0;

        while (curr!=null && index<steps) {
            prev = curr;
            curr= curr.next;
            index++;
        }

        prev.next = null;

        return curr;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
