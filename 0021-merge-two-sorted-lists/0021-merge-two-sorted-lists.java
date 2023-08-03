// O(N) O(1)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode();
        ListNode res = preHead;
        
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                res.next = list1;
                res = res.next;
                list1 = list1.next;
            }
            else {
                res.next = list2;
                res = res.next;
                list2 = list2.next;
            }
        }
        
        if (list1 != null) res.next = list1;
        if (list2 != null) res.next = list2;
        
        return preHead.next;
    }
}