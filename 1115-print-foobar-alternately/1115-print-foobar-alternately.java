class FooBar {
    private int n;
    private int turn = 0; // 0 = foo, 1 = bar
    private Object lock = new Object();
    int c1 = 0;
    int c2 = 0;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        while (c1 < n) {
            synchronized(lock) {
                if (turn == 0) {
                    printFoo.run();
                    c1++;
                    turn = 1;
                    lock.notifyAll();
                }
                else {
                    lock.wait();
                }
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
         while (c2 < n) {
            synchronized(lock) {
                if (turn == 1) {
                    printBar.run();
                    c2++;
                    turn = 0;
                    lock.notifyAll();
                }
                else {
                    lock.wait();
                }
            }
        }
    }
}