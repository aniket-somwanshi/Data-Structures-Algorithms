// O(1) O(1) O(1) sc: O(N)
class BrowserHistory {
    int currentIndex;
    int currentSize;
    Map<Integer, String> map;
    public BrowserHistory(String homepage) {
        currentIndex = 1;
        currentSize = 1;
        map = new HashMap<>();
        map.put(currentIndex, homepage);
    }
    
    public void visit(String url) {
        currentIndex++;
        map.put(currentIndex, url);
        currentSize = currentIndex;
    }
    
    public String back(int steps) {
        int targetIndex = Math.max(1, currentIndex - steps);
        currentIndex = targetIndex;
        return map.get(currentIndex);
    }
    
    public String forward(int steps) {
        int targetIndex = Math.min(currentSize, currentIndex + steps);
        currentIndex = targetIndex;
        return map.get(currentIndex);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */