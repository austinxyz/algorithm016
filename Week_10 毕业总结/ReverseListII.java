//Reverse a linked list from position m to n. Do it in one-pass.
//
// Note: 1 ≤ m ≤ n ≤ length of list.
//
// Example:
//
//
//Input: 1->2->3->4->5->NULL, m = 2, n = 4
//Output: 1->4->3->2->5->NULL
//
// Related Topics Linked List
// 👍 3324 👎 169


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

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head==null || m==n) {
            return head;
        }

        ListNode top = new ListNode();
        top.next = head;

        ListNode prev = top;
        ListNode curr = top.next;

        int index = 1;

        while (curr!=null && index < m ) {
            prev = curr;
            curr = curr.next;

            index++;
        }

        prev.next = reverse (curr, n-m+1);

        return top.next;

    }

    private ListNode reverse(ListNode head, int n) {

        ListNode curr = head;
        ListNode prev = null;
        int index = 0;

        while (curr!=null && index < n) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
            index++;
        }

        if (curr!=null) {
            head.next = curr;
        }

        return prev;

    }

    /*
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (m==n) {
            return head;
        }

        int index =1;

        ListNode prev = null;

        ListNode current = head;

        ListNode tmp = null;

        while (index < m && current !=null) {
            prev=current;
            current = current.next;
            index++;
        }

        ListNode start = prev;
        ListNode tail = current;


        prev = null;

        while (current!= null && index<=n) {

            tmp = current.next;

            current.next = prev;

            prev = current;

            current = tmp;

            index++;
        }

        if (start !=null) {
            start.next = prev;
        } else {
            head = prev;
        }

        if (tail !=null) {
            tail.next = current;
        }


        return head;
    }
    */
}
//leetcode submit region end(Prohibit modification and deletion)
