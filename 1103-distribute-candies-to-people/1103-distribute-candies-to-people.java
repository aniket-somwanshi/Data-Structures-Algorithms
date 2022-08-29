class Solution {
    // O(num_people) O(1)
    public int[] distributeCandies(int candies, int num_people) {
        int N = getN(candies);
        
        int[] res = new int[num_people];
        int noOfCompleteRows = N/num_people; 
        
        for (int i = 0; i < num_people; i++) {
            int sum = getSumOfNTermsInAP(i+1, noOfCompleteRows, num_people);
            //System.out.println(sum + " d");
            res[i] += sum;
            candies -= sum;
        }
        
        //System.out.println(candies + " "+ noOfCompleteRows+ " "+N);
        
        // possibly remaining row
        int lastRowStart = (noOfCompleteRows * num_people) + 1;
                //System.out.println("lastRowStart"+lastRowStart);

        int i = 0;
        while (candies > 0) {
            if (i == num_people) i = 0;
            if (candies < lastRowStart) {
                res[i] += candies;
                candies -= candies;
                break;
            }
            else {
                res[i] += lastRowStart;
                candies -= lastRowStart;
                lastRowStart++;
            }
            i++;
        }
        return res;
    } 
    
    private int getSumOfNTermsInAP(int a, int n, int d) {
        //System.out.println(a+" "+n+" "+d+" d");
        int ans = (n*(2*a + (n-1)*d))/2;
        //System.out.println(ans);
        return ans;

    }
    
    private int getN(int candies) {
        int k = candies;
        int N = -1 + (int)(Math.sqrt(1 + 8*k))/2;
        return N;
    }
}