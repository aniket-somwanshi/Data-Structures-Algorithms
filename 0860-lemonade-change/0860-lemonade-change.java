class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int fivers = 0;
        int tenners = 0;
        int twenners = 0;
        for (int bill: bills) {
            if (bill == 5) {
                fivers++;
                continue;
            }
            
            if (bill == 10) {
                tenners++;
                if (fivers >= 1) {
                    fivers--;
                    continue;
                }
                else return false;
            }
            
            if (bill == 20) {
                twenners++;
                if (tenners >= 1  && fivers >= 1) {
                    tenners--;
                    fivers--;
                }
                else if (fivers >= 3) {
                    fivers -= 3;
                }
                else return false;
            }
        }
        return true;
    }
}