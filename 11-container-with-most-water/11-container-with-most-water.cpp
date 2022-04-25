class Solution {
public:
    int maxArea(vector<int>& a) {
        int l = 0;
        int r = a.size()-1;
        int maxi = INT_MIN;
        while(l <= r){
            maxi = max(maxi, (r - l ) * min(a[l], a[r]) );
            if(a[l] <= a[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return maxi;
    }
};