class Solution {
public:
    // int maxProfit(vector<int>& a) {
    //     if(a.size()<2) return 0;
    //     // vector<int> buy(a.size(), 0);
    //     // vector<int> sell(a.size(), 0);   
    //     int buy = (0 - a[0]);
    //     int sell = 0;
    //     for(int i = 1; i < a.size(); i++){
    //         sell = max(sell, buy + a[i]);
    //         buy = max(buy, (0 - a[i]));
    //     }
    //     return sell;
    // }
    
    int maxProfit(vector<int>& a) {
        if(a.size()<2) return 0;
        // vector<int> buy(a.size(), 0);
        // vector<int> sell(a.size(), 0);   
        int mini = a[0];
        int profit = 0;
        for(int i = 1; i < a.size(); i++){
            profit = max(profit, a[i] - mini);
            mini = min(mini, a[i]);
        }
        return profit;
    }
};