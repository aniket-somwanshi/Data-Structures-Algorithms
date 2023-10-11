
// synchronizing only shared variables section
// using one shared variable
class ZeroEvenOdd {
    private int n;
    
    private int currentTurn = 0;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            synchronized(this) {
                while (currentTurn != 0) {
                    wait();
                }
                printNumber.accept(0);
                currentTurn = i%2 == 1 ? 1 : 2;
                notifyAll();
            }
        }
    }

    public  void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            synchronized(this) {
                while (currentTurn != 2) {
                    wait();
                }
                printNumber.accept(i);
                currentTurn = 0;
                notifyAll();
            }
        }
    }

    public  void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            synchronized(this) {
                while (currentTurn != 1) {
                    wait();
                }
                printNumber.accept(i);
                currentTurn = 0;
                notifyAll();
            }
        }
    }
}
// // synchronization using one shared variable
// class ZeroEvenOdd {
//     private int n;
    
//     private int currentTurn = 0;
    
//     public ZeroEvenOdd(int n) {
//         this.n = n;
//     }

//     // printNumber.accept(x) outputs "x", where x is an integer.
//     public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
//         for (int i = 1; i <= n; i++) {
//             while (currentTurn != 0) {
//                 wait();
//             }
//             printNumber.accept(0);
//             currentTurn = i%2 == 1 ? 1 : 2;
//             notifyAll();
//         }
//     }

//     public synchronized void even(IntConsumer printNumber) throws InterruptedException {
//         for (int i = 2; i <= n; i+=2) {
//             while (currentTurn != 2) {
//                 wait();
//             }
//             printNumber.accept(i);
//             currentTurn = 0;
//             notifyAll();
//         }
//     }

//     public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
//         for (int i = 1; i <= n; i+=2) {
//             while (currentTurn != 1) {
//                 wait();
//             }
//             printNumber.accept(i);
//             currentTurn = 0;
//             notifyAll();
//         }
//     }
// }

// // semaphore
// class ZeroEvenOdd {
//     private int n;
    
//     private Semaphore semaZero = new Semaphore(1);
//     private Semaphore semaOdd = new Semaphore(1);
//     private Semaphore semaEven = new Semaphore(0);
    
//     private boolean isZeroNeeded = true;
//     private int i = 1;
    
//     public ZeroEvenOdd(int n) {
//         this.n = n;
//     }

//     // printNumber.accept(x) outputs "x", where x is an integer.
//     public void zero(IntConsumer printNumber) throws InterruptedException {
//         while (i <= n) {
//             if (isZeroNeeded) {
//                 semaZero.acquire();
//                 if (i > n) {
//                     return;
//                 }
//                 printNumber.accept(0);
//                 isZeroNeeded = false;
//             }
//         }
//     }

//     public void even(IntConsumer printNumber) throws InterruptedException {
//         while (i <= n) {
//             if (!isZeroNeeded && i%2 == 0) {
//                 semaEven.acquire();
//                 if (i > n) {
//                     semaOdd.release();
//                     semaZero.release();
//                     return;
//                 }
//                 printNumber.accept(i);
//                 i++;
//                 isZeroNeeded = true;
//                 semaOdd.release();
//                 semaZero.release();
//             }
//         }
//     }

//     public void odd(IntConsumer printNumber) throws InterruptedException {
//         while (i <= n) {
//             if (!isZeroNeeded && i%2 == 1) {
//                 semaOdd.acquire();
//                 if (i > n) {
//                     semaEven.release();
//                     semaZero.release();
//                     return;
//                 }
//                 printNumber.accept(i);
//                 i++;
//                 isZeroNeeded = true;
//                 semaEven.release();
//                 semaZero.release();
//             }
//         }
//     }
// }

// wait notify
// class ZeroEvenOdd {
//     private int n;
//     private Object lock = new Object();
//     private boolean isZeroNeeded = true;
//     private int i = 1;
    
//     public ZeroEvenOdd(int n) {
//         this.n = n;
//     }

//     // printNumber.accept(x) outputs "x", where x is an integer.
//     public void zero(IntConsumer printNumber) throws InterruptedException {
//         while (true) {
            
//             synchronized (lock) {
//             if (i > n) {
//                 lock.notifyAll();
//                 return;
//             }
            
//             if (isZeroNeeded) {
//                 printNumber.accept(0);
//                 isZeroNeeded = false;
//                 lock.notifyAll();
//             }
//             else {
//                 lock.wait();
//             }
//             }
//         }
//     }

//     public void even(IntConsumer printNumber) throws InterruptedException {
//         while (true) {
//             synchronized (lock) {
//             if (i > n) {
//                 lock.notifyAll();
//                 return;
//             }
            
//             if (!isZeroNeeded && i%2 == 0) {
//                 printNumber.accept(i);
//                 i++;
//                 isZeroNeeded = true;
//                 lock.notifyAll();
//             }
//             else {
//                 lock.wait();
//             }
//             }
//         }
//     }

//     public void odd(IntConsumer printNumber) throws InterruptedException {
//         while (true) {
//             synchronized (lock) {
//             if (i > n) {
//                 lock.notifyAll();
//                 return;
//             }
            
//             if (!isZeroNeeded && i%2 == 1) {
//                 printNumber.accept(i);
//                 i++;
//                 isZeroNeeded = true;
//                 lock.notifyAll();
//             }
//             else {
//                 lock.wait();
//             }
//             }
//         }
//     }
// }