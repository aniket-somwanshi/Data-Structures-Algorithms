class Solution {
    // O(N) O(1)
    // Alternate one pass approach
     // public int longestMountain(int[] arr) {
     //    int n = arr.length;
     //    int maxLengthOfMountain = 0;
     //    int state = 0; // 0 = downhill, 1 = uphill
     //    int currentLen = 0;
     //    for (int i = 1; i < n-1; i++) {
     //        if (state == 0 && arr[i] > arr[i-1]) {
     //            if (currentLen >= 3) maxLengthOfMountain = Math.max(maxLengthOfMountain, currentLen);
     //            currentLen = 1;
     //            state = 1;
     //        }
     //        else if (state == 1 && arr[i] < arr[i-1]) {
     //            currentLen++; 
     //            state = 0;
     //        }
     //        else {
     //            currentLen++;
     //        }
     //    }
     //    if (currentLen >= 3) maxLengthOfMountain = Math.max(maxLengthOfMountain, currentLen);
     //    return maxLengthOfMountain;
     // }
    
    // O(N) O(1)
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int maxLengthOfMountain = 0;
        for (int peak = 1; peak < n-1; peak++) {
            int lengthOfMountain = 0;
            if (arr[peak-1] < arr[peak] && arr[peak] > arr[peak+1]) {
                // System.out.println("peak "+peak);
                // check left downhill length
                lengthOfMountain += getLeftDownhillLength(arr, peak-1);
                // check right downhill length
                lengthOfMountain += getRightDownhillLength(arr, peak+1);
                
                // +1 for peak
                lengthOfMountain++;
            }
            maxLengthOfMountain = Math.max(maxLengthOfMountain, lengthOfMountain);
        }
        return maxLengthOfMountain;
    }
    
    private int getLeftDownhillLength(int[] arr, int i) {
        int length = 0;
        while (i >= 0 && arr[i] < arr[i+1]) {
            i--;
            length++;
        }
        return length;
    }
    
    private int getRightDownhillLength(int[] arr, int i) {
        int length = 0;
        while (i < arr.length && arr[i] < arr[i-1]) {
            i++;
            length++;
        }
        return length;
    }
}