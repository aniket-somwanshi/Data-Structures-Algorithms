class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new LinkedList<>();
        
        List<Integer> second = new ArrayList<>();
        while (k > 0) {
            second.add(k % 10);
            k /= 10;
        }
        Collections.reverse(second);
        
        int i = num.length-1;
        int j = second.size()-1;
        
        int hatcha = 0;
        while (i >= 0 && j >= 0) {
            int firstNum = num[i];
            int secondNum = second.get(j);
            
            res.add((hatcha + firstNum + secondNum) % 10);
            hatcha = (hatcha + firstNum + secondNum) / 10;
            
            i--; j--;
        }
        
        while (i >= 0) {
            int firstNum = num[i];
            res.add((hatcha + firstNum) % 10);
            hatcha = ((hatcha + firstNum) / 10);
            i--;
        }
        
        while (j >= 0) {
            int secondNum = second.get(j);
            
            res.add((hatcha + secondNum) % 10);
            hatcha = (hatcha + secondNum) / 10;
            j--;
        }
        
        if (hatcha > 0) res.add(hatcha);
        
        Collections.reverse(res);
        return res;
    }
}