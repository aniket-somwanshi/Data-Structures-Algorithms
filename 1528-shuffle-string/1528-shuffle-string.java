class Solution {
    public String restoreString(String s, int[] indices) {
        char[] a = s.toCharArray();
        
        int i = 0;
        while (i < indices.length) {
            if (indices[i] == i) i++;
            else {
                int index1 = i;
                int index2 = indices[i];
                
                // swap indexes in both "a[]" and "indices[]"
                swap(a, index1, index2);
                swap(indices, index1, index2);
            }
        }
        
        return String.valueOf(a);
    }
    
    private void swap(char[] a, int i1, int i2) {
        char t = a[i1];
        a[i1] = a[i2];
        a[i2] = t;
    }
    
    private void swap(int[] a, int i1, int i2) {
        int t = a[i1];
        a[i1] = a[i2];
        a[i2] = t;
    }
    
}