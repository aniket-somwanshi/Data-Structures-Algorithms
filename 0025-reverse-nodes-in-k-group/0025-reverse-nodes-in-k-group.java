class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode groupPrev = dummy;
        
        while (true) {
            // get kth node of this group
            ListNode kthNode = getKthNode(groupPrev, k);
            
            // if the group is less than size k, 
            // kthNode will be null
            // we can't reverse this group
            if (kthNode == null) break;
            
            // start of next group will be next of this
            ListNode nextGroup = kthNode.next;
            
            /// reverse the group
            // the first node of the group,
            // which will later be the last node of the group
            // should then point to the next Group's first node
            ListNode prev = kthNode.next;
            
            // start reversing from the start of the group
            // which is groupPrev's next
            ListNode current = groupPrev.next;
            
            // reverse normally as we do
            // k times so, until current reaches nextGroup
            while (current != nextGroup) {
                ListNode temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
            }
            
            // previous group that we reversed, it's last element
            // should point to the first element of the "reversed" current List
            // and now that we have reversed current list, we have that node as Kth
            // because before reversing it was kth, so after reversing it has become 1st
            // so assign it to prevGroup's next
            ListNode nextNodeOfGroupPrev = groupPrev.next; // store the next node
            groupPrev.next = kthNode;
            
            // for the next iteration, we need to set proper value to groupPrev
            groupPrev = nextNodeOfGroupPrev;
        }
        return dummy.next;
    }
    
    private ListNode getKthNode(ListNode node, int k) {
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }
}