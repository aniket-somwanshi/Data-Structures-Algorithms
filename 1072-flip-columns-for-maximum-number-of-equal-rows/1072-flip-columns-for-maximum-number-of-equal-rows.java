class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        // find number of identical or opposite rows
        // the rows with max identical count of rows can be fixed column wise simultaneously
        // to become equal rows
        Map<String, Integer> countOfRow = new HashMap<>();
        
        for (int[] row: matrix) {
            int first = row[0];
            String current = "";
            for (int i = 0; i < row.length; i++) {
                if (row[i] == first) {
                    current += '0';
                }
                else current += '1';
            }
            countOfRow.put(current, countOfRow.getOrDefault(current, 0) + 1);
        }
        
        int res = 0;
        for (Map.Entry<String, Integer> entry: countOfRow.entrySet()) {
            res = Math.max(res, countOfRow.get(entry.getKey()));
        }
        return res;
    }
}
// Wrong approach 
// class Solution {
//     public int maxEqualRowsAfterFlips(int[][] matrix) {
//         // count initial number of equal rows
//         // for each row, mark anamolous cells
//         // find maximum number of anamolies in any single column
//         // this number is the answer if it's greater than initial ans
        
//         int n = matrix.length;
//         int m = matrix[0].length;
        
//         int initialRes = getInitialRes(matrix);
//         for (int i = 0; i < n; i++) {
//             populateAnamolies(matrix[i]);
//         }
        
//         int maxiAnamoliesInOneColumn = 0;
//         for (int j = 0; j < m; j++) {
//             int currentColumnAnamolies = 0;
//             for (int i = 0; i < n; i++) {
//                 if (matrix[i][j] == 2) currentColumnAnamolies++;
//             }
//             maxiAnamoliesInOneColumn = Math.max(maxiAnamoliesInOneColumn, currentColumnAnamolies);
//         }
//         return Math.max(initialRes, maxiAnamoliesInOneColumn);
//     }
    
//     private int getInitialRes(int[][] matrix) {
//         int n = matrix.length;
//         int m = matrix[0].length;
//         int res = 0;
//         for (int i = 0; i < n; i++) {
//             int zeros = 0;
//             for (int j = 0; j < m; j++) {
//                 if (matrix[i][j] == 0) zeros++;
//             }
//             if (zeros == 0 || zeros == matrix[i].length) res++;
//         }
//         return res;
//     }
    
//     private void populateAnamolies(int[] row) {
//         int n = row.length;
//         int ones = 0;
//         int zeros = 0;
//         for (int i = 0; i < n; i++) {
//             if (row[i] == 1) ones++;
//             else if (row[i] == 0) zeros++;
//         }
//         // mark anamolies
//         if (ones == n || zeros == n) return;
//         int anamolousElement = row[0];
//         if (zeros < ones) anamolousElement = 0;
//         else if (ones < zeros) anamolousElement = 1;
        
//         for (int i = 0; i < row.length; i++) {
//             if (row[i] == anamolousElement) {
//                 row[i] = 2;
//             }    
//         }
//     }
// }