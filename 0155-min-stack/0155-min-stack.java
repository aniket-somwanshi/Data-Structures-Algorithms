class MinStack {
    Stack<Integer> s;
    Stack<Integer> ms;
    public MinStack() {
        s = new Stack<Integer>();
        ms = new Stack<Integer>();
    }
     public void push(int val) {
        s.push(val);
        if (ms.isEmpty() || val <= ms.peek()) ms.push(val);
    }
    
    public void pop() {
        int c = s.pop();
        if (!ms.isEmpty() && c == ms.peek()) ms.pop();
    }
    // int x = mStack.pop();
    //     if (mMinStack.size() != 0) {
    //         if (x == mMinStack.peek()) {
    //             mMinStack.pop();
    //         }
    //     }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return ms.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */