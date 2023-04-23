class Solution {
public:
    int threeSumClosest(vector<int>& a, int target) {
    sort(a.begin(), a.end());     int res = a[0] + a[1] + a[a.size()-1];
        
        for(int i = 0; i < a.size()-2; i++){
            int j = i+1;
            int k = a.size()-1;
            int sum = 0;
            while(j < k){
                sum = a[i] + a[j] + a[k];
                if(sum > target){
                    k--;
                }
                else{
                    j++;
                }
                if(abs(target - sum) < abs(res-target)) res = sum;
             }
            
        }
        return res;
    }
};