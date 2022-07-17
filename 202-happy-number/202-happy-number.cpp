class Solution {
public:
    
    // approach 2: O(logN), O(1)
    // maintain a slow pointer and a fast pointer 
    // fast pointer will point to nextNum of nextNum
    // if these 2 pointers ever meet, there is a cycle
    // if fast pointer becomes 1, it's a happy number
    
    int nextNum(int n) {
        int sum_of_squares = 0;
        // calculate sum of each digit 
        while (n) {
            int digit = n % 10;
            sum_of_squares += (digit*digit);
            n = n / 10;
        }
        return sum_of_squares;
    }
    
    bool isHappy(int n) {
        
        int slow = n;
        int fast = n;
        slow = nextNum(slow);
        fast = nextNum(nextNum(fast));
        
        while (slow != fast && fast != 1) {
            slow = nextNum(slow);
            fast = nextNum(nextNum(fast));
        }
        
        return fast == 1;
       
    }
    
    
    // approach 1: O(logN), O(logN)
    // keep track of all nextNumbers in a set and if duplicate found, there is a cycle
    // so it's not a happy number 
    
    // if it is a happy number, nextNumber will be 1 
    
//     bool isHappy(int n) {
//         int sum_of_squares = 0;
        
//         unordered_set<int> s;
        
//         while (n!=1) {
//             sum_of_squares = 0;
//             // calculate sum of each digit 
//             while (n) {
//                 int digit = n % 10;
//                 sum_of_squares += (digit*digit);
//                 n = n / 10;
//             }
            
                        
//             // check if sum repeating ie a cycle is found
//             if (s.find(sum_of_squares)!=s.end()) return false;
//             else s.insert(sum_of_squares);
            
//             n = sum_of_squares;
//         }
        
//         return n == 1; 
//     }
};


/*
2 
2* = 4
4* = 16
1* + 6* = 37
3* + 7* = 9 + 49 = 58
5* + 8* = 25 + 64 = 98
9* + 8* = 81 + 64 = 145

3* = 9
9* = 81
8* + 1* = 65
6* + 5* = 36 + 25 = 61
6* + 1* = 37



1* + 9* = 82
8* + 2* = 68
6* + 8* = 100
1* + 0* + 0* = 1


13
1* + 3* = 10
1* + 0* = 1


1* + 1* = 2
2* = 4..

28
2* + 8* = 4 + 64 = 68
6* + 8* = 36 + 64 = 100


1
10
100
1000
10000
*/