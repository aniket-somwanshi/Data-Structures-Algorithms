class Solution {
    public int getWinner(int[] a, int k) {
        int n = a.length;
        int localWinnerIndex = 0;

        while (localWinnerIndex < n) {
            // check if the localWinnerIndex is the ultimate winner
            // it'll be the ultimate winner if it's 'k' distance
            // far away to the next greater index
            // find the next greater index
            int j = localWinnerIndex+1;
            while (j < n && a[j] < a[localWinnerIndex]) {
                j++;
            }
             System.out.println(j);
            // if there are no next greaters, assume the index to be k+1
            int distance = j == n ? k+1 : j - localWinnerIndex ;
            if (localWinnerIndex == 0) distance--;
            if (distance >= k) return a[localWinnerIndex]; 
            else localWinnerIndex = j;
        }
        
        return -1;
    }
}