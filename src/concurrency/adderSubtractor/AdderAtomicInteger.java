package concurrency.adderSubtractor;

import java.util.concurrent.atomic.AtomicInteger;

public class AdderAtomicInteger implements Runnable{

    private AtomicInteger count;

    public AdderAtomicInteger(AtomicInteger count) {
        this.count = count;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10000; i++) {
            count.getAndIncrement();
        }
    }
}
