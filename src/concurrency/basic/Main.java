package concurrency.basic;

import concurrency.adderSubtractor.SubtractorSync;
import concurrency.adderSubtractor.AdderSync;
import concurrency.adderSubtractor.Count;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /*
        System.out.println("Hello world from thread : "
                + Thread.currentThread().getName());

        HelloWorldPrinter hwp = new HelloWorldPrinter();
        Thread t = new Thread(hwp);
        t.start();

        for(int i=1;i<=100;i++){
            NumberPrinter np = new NumberPrinter(i);
            Thread th = new Thread(np); // creation of thread
            th.start();
        }
         */
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
    }
}
// Java - by default - single threaded - main thread

// print Hello World from a different thread -> not main thread
//setup
// create a class for the task
// implement runnable interface in the class
// implement your task inside the run() method
//execution
// Create an object of the task class
// using task class object you create a thread
// start the thread

// Print 1-100, each with a different thread
//