class Solution {
public:
//     vector<vector<char>> ans;
//     const int n = 9;
//     bool solved=false;
    
//    bool row_check(int r, vector<vector<char>>& b, char val) {
//         for(int i = 0; i < n; i++) {
//             if(b[r][i] == val) return false;
//         }
//         return true;
//     }
    
//     bool col_check(int c, vector<vector<char>>& b, char val) {
//         for(int i = 0; i < n; i++) {
//             if(b[i][c] == val) return false;
//         }
//         return true;
//     }
    
//     bool box_check(int r, int c, vector<vector<char>>& b, char val) {
//         int row_min = (r/3) * 3;
//         int row_max = row_min + 3;
//         int col_min = (c/3) * 3;
//         int col_max = col_min+3;
//         for(int i = row_min; i < row_max; i++) {
//             for(int j = col_min; j < col_max; j++) {
//                 if(b[i][j] == val) return false;
//             }
//         }
//         return true;
//     }
    
//     void print(vector<vector<char>>& b) {
//         for(auto& e: b) {
//             for(auto& f: e) cout << f << ' ';
//             cout << '\n';
//         }
//     }
    
//      void dfs(vector<vector<char>>& b) {
//         if(solved) return;
//         for(int i = 0; i < n; i++) {
//             for(int j = 0; j < n; j++) {
//                 if(b[i][j] != '.') continue;
//                 for(char k = '1'; k <= '9'; k++) {
//                     if(!row_check(i, b, k) || !col_check(j, b, k) || !box_check(i, j, b, k)) continue;
//                     b[i][j] = k;
//                     dfs(b);
//                     if(solved) return;
//                     b[i][j] = '.';
//                 }
//                 if(!solved) return;
//             }
//             if(solved) return;
//         }
//         ans = b;
//         solved = true;
//     }
    
//      void solveSudoku(vector<vector<char>>& board) {
//         dfs(board);
//         board = ans;
//     }


    bool isValid(char number, vector<vector<char>>& board, int row, int col) {
        // check row 
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == number) return false;
        }
        // check col
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == number) return false;
        }
        // check block
        // int block_row = (row/3)*3;
        // int block_col = (col/3)*3;
        // for (int i = block_row; i <= block_row + 3; i++) {
        //     for (int j = block_col; j <= block_col + 3; j++) {
        //         if (board[i][j] == number) return false;
        //     }
        // } 
        int row_min = (row/3) * 3;
        int row_max = row_min + 3;
        int col_min = (col/3) * 3;
        int col_max = col_min+3;
        for(int i = row_min; i < row_max; i++) {
            for(int j = col_min; j < col_max; j++) {
                if(board[i][j] == number) return false;
            }
        }
        return true;
        
        return true;
    }
    

    bool fillNumbers(vector<vector<char>>& board) {
    
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
               if (board[i][j] == '.') {
                   // try placing all the numbers 
                   for (char number = '1'; number <= '9'; number++) {
                       if (isValid(number, board, i, j)) {
                           board[i][j] = number;
                           if (fillNumbers(board) == true) return true; 
                           else board[i][j] = '.'; // while backtracking, try to select different number
                       }
                   }
                   // no number can be placed here, so we must fix previous selections
                   return false;               }
            }
        }
        return true;
    }

    void solveSudoku(vector<vector<char>>& board) {
        fillNumbers(board);
    }
};