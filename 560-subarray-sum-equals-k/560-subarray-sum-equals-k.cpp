class Solution {
public:
    int subarraySum(vector<int>& a, int target) {
        int current_sum = 0;
        int count = 0;
        unordered_map<int, int> mp;
        for (int i = 0; i < a.size(); i++) {
            current_sum += a[i];
            if (current_sum == target) count++;
            // check if previous prefix sums can make up (current_sum - target)
            if (mp.find(current_sum - target) != mp.end()) {
                count += mp[current_sum - target];
            }
            mp[current_sum]++;
        }
        return count;
    }
    

};