//Merge two sorted linked lists and return it as a new sorted list. The new list
// should be made by splicing together the nodes of the first two lists.
//
// Example:
//
//
//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4
//
// Related Topics Linked List
// 👍 4838 👎 624


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

//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//
//        if (l1==null) {
//            return l2;
//        }
//
//        if (l2 == null) {
//            return l1;
//        }
//
//        if (l1.val > l2.val) {
//            l2.next = mergeTwoLists(l1, l2.next);
//
//            return l2;
//        } else {
//            l1.next = mergeTwoLists(l1.next, l2);
//
//            return l1;
//        }
//
//    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();

        ListNode curr = head;

        while(l1!=null && l2!=null) {

            if (l1.val > l2.val) {
                curr.next = l2;
                l2 = l2.next;
            } else {
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }

        if (l1 == null) {
            curr.next = l2;
        }

        if (l2 == null) {
            curr.next = l1;
        }

        return head.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
