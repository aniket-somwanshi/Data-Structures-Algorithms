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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode preHead = new ListNode();
        ListNode res = preHead;
        
        while (true) {
            // find the smallest donny
            int smallestIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && (smallestIndex == -1 || lists[i].val < lists[smallestIndex].val)) {
                    smallestIndex = i;
                }
            }
            if (smallestIndex == -1) {
                // means there is legit no one left
                break;
            }
            res.next = lists[smallestIndex];
            lists[smallestIndex] = lists[smallestIndex].next;
            res = res.next;
        }
        
        return preHead.next;
    }
}