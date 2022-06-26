class Solution
{
    public int getMaxLen(int[] arr)
    {
        int length = 0;
        
        int firstPos = -1;
        int firstNeg = -1;
        
        int pfm = 1;
        
        for(int i = 0;i<arr.length;i++)
        {
            int val = arr[i];
            if(val == 0)
            {
                firstPos = i;
                firstNeg = -1;
                pfm = 1;
                continue;
            }
            if(val < 0 && firstNeg == -1) firstNeg = i; 
            pfm *= ((val < 0) ? -1 : 1);
            
            if(pfm > 0) length = Math.max(length,i-firstPos);
            else if(pfm < 0) if(firstNeg!=-1) length = Math.max(length,i-firstNeg);
        }
        return length;
    }
}