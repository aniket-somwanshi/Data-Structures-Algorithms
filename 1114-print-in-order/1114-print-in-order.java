class Foo {
    private Object lock;
    boolean oneDone;
    boolean twoDone;
    public Foo() {
        lock = new Object();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        synchronized (lock) {
            printFirst.run();
            oneDone = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (!oneDone) {
                lock.wait();
            } 
            printSecond.run();
            twoDone = true;
            lock.notifyAll();
        }
        
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (!twoDone) {
                lock.wait();
            }
            printThird.run();
        }
        
    }
}