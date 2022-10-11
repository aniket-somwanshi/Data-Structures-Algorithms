class Solution {

public boolean increasingTriplet(int[] nums) {
// our aim is to store the increasing elements in i and j. If it stored then we will check the next element,   
//  if next element(k) is greater than both the i and j. Then we get our increasing triplet sequence.
     int i = Integer.MAX_VALUE;
     int j = i;
    for(int k : nums){
        if(k < i) i = k;
        if(k > i && j > k) j = k;
        if(k > i && k > j) return true;
    }
    return false;
}
}

