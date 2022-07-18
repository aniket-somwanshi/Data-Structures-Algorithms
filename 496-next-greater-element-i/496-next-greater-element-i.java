class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        
        int[] sol = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int value = nums1[i];
            int index = map.get(value);

            sol[i] = -1;
            for (int j = index + 1; j < nums2.length; j++) {
                if (nums2[j] > value) {
                    sol[i] = nums2[j];
                    break;
                }
            }
        }
        
        return sol;
    }
}