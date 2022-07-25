class SortBySetBits implements Comparator<Integer> {
    
    private int getCountOfSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            int rsbm = num & -num;
            num = num - rsbm;
        }
        return count;
    }
    
    public int compare(Integer a, Integer b) {
        // calculate count of set bits in the num
        int countOfSetBitsA = getCountOfSetBits(a);
        int countOfSetBitsB = getCountOfSetBits(b);
        
        if (countOfSetBitsA > countOfSetBitsB) return 1;
        else if (countOfSetBitsA < countOfSetBitsB) return -1;
        else return a.compareTo(b);
    }
    
}
class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] a = Arrays.stream( arr ).boxed().toArray( Integer[]::new );
        Arrays.sort(a, new SortBySetBits());
        int[] res = new int[arr.length];
        for (int i = 0; i < a.length; i++) res[i] = a[i];
        return res;
    }
}