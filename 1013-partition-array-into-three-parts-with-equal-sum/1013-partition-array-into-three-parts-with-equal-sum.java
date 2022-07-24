class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int num: arr) sum += num;
        if (sum % 3 != 0) return false;
        int targetSum = sum/3;
        
        int currentTarget = targetSum;
        int currentSum = 0;
        int partitions = 0;
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];
            if (currentSum == targetSum) {
                partitions++;
                currentSum = 0;
            }
        }
        
        return partitions >= 3;
    }
}