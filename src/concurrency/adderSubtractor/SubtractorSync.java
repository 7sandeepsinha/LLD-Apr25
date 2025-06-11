package concurrency.adderSubtractor;

public class SubtractorSync implements Runnable{

    private Count count;

    public SubtractorSync(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10000; i++) {
            synchronized (count) {
                count.val--;
            }
        }
    }
}
