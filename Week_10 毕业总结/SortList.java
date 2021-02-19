//Given the head of a linked list, return the list after sorting it in ascending
// order.
//
// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.
//e. constant space)?
//
//
// Example 1:
//
//
//Input: head = [4,2,1,3]
//Output: [1,2,3,4]
//
//
// Example 2:
//
//
//Input: head = [-1,5,3,4,0]
//Output: [-1,0,3,4,5]
//
//
// Example 3:
//
//
//Input: head = []
//Output: []
//
//
//
// Constraints:
//
//
// The number of nodes in the list is in the range [0, 5 * 104].
// -105 <= Node.val <= 105
//
// Related Topics Linked List Sort
// 👍 3880 👎 167


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

    public ListNode sortList(ListNode head) {

        ListNode top = new ListNode();
        top.next = head;

        quickSort(top, null);

        return top.next;

        //return quickSort(head);

    }

/*
    private ListNode quickSort(ListNode head) {

        if(head == null || head.next == null) return head;

        int pivot = head.val;
        // 链表划分
        ListNode ls = new ListNode(-1), rs = new ListNode(-1);
        ListNode l = ls, r = rs, cur = head;

        while(cur != null){
            if(cur.val < pivot){
                l.next = cur;
                l = l.next;
            }else{
                r.next = cur;
                r = r.next;
            }
            cur = cur.next;
        }
        l.next = rs.next;
        r.next = null;

        // 递归调用,先重排右边的,再把指针置空,再重排左边的
        // 和归并排序很像的
        ListNode right = quickSort(head.next);
        head.next = null;
        ListNode left = quickSort(ls.next);

        // 拼接左半部分和右半部分
        cur = left;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = right;
        return left;

    }
*/

    private void quickSort(ListNode top, ListNode end) {

        ListNode pilot = top.next;

        if (pilot == null || pilot == end) {
            return;
        }

        ListNode curr = pilot.next;
        ListNode prev = pilot;

        while(curr != end && curr!=null) {

            ListNode next = curr.next;

            if (curr.val < pilot.val) {
                ListNode tmp = top.next;

                top.next = curr;

                curr.next = tmp;

                prev.next = next;

                curr = next;

            } else {
                prev = curr;
                curr = next;
            }
        }

        quickSort(top, pilot);
        quickSort(pilot, end);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
