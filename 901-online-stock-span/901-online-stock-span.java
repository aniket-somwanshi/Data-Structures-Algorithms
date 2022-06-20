class Stock{
    int price;
    int span;
    public Stock(int p, int s) {
        this.price =p;
        this.span = s;
    }
}
class StockSpanner {
    Stack<Stock> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    // O(N)
    public int next(int price) {
        int currentSpan = 1;
        while (stack.isEmpty() == false && stack.peek().price <= price) {
            currentSpan += stack.peek().span;
            stack.pop();
        }
        stack.push(new Stock(price, currentSpan));
        return currentSpan;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */