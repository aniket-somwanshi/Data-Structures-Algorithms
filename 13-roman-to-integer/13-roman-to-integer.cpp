class Solution {
public:
    int romanToInt(string a) {
        int res = 0;
        a+=" ";
        for (int i = a.size()-1; i >=0; i--) {
            if (a[i] == 'I') {
                if (a[i+1] == 'V') {
                    res -= 1;
                }
                else if (a[i+1] == 'X') {
                    res -= 1;
                }
                else res += 1;
            }
            else if (a[i] == 'V') {
                res += 5;
            }
            else if (a[i] == 'X') {
                if (a[i+1] == 'L') {
                    res -= 10;
                }
                else if (a[i+1] == 'C') {
                    res -= 10;
                }
                else res += 10;
            }
            else if (a[i] == 'L') {
                res += 50;
            }
            else if (a[i] == 'C') {
               if (a[i+1] == 'D') {
                    res -= 100;
                }
                else if (a[i+1] == 'M') {
                    res -= 100;
                }
                else res += 100;
            }
            else if (a[i] == 'D') {
                res += 500;
            }
            else if (a[i] == 'M') {
                res += 1000;
            }
        }
        return res;
        
    }
};