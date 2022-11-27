class Solution {
    int inversions;
    public int reversePairs(int[] nums) {
        inversions = 0;
        mergeSort(nums);
        return inversions;
    }
    
    private void mergeSort(int[] a) {
        if (a.length < 2) return;
        
        int mid = a.length/2;
        
        int left[] = new int[mid];
        for (int i = 0; i < mid; i++) left[i] = a[i];
        
        int[] right = new int[a.length-mid];
        for (int i = mid; i < a.length; i++) right[i-mid] = a[i];
        
        mergeSort(left);
        mergeSort(right);
        
        merge(a, left, right);
    }
    
    private void merge(int[] a, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        
        // count inversions
        while (i < left.length && j < right.length) {
            // System.out.println(i + "-" + left[i]);
            // System.out.println(j + "-" + right[j]);
            // System.out.println();
            long lhs =  1L * left[i];
            long rhs = 2L * right[j];
            if (lhs > rhs) {
                inversions += left.length - i;
                j++;
            }
            else i++;
        }
        
        // merge
        i = 0;
        j = 0;
        int k = 0;
        
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                a[k++] = left[i++];
            }
            else {
                a[k++] = right[j++];
            }
        }
        
        while (i < left.length) {
            
                a[k++] = left[i++];
            
        }
        while (j < right.length) {
            
                a[k++] = right[j++];
        }
    }
}







