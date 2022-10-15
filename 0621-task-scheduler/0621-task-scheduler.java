class Solution {
    // O(N + N*K*26) O(26 + 26) -- N = tasks.length, K = idle time
    public int leastInterval(char[] tasks, int k) {
        int n = tasks.length;
        int[] count = new int[26];
        for (char task: tasks) {
            count[task - 'A']++;
        }
        
        int tasksProcessed = 0;
        
        int[] lastUsedAt = new int[26];
        Arrays.fill(lastUsedAt, Integer.MIN_VALUE);
        
        int cycle = 0;
        while (tasksProcessed < n) {
            // try to take the most frequent task, which is also valid  
            int maxiIndex = -1;
            int maxi = 0;
            for (int i = 0; i < 26; i++) {
                if (count[i] > maxi && cycle > lastUsedAt[i] + k) {
                    maxi = count[i];
                    maxiIndex = i;
                }
            }
            //System.out.println(maxiIndex);
            // use this maxi task 
            if (maxiIndex != -1) {
                lastUsedAt[maxiIndex] = cycle;
                count[maxiIndex]--;
                tasksProcessed++;
            }
            cycle++;
        }
        return cycle;
    }
}