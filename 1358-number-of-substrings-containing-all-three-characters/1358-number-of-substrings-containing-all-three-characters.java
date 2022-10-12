class Solution {
    // O(N) O(3)
    // ans = total substrings - substr with 0 occurances of abc
    public int numberOfSubstrings(String s) {
     int n = s.length();
        long total = (long)Math.pow(n, 2) + n;
        total /= 2;
     return (int)(total - numSubarraysWithNoOccurance(s.toCharArray()));
    }
    
    private long numSubarraysWithNoOccurance(char[] a) {
        long res = 0;
        int start = 0;
        int count[] = {0, 0, 0};
        for (int i = 0; i < a.length; i++) {
            count[a[i]-'a']++;
            // System.out.println(i+" ");
            // System.out.println(Arrays.toString(count));
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[a[start]-'a']--;
                start++;
            }
            res += i - start + 1;
        }
        return res;
    }
}