class Solution {
public:
int widthOfBinaryTree(TreeNode* root) {

    queue<pair<TreeNode*,long long>> q;
    
    long long ans=0;
    
    q.push({root,0});
    
    while(!q.empty())
    {
        long long mi1=0,mx1=0;
        long long s=q.size();
        
        long long t=q.front().second;
        for(long long i=0;i<s;i++)
        {
            TreeNode* p=q.front().first;
            long long w=q.front().second-t;
            q.pop();
            
            if(i==0)
                mi1=w;
            
            if(i==s-1)
                mx1=w;
            
            if(p->left)
            {
                q.push({p->left,2*w+1});
            }
            
            if(p->right)
            {
                q.push({p->right,2*w+2});
            }
        }
        
        ans=max(ans,mx1-mi1+1);
    }
    
    return ans;
}
};