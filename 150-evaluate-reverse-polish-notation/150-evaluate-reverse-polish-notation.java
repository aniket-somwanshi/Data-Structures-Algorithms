class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> operands = new Stack();          //Declaring empty stack
        
        int a = -1, b = -1;                        //operand variables; 
        for(int i=0;i<tokens.length;i++) {
		
		   //If the tokens[i] is equals to any of the operand then pop two recently added values from stack and perform the given operation
		   
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                a =  operands.pop();
                b =  operands.pop();
                
                if(tokens[i].equals("+"))          //If operator equals to '+'
                     operands.push(a + b);
					 
                else if(tokens[i].equals("-"))     //If operator equals to '-'
                     operands.push(b - a);
					 
                else if(tokens[i].equals("*"))     //If operator equals to '*'
                    operands.push(a * b);
					
                else                               //If operator equals to '/'
                     operands.push(b / a);
            }
			
			//If the tokens[i] not equals to any of the operator then it must be number i.e. operand so adding it to the stack
            else {
                 operands.push(Integer.parseInt(tokens[i]));
            }
                
        }
        
		//The final answer will be stored in the stack on top, so returning the popped element
        return operands.pop();
        
    }
}


