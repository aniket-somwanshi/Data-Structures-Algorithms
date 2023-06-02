// O(N + N) O(N)
class Solution {
    public int findSubstringInWraproundString(String s) {
        int n = s.length();
        char[] a = s.toCharArray();
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            if (a[i] == 'a' && a[i-1] == 'z') {
                prefix[i] = prefix[i-1] + 1;
            }
            else if ((int)a[i] - (int)a[i-1] == 1) {
                prefix[i] = prefix[i-1] + 1;
            }
            else prefix[i] = 1;
        }
        
        int res = 0;
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            int previous = freq[a[i]-'a'];
            int current = prefix[i];
            
            if (current > previous) {
                res += current - previous; 
                freq[a[i]-'a'] = current;
            }
            
        }
        return res;
    }
}