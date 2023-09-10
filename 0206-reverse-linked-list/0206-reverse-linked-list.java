// true recursive 
class Solution {
    public ListNode reverseList(ListNode current) {
        if (current == null) return null;
        
        // if this is actually the last one in the original list then
        // this will be our `lastReversedHead` which we should return ultimately
        ListNode lastReversedHead = current; 
        
        // if this is not the last node to be reversed, then
        // we first recurse to the last, get `lastReversedHead` assigned 
        //to the last node, and then reverse it
        if (current.next != null) {
            lastReversedHead = reverseList(current.next);
            current.next.next = current; // reversed list's head should point to the current 
        }
        current.next = null; 
        return lastReversedHead;
    }
}

// // recursive 
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         return head == null ? null : f(head, null);
//     }
    
//     private ListNode f(ListNode current, ListNode prev) {
//         ListNode nextNode = current.next;
//         current.next = prev;
//         prev = current;
//         current = nextNode;
//         return current == null ? prev : f(current, prev);
//     }
// }

// // iterative 
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         ListNode current = head;
//         ListNode prev = null;
//         while (current != null) {
//             ListNode nextNode = current.next;
//             current.next = prev;
//             prev = current;
//             current = nextNode;
//         }
        
//         return prev;
//     }
// }