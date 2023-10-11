class ZeroEvenOdd {
    private int n;
    private Object lock = new Object();
    private boolean isZeroNeeded = true;
    private int i = 1;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            
            synchronized (lock) {
            if (i > n) {
                lock.notifyAll();
                return;
            }
            
            if (isZeroNeeded) {
                printNumber.accept(0);
                isZeroNeeded = false;
                lock.notifyAll();
            }
            else {
                lock.wait();
            }
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            synchronized (lock) {
            if (i > n) {
                lock.notifyAll();
                return;
            }
            
            if (!isZeroNeeded && i%2 == 0) {
                printNumber.accept(i);
                i++;
                isZeroNeeded = true;
                lock.notifyAll();
            }
            else {
                lock.wait();
            }
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            synchronized (lock) {
            if (i > n) {
                lock.notifyAll();
                return;
            }
            
            if (!isZeroNeeded && i%2 == 1) {
                printNumber.accept(i);
                i++;
                isZeroNeeded = true;
                lock.notifyAll();
            }
            else {
                lock.wait();
            }
            }
        }
    }
}