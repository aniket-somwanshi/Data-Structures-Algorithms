class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        
        ListNode firstHead = head;
        ListNode secondHead = head.next;
        
        ListNode first = firstHead;
        ListNode second = secondHead;
        
        while (first != null && second != null) {
            if (first.next == null) break;
            if (first.next.next == null) break;
            first.next = first.next.next;
            first = first.next;
            
            if (second.next == null) break;
            second.next = second.next.next;
            second = second.next;
        }
        
        first.next = secondHead;
        return firstHead;
    }
}