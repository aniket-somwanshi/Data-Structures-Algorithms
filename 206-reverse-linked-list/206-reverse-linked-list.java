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
    // O(N)
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = head;
        while (next != null) {
            ListNode current = next;
            next = current.next;
            current.next = prev;
            prev = current;
        }
        return prev;
    }
}