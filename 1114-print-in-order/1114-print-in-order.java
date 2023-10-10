// using semaphores
class Foo {
    private Semaphore semaphore1;
    private Semaphore semaphore2;
    public Foo() {
        semaphore1 = new Semaphore(0);
        semaphore2 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        semaphore1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore1.acquire();
        printSecond.run();
        semaphore2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphore2.acquire();
        printThird.run();
        semaphore2.release();
    }
}
// using lock and notify wait
// class Foo {
//     private Object lock;
//     boolean oneDone;
//     boolean twoDone;
//     public Foo() {
//         lock = new Object();
//     }

//     public void first(Runnable printFirst) throws InterruptedException {
//         synchronized (lock) {
//             printFirst.run();
//             oneDone = true;
//             lock.notifyAll();
//         }
//     }

//     public void second(Runnable printSecond) throws InterruptedException {
//         synchronized (lock) {
//             while (!oneDone) {
//                 lock.wait();
//             } 
//             printSecond.run();
//             twoDone = true;
//             lock.notifyAll();
//         }
        
//     }

//     public void third(Runnable printThird) throws InterruptedException {
//         synchronized (lock) {
//             while (!twoDone) {
//                 lock.wait();
//             }
//             printThird.run();
//         }
        
//     }
// }