class Solution {
    public int findKthPositive(int[] arr, int k) {
        int currentKthMissingInteger = k;
        for (int num: arr) {
            if (num <= currentKthMissingInteger) {
                currentKthMissingInteger ++;
            }
            else return currentKthMissingInteger;
        }
        return currentKthMissingInteger;
    }
}