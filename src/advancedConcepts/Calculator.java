package advancedConcepts;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Calculator<X,Y> {

    private X x;
    private Y y;

    public Calculator(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public void chooseOperation(int operationType, int a, int b) throws FileNotFoundException, InterruptedException {
        if(operationType == 1){
            divide(a, b);
        } else if (operationType == 2){
            add(a,b);
        } else {
            throw new CalculatorException("Invalid operation type");
        }
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

    public void add(int a, int b){
        System.out.println(a+b);
    }

    // here, just `throws Exception` can do the job but mentioning the specific exceptions is better for readability
    public void divide(int a, int b) throws FileNotFoundException, InterruptedException {
        System.out.println(a/b); // Arithmetic Exception -> runtimeException -> no need for any keyword for throwing exception upwards
        FileReader fileReader = new FileReader("someFileName");
        // FileNotFoundException -> compileTimeException -> using `throws` to propagate exception upwards is mandatory
        Thread.sleep(100);
    }

    // run time exception -> exception propagated upwards automatically -- IMPLICIT
    // compile exception -> either handle with try/catch or propagate upwards using "throws" --- EXPLICIT


    // divide method with try/catch -> handling exception inside the method
    /*
    public void divide(int a, int b){
        System.out.println("Entered Divide method");
        try{
            System.out.println(a/b);
            String str = "str";
            str.length();
            int[] arr = new int[3];
            arr[3] = 2; // ArrayIndexOutOfBoundsException
        } catch (ArithmeticException e) { // ALWAYS GO FROM SPECIFIC TO GENERIC EXCEPTION - TOP DOWN IN CATCH BLOCK
            System.out.println("Divide by zero");
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("String was null");
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("Something went wrong");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("Exit Divide Method");
    }

     */
}
// Yes - up, no - down
// Inside try block -> we put the code that can throw an exception
// Catch block -> try to add the possible exception that could be thrown inside the try block
// Catch block -> we put the code that can help us debug our exception easily
// try will always be present either with `catch` or `finally`