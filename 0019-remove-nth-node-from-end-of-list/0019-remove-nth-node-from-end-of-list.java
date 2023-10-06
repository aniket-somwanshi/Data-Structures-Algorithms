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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode current = preHead;
        
        while (n-- > 0) {
            current = current.next;
        }
        
        ListNode slower = preHead;
        
        while (current.next != null) {
            current = current.next;
            slower = slower.next;
        }
        
        // delete slower's next
        slower.next = slower.next.next;
        
        return preHead.next;
    }
}