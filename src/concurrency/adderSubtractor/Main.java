package concurrency.adderSubtractor;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /*
        // ReentrantLock mutex = new ReentrantLock();
        Count count = new Count(0);
//        AdderMutex adder = new AdderMutex(count, mutex);
//        SubtractorMutex subtractor = new SubtractorMutex(count, mutex);

        AdderSync adderSync = new AdderSync(count);
        SubtractorSync subtractorSync = new SubtractorSync(count);

        Thread addThread = new Thread(adderSync);
        Thread subtrThread = new Thread(subtractorSync);

        addThread.start();
        subtrThread.start();

        addThread.join(); // makes the main thread wait until the thread does not complete execution
        subtrThread.join();

        System.out.println("Count - " + count.val);

         */
        AtomicInteger count = new AtomicInteger(0);
        AdderAtomicInteger adderAtomicInteger = new AdderAtomicInteger(count);
        SubtractorAtomicInteger subtractorAtomicInteger  = new SubtractorAtomicInteger(count);

        Thread t1 = new Thread(adderAtomicInteger);
        Thread t2 = new Thread(subtractorAtomicInteger);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count : " + count.get());
    }
}
