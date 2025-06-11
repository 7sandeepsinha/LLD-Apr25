package concurrency.adderSubtractor;

import java.util.concurrent.locks.ReentrantLock;

public class AdderMutex implements Runnable{

    private Count count;
    private ReentrantLock mutex;

    public AdderMutex(Count count, ReentrantLock mutex) {
        this.count = count;
        this.mutex = mutex;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10000; i++) {
            mutex.lock();
            count.val++;
            mutex.unlock();
        }
    }
}
