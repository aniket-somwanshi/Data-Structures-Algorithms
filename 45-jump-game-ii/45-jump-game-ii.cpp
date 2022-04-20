class Solution {
public:
    int jump(vector<int>& a) {
        
        if(a.size()<=1) return 0;
        
        if(a.size()<=2){
            if(a[0] > 0) return 1;
            else return 0;
        }
        else{
            if(a[0] >= a.size()-1) return 1;
        }
        
        
        
        int new_posi = 0;
        int i = 1;
        int jump = 0;
        int curr_max = INT_MIN;
        int capacity = 0;
        
        
        while(new_posi <= a.size()-2){
            
            cout<<" "<<new_posi;
            
            curr_max = INT_MIN;
            
            
            i = new_posi + 1;
            capacity = a[new_posi];
            // jump++;
            
            int current_highest = new_posi + a[new_posi];
            
            if(current_highest >= a.size()-1){
                jump++;
                return jump;
            }
            
            while(capacity-- && i<=a.size()-1){
                if(a[i] + i >= curr_max){
                    curr_max = a[i] + i;
                    new_posi = i;
                }
                i++;
            }
            
            if(current_highest >= a[new_posi] + new_posi){
                new_posi = current_highest;
            }
            
            
            jump++;
            
        }
        return jump;
    }
};