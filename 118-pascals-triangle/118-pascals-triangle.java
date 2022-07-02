class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i < numRows;i++) {
            
         ArrayList<Integer> insList = new ArrayList<>();
         if (i==0) {
             insList.add(1);
            list.add(insList);}
         if (i==1) {
             insList.add(1);
             insList.add(1);
             list.add(insList);}
         if (i>1) {
             insList.add(1);
             
             for (int j = 0; j < list.get(i-1).size()-1;j++){
                 insList.add(list.get(i-1).get(j) + list.get(i-1).get(j+1));
             }
             insList.add(1);
             list.add(insList);}
        }
        
        
    
        return list;
    }
}