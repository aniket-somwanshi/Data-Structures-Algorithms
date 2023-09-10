// recursive 
class Solution {
    public ListNode reverseList(ListNode head) {
        return head == null ? null : f(head, null);
    }
    
    private ListNode f(ListNode current, ListNode prev) {
        ListNode nextNode = current.next;
        current.next = prev;
        prev = current;
        current = nextNode;
        return current == null ? prev : f(current, prev);
    }
}

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