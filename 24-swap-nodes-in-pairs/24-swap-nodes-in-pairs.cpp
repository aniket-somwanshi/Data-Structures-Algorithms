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
    ListNode* swapPairs(ListNode* head) {
        if(head == NULL) return NULL;
        if(head->next == NULL) return head;
        
        ListNode* prev = head;
        ListNode* jump = head->next;
        ListNode* res = jump;
        ListNode* next_jump = NULL;
        ListNode* next_prev = NULL;
        
        
        while(jump!=NULL){
            
            if(jump->next != NULL){
                
                if(jump->next->next != NULL){
                    next_jump = jump->next->next;   
                } 
                else{
                    next_jump = jump->next;  
                }
               
            }
            else {
                next_jump = NULL;
            }
            
            // 
            next_prev = jump->next;
            jump->next = prev;
            prev->next = next_jump;
            jump = next_jump;
            prev = next_prev;
            
        }
        
        
        return res;
    }
};