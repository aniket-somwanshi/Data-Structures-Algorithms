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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        
        ListNode first = head;
        ListNode second = head.next;
        
        ListNode current = head;
        
        while (current != null) {
            ListNode nextNode = current.next;
            if (nextNode != null) current.next = nextNode.next;
            current = nextNode;
        }
        
        ListNode node = first;
        while (node.next != null) {
            node = node.next;
        }
        
        node.next = second;
        
        return first;
    }
}