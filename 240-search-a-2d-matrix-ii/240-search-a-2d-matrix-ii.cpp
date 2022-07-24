class Solution {
public:
    bool searchMatrix(vector<vector<int>>& a, int t) {
          int r = a.size();
    int c = a[0].size();
    
    int i=0,j=c-1;
    while(1){
        if(i>r-1 || j<0){
            return false;
        }
        if(a[i][j] == t){
            return true;
        }
        else if(a[i][j] > t){
            j--;
            continue;
        }
        else if(a[i][j] < t){
            i++;
            continue;
        }
    }
    }
};