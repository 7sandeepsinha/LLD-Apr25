package advancedConcepts;

public class Calculator<X,Y> {

    private X x;
    private Y y;

    public Calculator(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public X print(X x, Y y) { // generic method
        System.out.println(x);
        System.out.println(y);
        return x;
    }

    public void printX(X x) { // generic
        System.out.println(x);
    }

    public void printY(Y y) { // generic method
        System.out.println(y);
    }
}
