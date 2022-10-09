class MinStack {
    Stack<Integer> s;
    Stack<Integer> ms;
    public MinStack() {
        s = new Stack<Integer>();
        ms = new Stack<Integer>();
    }
//     public void push(int x) {
//         mStack.push(x);
//         if (mMinStack.size() != 0) {
//             int min = mMinStack.peek();
//             if (x <= min) {
//                 mMinStack.push(x);
//             }
//         } else {
//             mMinStack.push(x);
//         }
// }

//     public void pop() {
//         int x = mStack.pop();
//         if (mMinStack.size() != 0) {
//             if (x == mMinStack.peek()) {
//                 mMinStack.pop();
//             }
//         }
//     }
    
    public void push(int val) {
        s.push(val);
        if (ms.isEmpty() || val <= ms.peek()) ms.push(val);
    }
    
    public void pop() {
        int x = s.pop();
        if (ms.size() != 0) {
            if (x == ms.peek()) ms.pop();
        }
        
    }
    
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