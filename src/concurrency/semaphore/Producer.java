package concurrency.semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private Queue<Shirt> store;
    private String name;
    private int maxSize;
    private Semaphore semaProducer;
    private Semaphore semaConsumer;

    public Producer(Queue<Shirt> store, String name, int maxSize,
                    Semaphore semaProducer, Semaphore semaConsumer) {
        this.store = store;
        this.name = name;
        this.maxSize = maxSize;
        this.semaProducer = semaProducer;
        this.semaConsumer = semaConsumer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaProducer.acquire(); // decreases the number of key for producer by 1
                System.out.println("Current size : " + store.size() +
                        ", added by Producer : " + name);
                store.add(new Shirt());
                semaConsumer.release(); // increases the number of key for consumer by 1
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
