class MyQueue {
    Stack<Integer> inputStack = new Stack();
    Stack<Integer> outputStack = new Stack();
    
    public void push(int x) {
     inputStack.push(x);   
    }
    
    public int pop() {
        if(outputStack.empty()){
            while(!inputStack.empty()){
                outputStack.push(inputStack.pop());
            }
        }
        
        return outputStack.pop();
    }
    
    public int peek() {
        if(outputStack.empty()){
            while(!inputStack.empty()){
                outputStack.push(inputStack.pop());
            }
        }
        
        return outputStack.peek();
        
    }
    
    public boolean empty() {
        if(inputStack.empty() && outputStack.empty()){
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */