// semaphores for each type
class FizzBuzz {
    private int n;
    private int i = 1;
    Semaphore fizzS = new Semaphore(0);
    Semaphore buzzS = new Semaphore(0);
    Semaphore fizzBuzzS = new Semaphore(0);
    Semaphore numS = new Semaphore(1);
    public FizzBuzz(int n) {
        this.n=n;
    }
    
    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (i <= n) {
            fizzS.acquire();
            if (i <= n) {
                printFizz.run();
                releaseNextDonny();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (i <= n) {
            buzzS.acquire();
            if (i <= n) {
                printBuzz.run();
                releaseNextDonny();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
       while (i <= n) {
            fizzBuzzS.acquire();
            if (i <= n) {
                printFizzBuzz.run();
                releaseNextDonny();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            numS.acquire();
            if (i <= n) {
                printNumber.accept(i);
                releaseNextDonny();
            }
        }
    }
    
    private void releaseNextDonny() {
        i++;
        if (i <= n) {
            if (i%3==0 && i%5==0) {
                fizzBuzzS.release();
            }
            else if (i%3==0) {
                fizzS.release();
            }
            else if (i%5==0) {
                buzzS.release();
            }
            else {
                numS.release();
            }
        }
        else {
            fizzBuzzS.release();
            fizzS.release();
            buzzS.release();
            numS.release();
        }
    }
}

// wait and notify for optimization
// class FizzBuzz {
//     private int n;
//     private int i = 1;
//     private Object lock = new Object(); 
//     public FizzBuzz(int n) {
//         this.n=n;
//     }
    
//     // printFizz.run() outputs "fizz".
//     public void fizz(Runnable printFizz) throws InterruptedException {
//         while (i <= n) {
//             synchronized(lock) {
//                 if (i > n) return;
//                 if (i%3 == 0 && (i%5 != 0)) {
//                     printFizz.run();
//                     i++;
//                     lock.notifyAll();
//                 }
//                 else {
//                     lock.wait();
//                 }
//             }
//         }
//     }

//     // printBuzz.run() outputs "buzz".
//     public void buzz(Runnable printBuzz) throws InterruptedException {
//         while (i <= n) {
//             synchronized(lock) {
//                 if (i > n) return;
//             if (i%5 == 0 && (i%3 != 0)) {
//                 printBuzz.run();
//                 i++;
//                 lock.notifyAll();
//             }
//             else {
//                 lock.wait();
//             }
//             }
//         }
//     }

//     // printFizzBuzz.run() outputs "fizzbuzz".
//     public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
//        while (i <= n) {
//            synchronized(lock) {
//                if (i > n) return;
//             if (i%5 == 0 && i%3 == 0) {
//                 printFizzBuzz.run();
//                 i++;
//                 lock.notifyAll();
//             }
//             else {
//                 lock.wait();
//            }
//         }
//        }
//     }

//     // printNumber.accept(x) outputs "x", where x is an integer.
//     public void number(IntConsumer printNumber) throws InterruptedException {
//         while (i <= n) {
            
//             synchronized(lock) {
//             if (i > n) return;
//                 if (i%5 != 0 && i%3 != 0) {
                
//                 printNumber.accept(i);
//                 i++;
//                 lock.notifyAll();
//             }
//             else {
//                 lock.wait();
//             }
//         }
//     }
//     }
// }

// synchronization
// class FizzBuzz {
//     private int n;
//     private int i = 1;
//     public FizzBuzz(int n) {
//         this.n=n;
//     }

//     // printFizz.run() outputs "fizz".
//     public void fizz(Runnable printFizz) throws InterruptedException {
//         while (i <= n) {
//             synchronized(this) {
//             if (i > n) return;
//             if (i%3 == 0 && (i%5 != 0)) {
//                 printFizz.run();
//                 i++;
//             }
//             }
//         }
//     }

//     // printBuzz.run() outputs "buzz".
//     public void buzz(Runnable printBuzz) throws InterruptedException {
//         while (i <= n) {
//             synchronized(this) {
//                 if (i > n) return;
//             if (i%5 == 0 && (i%3 != 0)) {
//                 printBuzz.run();
//                 i++;
//             }
//             }
//         }
//     }

//     // printFizzBuzz.run() outputs "fizzbuzz".
//     public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
//        while (i <= n) {
//            synchronized(this) {
//                if (i > n) return;
//             if (i%5 == 0 && i%3 == 0) {
//                 printFizzBuzz.run();
//                 i++;
//             }
//            }
//         }
//     }

//     // printNumber.accept(x) outputs "x", where x is an integer.
//     public void number(IntConsumer printNumber) throws InterruptedException {
//         while (i <= n) {
            
//             synchronized(this) {
//             if (i > n) return;
//                 if (i%5 != 0 && i%3 != 0) {
                
//                 printNumber.accept(i);
//                 i++;
//             }
//             }
//         }
//     }
// }