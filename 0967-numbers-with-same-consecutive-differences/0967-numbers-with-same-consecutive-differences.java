class Solution {
    List<Integer> res;
    public int[] numsSameConsecDiff(int n, int k) {
        res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            f(i, k, n-1);
        }
        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) resArray[i] = res.get(i);
        return resArray;
    }
    
    private void f(int num, int k, int n) {
        if (n == 0) { res.add(num); return; }
        
        int lastDigit = num % 10;
        
        if (isValid(lastDigit + k)) f((num * 10) + (lastDigit+k), k, n-1);
        
        if (k != 0 && isValid(lastDigit - k)) f((num * 10) + (lastDigit-k), k, n-1);
        
    }
    
    private boolean isValid(int num) {
        return num >= 0 && num <= 9;
    }
    
}