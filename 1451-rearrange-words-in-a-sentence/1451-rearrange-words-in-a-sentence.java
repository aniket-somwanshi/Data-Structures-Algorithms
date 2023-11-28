class Solution {
    public String arrangeWords(String text) {
        StringBuilder sb = new StringBuilder(text);
        sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
        
        String[] str = sb.toString().split(" ");
        Arrays.sort(str, (a,b)->a.length()-b.length());
        // StringBuilder sb = new StringBuilder();
        // for (String s: str) sb.append("");
        String combined = String.join(" ", str);
        StringBuilder res = new StringBuilder(combined);
        
        res.setCharAt(0, Character.toUpperCase(res.charAt(0)));
        return res.toString();
    }
}