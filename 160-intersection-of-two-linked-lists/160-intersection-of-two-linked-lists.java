/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // O(N), O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode l1 = headA;
        ListNode l2 = headB;
        
        while (l1 != null && l2 != null) {
            l1 = l1.next;
            l2 = l2.next;
        }
        
        if (l1 == null) {
            while (l2 != null) {
                headB = headB.next;
                l2 = l2.next;
            }
        }
        else if (l2 == null) {
            while (l1 != null) {
                headA = headA.next;
                l1 = l1.next;
            }
        }

        while (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        } 
        
        if (headA == null || headB == null) return null;
        return headA; // or headB;
    }
}