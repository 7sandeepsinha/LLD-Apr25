package concurrency.adderSubtractor;

import java.util.concurrent.atomic.AtomicInteger;

public class SubtractorAtomicInteger implements Runnable{

    private AtomicInteger count;

    public SubtractorAtomicInteger(AtomicInteger count) {
        this.count = count;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10000; i++) {
            count.getAndDecrement();
        }
    }
}
