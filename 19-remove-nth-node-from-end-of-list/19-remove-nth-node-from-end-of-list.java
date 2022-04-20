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
    O(N) O(1) one pass
    1 - 2 - 3 - 4 - 5 
    k = 2
    move ptr to 2nd place
    1 - 2(ptr)- 3 - 4 - 5
    now increment ptr and ptr2 until ptr reaches end
    1 - 2 - 3(ptr2) - 4 - 5 - (ptr) 
    remove ptr2's next node
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        if (head.next == null && n == 1) return null;
        
        ListNode fast = new ListNode();
        ListNode slow = new ListNode();
        ListNode dummy = slow;
        dummy.next = head;
        fast.next = head;
        slow.next = head;
        
        
        while (n-- >= 0) {
            fast = fast.next;
        }
        
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // delete slow's next node
        // if slow is the last node, there is no next 
        // so just leave it 
        if (slow.next != null) {
            slow.next = slow.next.next;
        } 
        
        return dummy.next;
    }
}