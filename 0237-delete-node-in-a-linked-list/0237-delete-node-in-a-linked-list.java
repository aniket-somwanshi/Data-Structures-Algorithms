/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode head = node;
        ListNode secondLastNode = null;
        while (node.next != null) {
            // swap values of node and node.next
            int temp = node.val;
            node.val = node.next.val;
            node.next.val = temp;
            
            if (node.next != null && node.next.next == null) {
                secondLastNode = node;
            }
            node = node.next;
            
        }
        // delete the last node
        secondLastNode.next = null;
    }
}