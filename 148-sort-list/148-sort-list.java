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
        if (head == null || head.next == null) return head;
            
        ListNode mid = getMid(head);
        ListNode leftHalf = sortList(head);
        ListNode rightHalf = sortList(mid);
        // merge the 2 halves
        ListNode merged = merge(leftHalf, rightHalf);
        return merged;
    }
    
    private ListNode getMid(ListNode head) {
        ListNode prevMid = null;
        while (head != null && head.next != null) {
            if (prevMid == null) prevMid = head;
            else prevMid = prevMid.next;
            
            head = head.next.next;
        }
        
        ListNode mid = prevMid.next;
        prevMid.next = null;
        return mid;
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
       
        if (l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode dummy = l1;
        
        while (l1 != null && l2 != null) {
            ListNode prev = null;
            while (l1 != null && l1.val <= l2.val) {
                prev = l1;
                l1 = l1.next;
            } 
            // now l2 must be smaller than l1 
            prev.next = l2;
            // swap l1 l2
            ListNode swapper = l1;
            l1 = l2;
            l2 = swapper;
        }
        return dummy;
    }
}