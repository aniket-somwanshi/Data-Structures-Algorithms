/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        queue<TreeNode*> q;
         vector<vector<int>> res;
         vector<vector<int>> outer;
        if(root==NULL) return res;
        q.push(root);
       
        
        while(!q.empty()){
            vector<int> inner;
            int size = q.size();
            for(int i=0; i<size; i++){
                
                TreeNode* curr =(TreeNode*) q.front();
                q.pop();
                
                inner.push_back(curr->val);
                
                if(curr->left !=NULL){
                    q.push(curr->left);
                }
                if(curr->right !=NULL){
                    q.push(curr->right);
                }
            
            }
            outer.insert(outer.begin(), inner);
          
        
          
            
        }
          // <vector<vector<int>> res;
        // vector<vector<int>> res;
            // while(!outer.empty()){
            //     res.push_back(outer.back());
            //     outer.pop_back();
            // }
        return outer;
    }
};