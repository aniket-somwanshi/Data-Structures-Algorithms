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
    // O(N), O(N), 
    // we can use stack or queue to get elements in reverse order
    // also hashmap can be used, we store node's prev node in hashmap 
    
    /*
    O(N), O(1)
    Observation 
    1-2-3-4-5-6-7-8
    the first half is printed as it is
    1- -2- -3- -4- -   
    and the second half is printed in reverse order
     -8- -7- -6- -5-
    result is connecting corresponding nodes from l1 and l2
    1-8-2-7-3-6-4-5-
    */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return; 
        if (head.next.next == null) return;
        
        // find the middle
        ListNode dummy = new ListNode();
        ListNode slow = head;
        ListNode fast = head;
        
        // start of l1
        ListNode l1 = head;
        
        ListNode l1_tail = null;
        
        while (fast != null && fast.next != null) {
            l1_tail = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
                
        // break l1's tails connection to l2
        l1_tail.next = null;
        
        // reverse l2
        ListNode l2 = reverse(slow);
        
        // merge the 2 lists
        merge(l1, l2);

    }
    
    public ListNode reverse(ListNode head) {
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
    
    public void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;
            
            l1.next = l2;
            
            if (l1_next == null) {
                break;
            }
            l2.next = l1_next;
            
            l1 = l1_next;
            l2 = l2_next;
            
            }
    }
    
}