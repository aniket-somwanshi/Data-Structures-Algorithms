class Solution {
public:
    // appriach: center of palindrome => O(n), O(1) 
    // pick every element as the center 
    // expand from center to go as further as we can
    string longestPalindrome(string a) {
        if (a.size() == 0) return "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < a.size(); i++) {
            int len1 = expandFromMiddle(a, i, i); // aabaa
            int len2 = expandFromMiddle(a, i, i+1); // abba
            int len = max(len1, len2);
            if (len > (end - start)) { // new longest palindrome
                start = i - ((len-1)/2);
                end = i + (len/2);
            }    
        }
        return a.substr(start, end-start + 1);
    }
    
    int expandFromMiddle(string &a, int start, int end) {
        if (a == "" || start > end) return 0;
        while (start >= 0 && end < a.size() && a[start] == a[end]) {
            start --;
            end ++;
        }
        return end - start - 1; // length of palindrome
    }
    
    
    // approach: DP => O(n^2), O(n^2) 
    // for each start and end pair, store if it's a palindrom
    // use this info for checking bigger palindrome's validity
    // string longestPalindrome(string a) {
    //     int n = a.size();
    //     bool dp[n][n];
    //     int maxi = 0;
    //     string res = "";
    //     for (int diagonal = 0; diagonal < n; diagonal++) {
    //         int i = 0;
    //         while (i + diagonal < n) {
    //             if (a[i] == a[i + diagonal]) {
    //                 if (diagonal >= 2) {
    //                     if (dp[i+1][i+diagonal-1]) {
    //                         dp[i][i+diagonal] = true;
    //                         if ((diagonal + 1) > maxi) res = a.substr(i, diagonal+1);   
    //                     }
    //                     else  dp[i][i+diagonal] = false;
    //                 }
    //                 else {
    //                     dp[i][i+diagonal] = true;
    //                     if ((diagonal + 1) > maxi) res = a.substr(i, diagonal+1);
    //                 }
    //             }
    //             else dp[i][i+diagonal] = false;
    //             i++;
    //         }
    //     }
    //     return res;
    // }
    
    
//     // Function to print a substring
// // str[low..high]
// string printSubStr(
//     string str, int low, int high)
// {
    
//     string res="";
//     for (int i = low; i <= high; ++i)
//         res +=str[i];
    
//     return res;
// }

// // This function prints the
// // longest palindrome substring
// // It also returns the length of
// // the longest palindrome
// string longestPalindrome(string str)
// {
//     // get length of input string
//     int n = str.size();

//     // table[i][j] will be false if substring
//     // str[i..j] is not palindrome.
//     // Else table[i][j] will be true
//     bool table[n][n];

//     memset(table, 0, sizeof(table));

//     // All substrings of length 1
//     // are palindromes
//     int maxLength = 1;

//     for (int i = 0; i < n; ++i)
//         table[i][i] = true;

//     // check for sub-string of length 2.
//     int start = 0;
//     for (int i = 0; i < n - 1; ++i) {
//         if (str[i] == str[i + 1]) {
//             table[i][i + 1] = true;
//             start = i;
//             maxLength = 2;
//         }
//     }

//     // Check for lengths greater than 2.
//     // k is length of substring
//     for (int k = 3; k <= n; ++k) {
//         // Fix the starting index
//         for (int i = 0; i < n - k + 1; ++i) {
//             // Get the ending index of substring from
//             // starting index i and length k
//             int j = i + k - 1;

//             // checking for sub-string from ith index to
//             // jth index iff str[i+1] to str[j-1] is a
//             // palindrome
//             if (table[i + 1][j - 1] && str[i] == str[j]) {
//                 table[i][j] = true;

//                 if (k > maxLength) {
//                     start = i;
//                     maxLength = k;
//                 }
//             }
//         }
//     }

//     // cout << "Longest palindrome substring is: ";
//     return printSubStr(str, start, start + maxLength - 1);

//     // return length of LPS
//     // return maxLength;
// }
    
};