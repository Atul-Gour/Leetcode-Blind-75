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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        if (left == right || n <= 1)
            return head;
        ListNode prevHead = head;
        for (int i = 1; i < left - 1; i++) {
            prevHead = prevHead.next;
        }
        ListNode prev = prevHead.next;
        ListNode curr = prevHead.next.next;
        ListNode next = null;
        if (left == 1) {
            prev = prevHead;
            curr = prevHead.next;
        }
        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if (left == 1) {
            prevHead.next = curr;
            return prev;
        }
        prevHead.next.next = curr;
        prevHead.next = prev;
        return head;
    }
}