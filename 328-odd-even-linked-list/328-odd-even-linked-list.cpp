/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* oddEvenList(ListNode* head) {
        if(head == NULL) return NULL;
        if(head ->next == NULL) return head;
        if(head->next->next  == NULL) return head;
        
        ListNode* odd = head;
        ListNode* even = head->next;
        ListNode* first_even = even;
        while(1){
            
            if(odd->next == NULL || odd->next->next == NULL){
                break;
            }
            
            odd->next = odd->next->next;
            even->next = even->next->next;
            
            odd = odd->next;
            even = even->next;
            
        }
        
        odd->next = first_even;
        
        return head;
    }
};