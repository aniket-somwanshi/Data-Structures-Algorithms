class MinStack {
   
    public MinStack() {
       
    }
    private Stack<Integer> mStack = new Stack<Integer>();
private Stack<Integer> mMinStack = new Stack<Integer>();

public void push(int x) {
	mStack.push(x);
	if (mMinStack.size() != 0) {
		int min = mMinStack.peek();
		if (x <= min) {
			mMinStack.push(x);
		}
	} else {
		mMinStack.push(x);
	}
}

public void pop() {
	int x = mStack.pop();
	if (mMinStack.size() != 0) {
		if (x == mMinStack.peek()) {
			mMinStack.pop();
		}
	}
}

public int top() {
	return mStack.peek();
}

public int getMin() {
    return mMinStack.peek();
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