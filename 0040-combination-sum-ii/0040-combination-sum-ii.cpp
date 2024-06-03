class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& a, int target) {
        vector<vector<int>> res;
        vector<int> subset;
        sort(a.begin(), a.end());
        recur(0, res, subset, target, a);
        return res;
    }
    
    void recur(int begin, vector<vector<int>> &res, vector<int> &subset, int target,  vector<int> &a){
        if(target == 0){
            res.push_back(subset);
            return;
        }
        if(target < 0) return;
        for(int i = begin; i < a.size(); i++){
            if(i != begin && a[i] == a[i-1]){
                cout<<" "<<a[i];
                continue;
            }
            subset.push_back(a[i]);
            recur(i + 1, res, subset, target - a[i], a);
            subset.pop_back();
        }
     }
    
//     vector<vector<int>> combinationSum2(vector<int>& nums, int t) {
//         int sum = 0;
            
//         int n = nums.size();
        
//         sort(nums.begin(), nums.end());
        
//         vector<vector<int>> res;
//         vector<int> subset;
//         int used[n];
       
//         for(int i = 0; i<n; i++){           
//             used[i] = 0;
//         }
        
//         // for(int i = 0; i<n;i++){
//         //      subset.push_back(0);
//         // }
        
//         combine(0, nums, subset, res, n, t,0, -1); 

//         return res;
  
//     }
    
    
       void combine(int index, vector<int> nums, vector<int> subset, vector<vector<int>> &res, int n, int t, int sum, int selected){        
        int i;
        int iteration_selected =-1;
        // int selected = -1;
        if(t - sum == 0){
            res.push_back(subset);
        }
        else if(sum > t){
            // dont recurse further
        }
        else{ // sum > 0
            for(i= selected+1; i<n; i++){       
                // if(used[i] == 0){
                    if(iteration_selected!=-1){
                        if(nums[i] == nums[iteration_selected]){
                            continue;
                        }
                    }
                    // selected = i;
                    iteration_selected = i;
                    selected = i;
                    subset.push_back(nums[i]);
                    sum += nums[i];
                    // used[i] = 1;
                    combine(index + 1, nums, subset, res, n, t, sum, selected);
                    // used[i]=0;
                    sum -= nums[i];
                    subset.pop_back();
            }
            
        }
        
    }
};