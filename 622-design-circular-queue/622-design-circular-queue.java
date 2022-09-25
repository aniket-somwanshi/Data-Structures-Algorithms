class MyCircularQueue {
    int[] a;
    int front, rear;
    public MyCircularQueue(int k) {
        a = new int[k];
        front = -1;
        rear = -1;
    }

    public boolean enQueue(int value) {
        if(isFull()) return false;   // if the queue is full, no more adding of elements possible.
        
        if(isEmpty()) {       // if the queue is empty and we are pushing the first value in queue.
            front = rear = 0;
            a[rear] = value;
            return true;
        }

        rear = (rear + 1) % a.length;    // if the queue has more than one value.
        a[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;   // if the queue is empty, then no value can be removed from it.
        
        if (front == rear) {      // if only one element is left in queue.
            front = -1;
            rear = -1;
            return true;
        }
        
        front = (front + 1) % a.length; // if the queue has more than one value.
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
            
        return a[front];
    }

    public int Rear() {
        if (isEmpty()) return -1;
            
        return a[rear];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % a.length == front;  // if the queue is full then rear's next will be front as it is a circularqueue.
    }
}