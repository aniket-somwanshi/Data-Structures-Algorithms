import java.util.*;
import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('}', '{');
        pairs.put(']', '[');
        pairs.put(')', '(');
        
        for (char c : s.toCharArray()) {
            if (pairs.values().contains(c)) {
                stack.push(c);
            } 
            
            if (pairs.keySet().contains(c)) {
                if (stack.empty()) return false;
                if (stack.pop() != pairs.get(c)) return false;
            }
        }
        
        return stack.empty();
    }
}