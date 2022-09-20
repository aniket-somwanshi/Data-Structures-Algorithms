class Solution {
    /*
    O(N1*N2) O(N1*N2)
    Dp
    if the characters at nums1[i] and nums2[j] match,
    length of previous common subtring will be extended by 1
    so lcs[i][j] = 1 + lcs[i-1][j-1] .. ie before these 2 positions
    */
    public int findLength(int[] nums1, int[] nums2) {
        int maxLCS = 0;
        int[][] lcs = new int[nums1.length+1][nums2.length+1];
        for (int i = 0; i < nums1.length+1; i++) {
            for (int j = 0; j < nums2.length+1; j++) {
                // if either array is empty, there is nothing common
                if (i == 0 || j == 0) {
                    lcs[i][j] = 0;
                    continue;
                }
                // if these 2 are matching extend previous run
                if (nums1[i-1] == nums2[j-1]) {
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                }
                else {
                    lcs[i][j] = 0;
                }
                // update max length lcs
                maxLCS = Math.max(maxLCS, lcs[i][j]);
            }
        }
        return maxLCS;
    }
}