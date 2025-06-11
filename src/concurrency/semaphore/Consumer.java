package concurrency.semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Queue<Shirt> store;
    private String name;
    private Semaphore semaProducer;
    private Semaphore semaConsumer;

    public Consumer(Queue<Shirt> store, String name, Semaphore semaProducer, Semaphore semaConsumer) {
        this.store = store;
        this.name = name;
        this.semaProducer = semaProducer;
        this.semaConsumer = semaConsumer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaConsumer.acquire(); // decreases the number of key for consumer by 1
                System.out.println("Current size : " + store.size() +
                        ", removed by Consumer : " + name);
                store.remove();
                semaProducer.release(); // increases the number of key for producer by 1
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
