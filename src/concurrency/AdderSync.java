package concurrency;

public class AdderSync implements Runnable{

    private Count count;

    public AdderSync(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10000; i++) {
            synchronized (count) { // mutex.lock()
                count.val++;
            }// mutex.unlock();
        }
    }
}
