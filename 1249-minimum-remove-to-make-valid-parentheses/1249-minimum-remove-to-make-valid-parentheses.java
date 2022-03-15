class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        char[] stackWords = new char[n];
        char[] stackParenthesis = new char[n];
        int topW = -1, topP = -1;

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                stackWords[++topW] = ch;
                continue;
            }
            if(ch == '('){
                stackWords[++topW] = ch;
                stackParenthesis[++topP] = ch;
            }
            else if(ch == ')'){
                if(topP == -1)
                    continue;
                
                stackWords[++topW] = ch;
                if(stackParenthesis[topP] == '(')
                    topP--;
                else
                    stackParenthesis[++topP] = ch;
            }
        }
        StringBuffer sb = new StringBuffer();
        while(topW > -1){
            if((topP != -1) && (stackWords[topW] == stackParenthesis[topP])){
                topP--;
                topW--;
                continue;
            }
            sb.append(stackWords[topW--]);
        }
        return sb.reverse().toString();
    }
}