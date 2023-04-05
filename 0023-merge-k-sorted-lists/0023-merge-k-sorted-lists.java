// O(klogN) O(1) -- N = all the nodes overall
// divide and conquer(merge)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) return null;
        int interval = 1;
        while (interval < n) {
            for (int i = 0; i + interval < n; i= i + interval*2) {
                lists[i] = merge2Lists(lists[i], lists[i+interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }
    
    private ListNode merge2Lists(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                current.next = node1;
                current = current.next;
                node1 = node1.next;
            }
            else {
                current.next = node2;
                current = current.next;
                node2 = node2.next;
            }
        }
        
        if (node1 == null) current.next = node2;
        if (node2 == null) current.next = node1;
        
        return dummy.next;
    }
}


// // O(2NlogN) O(N) -- N = all the nodes overall
// Heap solution
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        
//         for (ListNode node: lists) {
//             while (node != null) {
//                 pq.add(node);
//                 node = node.next;
//             }
//         }
        
//         ListNode dummy = new ListNode(-1);
//         ListNode current = dummy;
//         while (!pq.isEmpty()) {
//             current.next = pq.poll();
//             current = current.next;
//         }
//         current.next = null;
//         return dummy.next;
//     }
// }