class Solution {
public:
    
    bool bs(vector<int> a, int target, int start, int end){
        int mid = start + (end - start)/2;
        if(start > end) return false;
        if(a[mid] == target) return true;
        
        bool w,x,y,z;
        x = y = z = w = false;
        
        if(a[mid] <= a[end]){
            // right half is sorted
            
            // check if target lies in right half
            if(target >= a[mid] && target <= a[end]){
                // bs in right half
                w = bs(a, target, mid+1, end);
            }
            else{
              // it must be in left half
                x = bs(a, target, start, mid-1);
            }
        }
        
        // left half is sorted
        if(a[mid] >= a[start]){
            // check if target lies in left half
            if(target >= a[start] && target <= a[mid]){
                // bs in left half
                y = bs(a, target, start, mid -1);
            }
            else{
                // it must be in right half
                z = bs(a, target, mid+1, end);
            }
        }
        
        return x or y or z or w;
        
    }
    
    bool search(vector<int>& a, int t) {
        return bs(a, t, 0, a.size()-1);
    }
};