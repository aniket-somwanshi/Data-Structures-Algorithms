class Solution {
    public int[] getStrongest(int[] a, int k) {
        int n = a.length;
        Arrays.sort(a);
        int median = a[(n-1)/2];
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->cmp(x,y,median));
        
        for (int num: a) pq.add(num);
        System.out.println(median);
        int[] res = new int[k];
        int i =0;
        while (k-- > 0) {
            res[i++] = pq.poll();
        }
        return res;
    }
    
    // correct order then -1
    // 1, 4
    // v1 > v2
    private int cmp(int x, int y, int m) {
        int v1 = Math.abs(x-m);
        int v2 = Math.abs(y-m);
        
        if (v1 > v2) return -1;
        else if (v2 > v1) return 1;
        if (x > y) return -1;
        else return 1;
    }
}