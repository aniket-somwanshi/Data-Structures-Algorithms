class Pair {
    int num;
    int span;
    public Pair(int num, int span) {
        this.num = num;
        this.span = span;
    }
}

class Solution {
    public int sumSubarrayMins(int[] a) {
        int n = a.length;
        if (n == 1) return a[0];
        
        // find reach (length upto which this el is smallest) to the left
        int[] leftReach = new int[n];
        Arrays.fill(leftReach, 1);
        Stack<Pair> stack= new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (stack.isEmpty() == false && a[i] < stack.peek().num) {
                leftReach[i] += stack.pop().span;
            }
            stack.push(new Pair(a[i], leftReach[i]));
        }
        
        // find reach to the left, 
        int[] rightReach = new int[n];
        Arrays.fill(rightReach, 1);
        stack= new Stack<>();
        
        for (int i = n-1; i >= 0; i--) {
            while (stack.isEmpty() == false && a[i] <= stack.peek().num) { // notice we took <=, as one time, we have to take it 
                rightReach[i] += stack.pop().span;
            }
            stack.push(new Pair(a[i], rightReach[i]));
        }
        
        // for each element,
        // get no. of subarrays where its smallest, multiply with the element,
        // add to total sum
        int mod = 1000000007;
        System.out.println(Arrays.toString(leftReach));
        System.out.println(Arrays.toString(rightReach));
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + (long)a[i] * leftReach[i] * rightReach[i] ) % mod;
        }
        
        // mod res with 10^9+7
        return (int)res;
    }
}