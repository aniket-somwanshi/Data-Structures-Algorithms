// O(NlogN) O(N) merge sort baby
class Solution {
    public ListNode sortList(ListNode node) {
        if (node == null) return null;
        if (node.next == null) return node;
            
        // divide
        ListNode midNode = getMid(node);
        
        ListNode firstUnsorted = node;
        ListNode secondUnsorted = midNode.next;
        
        // break the link
        midNode.next = null;
        
        // further divide them 
        ListNode first = sortList(firstUnsorted);
        ListNode second = sortList(secondUnsorted);
        
        // merge the 2 sorted donnies
        return getSortedList(first, second);
    }
    
    // O(N+M) O(1)
    private ListNode getSortedList(ListNode first, ListNode second) {
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;
        
        while (first != null && second != null) {
            if (first.val < second.val) {
                current.next = first;
                first = first.next;
            }
            else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }
        
        while (first != null) {
            current.next = first;
            first = first.next;
            current = current.next;
        }
        
        while (second != null) {
            current.next = second;
            second = second.next;
            current = current.next;
        }
        
        return dummyHead.next;
    }
    
    private ListNode getMid(ListNode node) {
        // if there are only 2 donnies, return first one
        if (node.next.next == null) return node;
        
        // when fast pointer reaches the end, slow pointer will reach the mid
        ListNode fast = node.next;
        ListNode slow = node;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}