class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        // sort(nums.begin(), nums.end());
        // for(int i=0; i<nums.size(); i++){
        //     if(nums[i] == nums[i+1])
        //         return nums[i];
        // }
       
//         long int n = nums.size() - 1;
//         long int a[n+2];
//         for(long int i=0; i<nums.size(); i++){
//             if(a[nums[i]] == 1){
//                 return nums[i];
//             }
//             else{
//                 a[nums[i]]=1;
//             }
                
//         }
        
        
        
        // totoise method
        int t=nums[0];
        int h= nums[0];
        
        do{
            t=nums[t];
            h =nums[nums[h]];
        }while(t!=h);
        
        t = nums[0];
        while(t!=h){
            t = nums[t];
            h = nums[h];
        }
        return t;
        
        
    }
};