class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> subset;
        int n = nums.size();
        int used[n];
       
        sort(nums.begin(), nums.end());
        
        for(int i = 0; i<n; i++){
            subset.push_back(0);
            used[i] = 0;
        }
        
        permute(0, nums, used, subset, res, n);
        
        return res;
    }
    
    void permute(int index, vector<int> nums, int used[], vector<int> subset,
               vector<vector<int>> &res, int n  ){
        
        
        if(index >= n){
           
            res.push_back(subset);
        }
        else{
            
            int selected = -1;
            
            for(int i = 0; i<n; i++){
                
                
                
                // if(index>0 && nums[i]==subset[index-1]){
                //         continue;
                //     }
                // else{
                if(used[i] == 0){
                    if(selected >=0 && nums[i] == nums[selected]){
                        continue;
                    }
                    
                    selected = i;

                    subset[index] = nums[i];
                    used[i] = 1;
                    permute(index + 1, nums, used, subset, res, n);
                    used[i]=0;
                    }
                }
                }
                
            }
            
        
        
        
        
        
    
};