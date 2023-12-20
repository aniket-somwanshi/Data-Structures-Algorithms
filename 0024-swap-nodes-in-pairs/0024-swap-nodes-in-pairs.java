class Solution {
    public ListNode swapPairs(ListNode node) {
        if (node == null) return null;
        
        if (node.next == null) return node;
        
        ListNode nextNode = node.next;
        ListNode nextNextNode = nextNode.next;
        
        nextNode.next = node;
        node.next = swapPairs(nextNextNode);
        
        return nextNode;
    }
}