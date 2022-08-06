class Solution {

public int[] dailyTemperatures(int[] temperatures) {
//use Array 11 ms 131.2 MB

    int[] result = new int[temperatures.length];
    int[] stack = new int[temperatures.length + 1];
    int sp = 0;
    
    for(int i = 0; i < temperatures.length; i++) {            
        while(sp != 0 && temperatures[i] > temperatures[stack[sp]]) {
            int idx = stack[sp--];
            result[idx] = i - idx;
        }
        stack[++sp] = i;
    }
    
    return result;
}
}