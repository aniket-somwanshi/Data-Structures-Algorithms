
class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        if(head==NULL || k < 2 || head->next == NULL) return head;
        ListNode* node = head;
        int cnt = 0;
        while(node){
            cnt++;
            node = node->next;
        }
        ListNode *prev, *tail1, *newHead = NULL;
        ListNode* next = head;
        ListNode* tail2 = head;
        ListNode* current = head;
        while(cnt >= k){
            for(int i = 0; i < k; i++){
                next = current->next;
                current->next = prev;
                prev = current;
                current = next;   
            }
            if(newHead == NULL) newHead = prev;
            if(tail1) tail1->next = prev;
            tail2->next = current;
            tail1 = tail2;
            tail2 = current;
            prev = NULL;
            cnt = cnt - k;
           

        }
        return newHead;
    }
    
};