class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;
        int totalCost = 0;
        int i = 0;
        while (i < n) {
            char current = colors.charAt(i);
            int count = 0;
            int maxi = Integer.MIN_VALUE;
            int sum = 0;
            while (i < n && current == colors.charAt(i)) {
                System.out.print(i);
                sum += neededTime[i];
                maxi = Math.max(maxi, neededTime[i]);
                count++;
                i++;
            }
            System.out.println();
            if (count >= 2) {
                
                totalCost += (sum - maxi);
            }
        } 
        
        return totalCost;
    }
}