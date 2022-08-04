class Solution {
    public int mySqrt(int x) {
        //Binary Search
        int low=0;
        int high=Integer.MAX_VALUE;
        while(low<=high){
            int mid=low+(high-low)/2;
            if((long)mid*mid <(long) x){
                low=mid+1;
            }
            else if((long)mid*mid >(long)x){
                high=mid-1;
            }
            else{
                return mid;
            }
        }
        return high;
    }
}