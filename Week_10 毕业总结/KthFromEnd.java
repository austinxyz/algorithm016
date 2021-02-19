/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {

        int index = 0;

        ListNode curr = head;

        int length = 0;

        while (curr !=null) {
            curr = curr.next;
            length++;
        }

        curr = head;

        while (curr !=null && index <length - k) {
            curr = curr.next;
            index++;
        }

        return curr;

    }
}