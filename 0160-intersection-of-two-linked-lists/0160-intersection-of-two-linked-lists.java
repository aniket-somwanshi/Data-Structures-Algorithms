public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        
        // l2 should reach the end first
        while (l1 != null && l2 != null) {
            l1 = l1.next;
            l2 = l2.next;
        }
        
        ListNode l1New = headA;
        ListNode l2New = headB;
        
        if (l2 != null) {
            while (l2 != null) {
                l2 = l2.next;
                l2New = l2New.next;
            }
        }
        else {
            while (l1 != null) {
                l1 = l1.next;
                l1New = l1New.next;
            }
        }
    
        // now l1New and l2New are aligned 
        // return once they both point to the same node
        // if they both point to null, they are disconnected
        
        while (l1New != null && l2New != null) {
            if (l1New == l2New) return l1New;
            l1New = l1New.next;
            l2New = l2New.next;
        }
                
        return null;
    }
    
    private void swap(ListNode l1, ListNode l2) {
        ListNode temp = l1;
        l1 = l2;
        l2 = temp;
    }
}
