// O(elements) O(elements) 
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int rows = nums.size();
        List<Integer> res = new ArrayList<>();
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int diagonalKey = i+j;
                int num = nums.get(i).get(j);
                if (!map.containsKey(diagonalKey)) map.put(diagonalKey, new ArrayList<>());
                map.get(diagonalKey).add(num);
            }
        }
        
        int diagonalKey = 0;
        while (map.containsKey(diagonalKey)) {
            List<Integer> current = map.get(diagonalKey);
            for (int i = current.size()-1; i >= 0; i--) {
                res.add(current.get(i));
            }
            diagonalKey++;
        }
        
        int[] ans = new int[res.size()];
        int i = 0;
        for (int num: res) ans[i++] = num;
        
        return ans;
    }
}

// // O(N*M) O(1) -- M = max column length !TLE
// class Solution {
//     public int[] findDiagonalOrder(List<List<Integer>> nums) {
//         int rows = nums.size();
//         // find the max column
//         int cols = 0;
//         for (List<Integer> row: nums) cols = Math.max(cols, row.size());
        
//         List<Integer> res = new ArrayList<>();
        
//         for (int row = 0; row < rows; row++) {
//             int i = row;
//             int j = 0;
//             while (i >= 0 && j < cols) {
//                 if (j < nums.get(i).size()) {
//                     res.add(nums.get(i).get(j));
//                 }
//                 i--;
//                 j++;
//             }
//         }
        
//         for (int col = 1; col < cols; col++) {
//             int i = rows-1;
//             int j = col;
//             while (i >= 0 && j < cols) {
//                 if (j < nums.get(i).size()) {
//                     res.add(nums.get(i).get(j));
//                 }
//                 i--;
//                 j++;
//             }
//         }
        
        
        
        
//         int[] ans = new int[res.size()];
//         int i = 0;
//         for (int num: res) ans[i++] = num;
        
//         return ans;
//     }
// }