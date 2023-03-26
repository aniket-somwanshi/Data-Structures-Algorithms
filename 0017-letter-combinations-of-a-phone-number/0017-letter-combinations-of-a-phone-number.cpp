#define add push_back
class Solution {
public:
    vector<string> letterCombinations(string d) {
        vector<string> res;
        string s="";
        int n = d.size();
        vector<string> set;
        for(int i = 0; i<n; i++){
            if(d[i]=='2'){
                set.add("abc");
            }
            if(d[i]=='3'){
                set.add("def");
            }
            if(d[i]=='4'){
                set.add("ghi");
            }
            if(d[i]=='5'){
                set.add("jkl");
            }
            if(d[i]=='6'){
                set.add("mno");
            }
            if(d[i]=='7'){
                set.add("pqrs");
            }
            if(d[i]=='8'){
                set.add("tuv");
            }
            if(d[i]=='9'){
                set.add("wxyz");
            }
        }
        
        if(d=="") return res;
        gen(0, s, set, res, n);
        return res;
        
    }
    
    void gen(int set_number, string s, vector<string> set, vector<string> &res, int n){
 
        if(s.size() == n){
            res.push_back(s);
        }
        else{
            
            // for(int i = set_number; i<n; i++){
                
                for(int j = 0; j < set[set_number].size(); j++){
                    
                    
                    // if(set_number != )
                    s += set[set_number][j];
                    gen(set_number+1, s, set, res, n);
                    s.pop_back();
                    
                    
                }
                
            // }
            
        }
    }
};