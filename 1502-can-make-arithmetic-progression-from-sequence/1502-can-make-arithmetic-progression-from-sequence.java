// O(NlogN) O(logN)
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int constantDifference = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            int currentDifference = arr[i] - arr[i-1];
            if (currentDifference != constantDifference) return false;
        }
        return true;
    }
}