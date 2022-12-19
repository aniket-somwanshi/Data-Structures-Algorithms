class Solution {
    public String longestPrefix(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        
        int[] z = new int[n];
        z[0] = 0;
        
        int left = 0;
        int right = 0;
        
        for (int i = 1; i < n; i++) {
            if (i == 13) {
                System.out.println(left);
                System.out.println(right);
                System.out.println();
                }
            if (i > right) {
                // outside the z-box
                left = i;
                right = i;
                
                while (right < n && a[right] == a[right - left]) {
                    right++;
                }
                
                right--;
                
                z[i] = right - left + 1;
            }
            else {
                // inside the z-box
                int copyIndex = i - left;
                
                if (z[copyIndex] + i - 1 < right) {
                    z[i] = z[copyIndex];
                }
                else {
                    // manually calculate z
                    left = i;
                    while (right < n && a[right] == a[right - left]) {
                        right++;
                    }
                    right--;
                    
                    z[i] = right - left + 1;
                }
            }
        }
        
        //System.out.println(Arrays.toString(z));
        
        // find starting index where length of matching prefix is longest
        // and it should also be a suffix so it's length should be 
        // atleast the till the last character
        String res = "";
        for (int i = 0; i < n; i++) {
            if (z[i] + i == n) {
                if (z[i] > res.length()) {
                    res = s.substring(i);
                }
            }
        }
        return res;
    }
}
