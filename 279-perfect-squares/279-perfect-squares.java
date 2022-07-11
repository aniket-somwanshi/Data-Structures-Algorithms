import java.util.HashMap;
class Solution {
    public int numSquares(int n){
        return numSquares( n, new HashMap<Integer,Integer>());
    }
    public int numSquares(int amount, HashMap<Integer,Integer> dp) {
        if( amount == 0){
            return 0;
        }
        if(dp.containsKey(amount)){
            return dp.get(amount);
        }
        int ways = -1;
        for(int i = 1 ; i <= amount;++i ){
            if(i*i <= amount){ 
                int temp = numSquares(amount-i*i,dp);
                if(temp != -1){
                    ways = ways ==-1 || 1 + temp < ways ? 1 + temp : ways;
                }
            }else{
                break;
            }
        }
        dp.put(amount,ways);
        return ways;
    }
}