//Reverse a singly linked list.
//
// Example:
//
//
//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL
//
//
// Follow up:
//
// A linked list can be reversed either iteratively or recursively. Could you im
//plement both?
// Related Topics Linked List
// 👍 6340 👎 122


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
    public ListNode reverseList(ListNode head) {

        ListNode current = head;

        if (current == null) {
            return null;
        }

        ListNode next=current.next;

        current.next = null;

        while (next !=null) {

            ListNode tmp = next.next;

            next.next = current;

            current = next;

            next = tmp;
        }

        return current;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
