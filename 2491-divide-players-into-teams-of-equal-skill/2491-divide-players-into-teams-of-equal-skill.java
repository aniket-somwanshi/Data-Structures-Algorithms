class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        long res = 0;
        
        int sum = 0;
        for (int num: skill) sum += num;
        
        if (sum % (n/2) != 0) return -1;
        
        int targetSum = sum / (n/2);
        
        int[] freq = new int[1001];
        
        for (int num: skill) {
            freq[num]++;
        }
        
        for (int num: skill) {
            if (freq[num] == 0) continue;
            freq[num]--;
            int partner = targetSum - num;
            if (freq[partner] == 0) return -1;
            freq[partner]--;
            res += (1L * num * partner);
        }
        
        return res;
    }
}