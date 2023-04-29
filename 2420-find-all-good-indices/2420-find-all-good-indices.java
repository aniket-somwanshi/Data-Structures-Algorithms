class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        boolean[] prev = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (st.size() >= k) prev[i] = true;
            if (st.isEmpty() || nums[i] <= st.peek()) {
                st.push(nums[i]);
            }
            else {
                while (!st.isEmpty()) st.pop();
                st.push(nums[i]);
            }
        }
        
        st = new Stack<>();
        boolean[] back = new boolean[n];
        for (int i = n-1; i >= 0; i--) {
            if (st.size() >= k) back[i] = true;
            if (st.isEmpty() || nums[i] <= st.peek()) {
                st.push(nums[i]);
            }
            else {
                while (!st.isEmpty()) st.pop();
                st.push(nums[i]);
            }
        }
        
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < n; i++) if (prev[i] && back[i]) res.add(i);
        
        
        return res;
    }
}