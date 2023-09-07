class Node {
    int num;
    int mini;
    public Node(int num, int mini) {
        this.num = num;
        this.mini = mini;
    }
}
class MinStack {
    Stack<Node> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        int newMini = st.isEmpty() ? val : Math.min(st.peek().mini, val);
        st.push(new Node(val, newMini));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().num;
    }
    
    public int getMin() {
        return st.peek().mini;
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