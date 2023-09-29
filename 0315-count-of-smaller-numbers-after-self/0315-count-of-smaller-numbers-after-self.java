class Pair {
    int val;
    int index;
    public Pair(int val, int index) {
        this.val = val;
        this.index = index;
    }
}
class Solution {
    Integer[] res;
    int n;
    public List<Integer> countSmaller(int[] nums) {
        n = nums.length;
        res = new Integer[n];
        Arrays.fill(res, 0);
        Pair[] a = new Pair[n];
        for (int i = 0; i < n; i++) {
            Pair p = new Pair(nums[i], i);
            a[i] = p;
        }
        for (Pair pp: a)
        System.out.println(pp.val);
        mergeSort(0, n-1, a);
        return Arrays.asList(res);
    }
    
    private void merge(int low, int mid, int high, Pair[] a) {
        int i = low;
        int j = mid+1;
        int k = 0;
        Pair[] temp = new Pair[high-low+1];
        
        while (i <= mid && j <= high) {
            if (a[i].val <= a[j].val) {
                temp[k++] = a[j++];
            }
            else {
                res[a[i].index] += high-j+1;
                temp[k++] = a[i++];
            }
        }
        
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= high) {
            temp[k++] = a[j++];
        }
        
        for (int x = low; x <= high; x++) {
            a[x] = temp[x-low]; 
        }
    }
    
    private void mergeSort(int low, int high, Pair[] a) {
        if (low < high) {
            int mid = low + (high - low)/2;
            mergeSort(low, mid, a);
            mergeSort(mid+1, high, a);
            merge(low, mid, high, a);
        }
    }
}