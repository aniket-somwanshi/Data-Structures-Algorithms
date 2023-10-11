// notify wait more elegant
class FooBar {
    private int n;
    private Object lock = new Object();
    private int turn = 0; // 0=foo, 1=bar

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized(lock) {
                while (turn != 0) lock.wait();
                
                printFoo.run();
                turn = 1;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
       for (int i = 0; i < n; i++) {
            synchronized(lock) {
                while (turn != 1) lock.wait();
                
                printBar.run();
                turn = 0;
                lock.notifyAll();
            }
        }
    }
}

// // using semaphores
// class FooBar {
//     private int n;
//     private Semaphore semaFoo = new Semaphore(1);
//     private Semaphore semaBar = new Semaphore(0);

//     public FooBar(int n) {
//         this.n = n;
//     }

//     public void foo(Runnable printFoo) throws InterruptedException {
//         for (int i = 0; i < n; i++) {
//             semaFoo.acquire();
//             printFoo.run();
//             semaBar.release();
//         }
//     }

//     public void bar(Runnable printBar) throws InterruptedException {
//        for (int i = 0; i < n; i++) {
//             semaBar.acquire();
//             printBar.run();
//             semaFoo.release();
//         }
//     }
// }
// using notify wait
// class FooBar {
//     private int n;
//     private int turn = 0; // 0 = foo, 1 = bar
//     private Object lock = new Object();
//     int c1 = 0;
//     int c2 = 0;

//     public FooBar(int n) {
//         this.n = n;
//     }

//     public void foo(Runnable printFoo) throws InterruptedException {
        
//         while (c1 < n) {
//             synchronized(lock) {
//                 if (turn == 0) {
//                     printFoo.run();
//                     c1++;
//                     turn = 1;
//                     lock.notifyAll();
//                 }
//                 else {
//                     lock.wait();
//                 }
//             }
//         }
//     }

//     public void bar(Runnable printBar) throws InterruptedException {
        
//          while (c2 < n) {
//             synchronized(lock) {
//                 if (turn == 1) {
//                     printBar.run();
//                     c2++;
//                     turn = 0;
//                     lock.notifyAll();
//                 }
//                 else {
//                     lock.wait();
//                 }
//             }
//         }
//     }
// }