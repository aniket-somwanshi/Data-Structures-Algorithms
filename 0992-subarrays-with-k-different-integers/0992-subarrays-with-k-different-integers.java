// O(2N) O(2N) 
// convert into aggregate problem so that
// 2 pointers sliding winodw can be applied. 
// count(parameter == k) is equal to count(parameter <= k) - count(parameter <= k-1)
// if k = 4
// from count of subarrays containing [0, 1, 2, 3, 4] distinct elements,
// we subtract count of subarrays containing [0, 1, 2, 3] distinct elements
// so we are left with subarrays containing [4] distinct elements only 
class Solution {
    public int subarraysWithKDistinct(int[] a, int k) {
        return subarraysWithUptoKDistinct(a, k) -  subarraysWithUptoKDistinct(a, k - 1);
    }
    
    private int subarraysWithUptoKDistinct(int[] a, int k) {
        int i = 0;
        int j = 0;
        int n = a.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int count = 0;
        
        if (k == 0) return 0;
        
        while (j < n) {
            if (map.containsKey(a[j])) {
                map.put(a[j], map.get(a[j]) + 1);
                count += (j - i + 1);
                j++;
            }
            else if (k > 0) {
                k--;
                map.put(a[j], 1);
                count += (j - i + 1);
                j++;
            }
            else {
                // violation
                
                if (map.get(a[i]) == 1) {
                    map.remove(a[i]);
                    i++;
                    k++;
                }
                else {
                    map.put(a[i], map.get(a[i]) - 1);
                    i++;
                }
            }
        }
        
        return count;
    }
}