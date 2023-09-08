public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int x = 4;
        System.out.println(x & (1 << 2));
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1; 
            res = res | (bit << (31 - i));
        }
        return res;
    }
}