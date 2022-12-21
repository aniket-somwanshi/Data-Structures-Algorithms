//         return f(0,0);
//     }
//     private boolean f(int i, int j) {
//         if (j == m) {
//             int index = i;
//             while (index < n && s1[index] == '*') index++;
//             return index == n;
//         }
//         if (i == n) return j == m;
//         boolean res = false;
//         if (s1[i] == '*') {
//             if (f(i,j+1)) return memo[i][j] = true;
//             if (f(i+1, j)) return memo[i][j] = true;
//         }
//         else if (s1[i] == '?') {
//             res = res | f(i+1, j+1);
//         }
//         else {
//             res = res | s1[i] == s2[j] ? f(i+1, j+1) : false;
//         }
//         return memo[i][j] = res;
//     }
// }
```