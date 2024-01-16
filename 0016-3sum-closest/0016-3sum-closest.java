class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff=Integer.MAX_VALUE;
        int answer=-1;
        int n = nums.length;
        for(int i=0;i<n-2;i++){
            int l=i+1;
            int h=n-1;
            while(h>l){
                int threeSum = nums[i]+nums[l]+nums[h];
                if(diff>Math.abs(threeSum-target)){
                    diff=Math.abs(threeSum-target);
                    answer=threeSum;
                }
                if(threeSum==target) return target;
                else if(threeSum>target) h--;
                else l++;
            }
        }
        return answer;
    }
}