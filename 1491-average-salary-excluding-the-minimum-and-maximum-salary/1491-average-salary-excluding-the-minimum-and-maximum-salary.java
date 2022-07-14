class Solution {
   public double average(int[] salary) {
        int min = salary[0], max = salary[0], sum = 0;
        for(int i : salary){
            sum += i;
            min = (i < min) ? i : min;
            max = (i > max) ? i : max;
        }
        return (double) (sum - min - max) / (salary.length - 2);
    }
}