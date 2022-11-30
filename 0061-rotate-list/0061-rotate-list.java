class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        // (k-n)th node
        ListNode KMinusNthNode = null, KMinusNthNodePrev = null, currentNode = head, firstNode = head;
        
        // get N
        int n = 0;
        while (currentNode != null) {
            currentNode = currentNode.next;
            n++;
        }
        System.out.println(n);
        k = k%n;
        if (k == 0) return head;
        
        // get n-k the node and last node
        currentNode = head;
        int count = 1;
        while (currentNode != null && currentNode.next != null) {
            if (count == n-k) KMinusNthNodePrev = currentNode;
            count++;
            currentNode = currentNode.next;
        }
        
        
        ListNode lastNode = currentNode;
        KMinusNthNode = KMinusNthNodePrev.next;
        
        System.out.println(KMinusNthNode.val);
        
        KMinusNthNodePrev.next = null;
        lastNode.next = firstNode;
        return KMinusNthNode;
    }
}