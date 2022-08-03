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
    // O(N) O(1)
    // find middle
    // reverse the second half
    // compare first and second half 
    // if all equal, return true else false
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;
        ListNode prevMid = head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            prevMid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode firstStart = head;
        ListNode secondStart = slow;
        prevMid.next = null;
        
        
        // if odd length then middle element doesn't need to be compared
        if (fast != null && fast.next == null) secondStart = secondStart.next;
        
        // reverse second half
        secondStart = reverse(secondStart);
        
        // comapre first and second
        while (firstStart != null && secondStart != null) {
            //System.out.println(firstStart.val + " " + secondStart.val);
            if (firstStart.val != secondStart.val) return false;
            firstStart = firstStart.next;
            secondStart = secondStart.next;
        }
        return true;
        
    }
    
    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode nextNode = node;
        while (nextNode != null) {
            ListNode current = nextNode;
            nextNode = current.next;
            current.next = prev;
            prev = current;
        }
        return prev;
    }
    
    //O(N), O(N)
//     public boolean isPalindrome(ListNode head) {
//         Stack<ListNode> st = new Stack<ListNode>();    
//         ListNode curr = head;
//         while (curr != null) {
//             st.push(curr);
//             curr = curr.next;
//         }
        
//         curr = head;
        
//         // while (!st.empty()) {
//         //     System.out.println(st.pop());
//         // }
        
//         while (!st.empty()) {
//             if (curr.val != st.pop().val) return false;
//             curr = curr.next;
//         }
        
//         return true;
//     }
}