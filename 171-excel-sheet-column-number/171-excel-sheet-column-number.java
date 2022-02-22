class Solution {
public int titleToNumber(String str) {
	// MUL CONTAINS MULTPLYING FACTOR
        int ans = 0,n = str.length(),mul = 1;
        for(int i = n - 1;i>=0;i--)
        {
            ans+=(str.charAt(i)-'A'+1)*mul;
            mul*=26;
        }
        return ans;
    }
}