// O(2NlogN) O(N) -- N = all the nodes 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        
        for (ListNode node: lists) {
            while (node != null) {
                pq.add(node);
                node = node.next;
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (!pq.isEmpty()) {
            current.next = pq.poll();
            current = current.next;
        }
        current.next = null;
        return dummy.next;
    }
}