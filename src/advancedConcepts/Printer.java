package advancedConcepts;

public class Printer<P extends Animal>{

    public void print(P p) {
        p.print();
    }
}
