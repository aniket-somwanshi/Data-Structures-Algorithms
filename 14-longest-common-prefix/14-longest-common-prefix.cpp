class Solution {
public:
    string longestCommonPrefix(vector<string>& a) {
        int position = 0;
        string res = "";
        char current;
        if (a.size() == 1) return a[0];
        if (a[0] == "") return "";
        while (1) {
            if (position < a[0].size()) current = a[0][position];
            else break;
            char current = a[0][position];
            for (int i = 0; i < a.size(); i++) {
                   if (position >= a[i].size() || current != a[i][position]) {
                       return res;
                   }
            }
            res += current;
            position++;
        }
        return res;
    }
};