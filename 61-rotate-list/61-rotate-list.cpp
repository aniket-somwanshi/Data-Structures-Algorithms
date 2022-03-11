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
    ListNode* rotateRight(ListNode* head, int k) {
        
        if(head == NULL) return NULL;
        if(head->next == NULL) return head;
        if(k == 0) return head;
        
        ListNode* OGSTART = head;
        ListNode* NEWSTART = NULL;
        ListNode* OGEND = NULL;
        ListNode* dummy = head;
        
        // calculate length and store last
        int length = 1;
        while(head->next != NULL){
            head=head->next;
            length++;
        }
        // cout<<head->val<<endl;
        // cout<<length<<endl;
        OGEND = head;
        
        k = k % length;
        if(k == 0) return dummy;
        int GOLDEN = length - k;
        cout<<GOLDEN;
        int cnt = 0;
        head = dummy;
        // cout<<head->val;
        while(++cnt != GOLDEN){
            head = head->next;
        }
        NEWSTART = head->next;
        head->next = NULL;
        OGEND->next = dummy;
        // cout<<head->val;
        
        return NEWSTART;
    }
};