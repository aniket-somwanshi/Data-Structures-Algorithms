class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& a) {
        vector<vector<int>> res;
        if(a.size() < 3) return res;
        sort(a.begin(), a.end());
        
        int i = 0, j = 1, k = a.size()-1;        
        while(i < a.size()-1){
            if(i != 0 && a[i] == a[i-1]){ 
                i++;
                continue;
            }
            j = i + 1;
            k = a.size() - 1;
            int req = 0 - a[i];
            while(j < k){
                if(j != i+1 && a[j] == a[j-1]) {
                    j++;
                    continue;
                }
                if(k != a.size()-1 && a[k] == a[k+1]) {
                    k--;
                    continue;
                }
                if( (a[j]+a[k]) < req){
                    j++;
                } 
                else if((a[j]+a[k]) > req){
                    k--;
                }
                else{
                    res.push_back({a[i], a[j], a[k]});
                    j++;
                    k--;
                }
            }
            i++;
        }
        return res;
        
    }
};