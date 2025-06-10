package concurrency;

public class NumberPrinter implements Runnable{
    private int n;

    public NumberPrinter(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        System.out.println("Number : " + n + ", Thread : " +
                Thread.currentThread().getName());
    }
}
