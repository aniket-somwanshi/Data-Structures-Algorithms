class Solution {
public:
    // approach 1 = O(n) space, n = number of strings 
//     string reverseWords(string a) {
//         vector<string> words;
//         int i = 0;
//         while(i < a.size()){
//             string word = "";
//             if(a[i] == ' '){
//                 while(i < a.size() && a[i] == ' '){
//                     i++;
//                 }
//             }
//             else{
//                 while(i < a.size() && a[i]!=' '){
//                     cout<<" i "<<i;
                    
//                     word += a[i];
//                     i++;
//                 }
//                 words.push_back(word);  
//             }
            
            
//         }
        
//         string res = "";
//         int j = words.size()-1;
//         for(j; j >= 1; j--){
//             res += words[j];
//             res += " ";
//         }
//         res += words[0];
        
//         return res;
//     }
    
    // approach 2: O(1) space 
     string reverseWords(string a) {
         // trim spaces from ends
         int i = 0;
         int leading_spaces = 0;
         while (i < a.size() && a[i] == ' ') {
             leading_spaces ++;
             i++;
         }
         if (leading_spaces > 0) a.erase(0, leading_spaces);
         // cout<<"["<<a<<"]";
         i = a.size() - 1;
         while (i >= 0 && a[i] == ' ') {
             a.erase(i, 1);
             i--;
         }
         i = a.size() - 1;
         int word_length = 0;
         while (i >= 0) {
             if (a[i] != ' ') {
                 word_length++;
                 i--;
             }
             else if (a[i] == ' ') {
                 a += a.substr(i + 1, word_length);
                 a += ' ';
                 a.erase(i + 1, word_length);
                 word_length = 0;
                 // remove spaces in between
                 while (i >= 0 && a[i] == ' ') {
                     a.erase(i, 1);
                     i--;
                 }
             }
         }
         a += a.substr(0, word_length);
         a.erase(0, word_length);
         return a;
    }
};