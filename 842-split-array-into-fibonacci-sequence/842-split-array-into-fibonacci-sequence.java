class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> res = new ArrayList<>();
        int first = 0, second = 0;
        split(0, num, res);
        return res;
    }
    
    private boolean split(int index, String num, List<Integer> res) {
        if (index >= num.length()) {
            if (res.size() >= 3) return true;
            else return false;
        }
        int third = 0;
        for (int i = index; i < num.length(); i++) {
            if (i > index && num.charAt(index) == '0') break;
            third = (third*10) + (num.charAt(i)-'0');
            // handle overflow
            if (third < 0) return false;
            if (res.size() < 2 || (third == res.get(res.size()-1) + res.get(res.size()-2))) {
                res.add(third);
                if (split(i+1, num, res) == true) return true;
                res.remove(res.size()-1);
            }
            
        }
        return false;
    }
}