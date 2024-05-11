class Solution {
    public List<String> generateGrayString(int n){
        if(n==1){
            List<String> zero=new ArrayList<>();
            zero.add("0");
            zero.add("1");
            return zero;
        }
        List<String>ans=new ArrayList<>();
        List<String>temp=generateGrayString(n-1);
        for(int i=0;i<temp.size();i++){
            ans.add("0"+temp.get(i));
        }
        for(int i=temp.size()-1;i>=0;i--){
            ans.add("1"+temp.get(i));
        }
        return ans;

    }
    public int num(String bin){
        int val=0;
        int n=0;
        for(int i=bin.length()-1;i>=0;i--){
           int num=(int)Math.pow(2,n);
           int v=bin.charAt(i)-'0';
           val+=num*v;
           n++;
        }
        return val;
    }
    public List<Integer> grayCode(int n) {
        List<String>gray=generateGrayString(n);
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<gray.size();i++){
            int val=num(gray.get(i));
            ans.add(val);
        }
        return ans;
    }
}