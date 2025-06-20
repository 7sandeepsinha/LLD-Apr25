package advancedConcepts;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        //divide(10,0);
        takeInput();
        Calculator<Integer, Integer> calculator = new Calculator(3,4);
        try {
            calculator.chooseOperation(3, 10, 10);
        } catch (ArithmeticException e) { // ALWAYS GO FROM SPECIFIC TO GENERIC EXCEPTION - TOP DOWN IN CATCH BLOCK
            System.out.println("Divide by zero");
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("String was null");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception e){
            System.out.println("Something went wrong");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void divide(int a, int b){
        System.out.println(a/b); // ArithmeticException -> Runtime Exception
    }

    public static void readFile(){
        try {
            FileReader fileReader = new FileReader("someFileName.txt"); // FileNotFoundException -> Compile time exeption
        } catch (FileNotFoundException e) {
            System.out.println("File is not present");
        }
    }

    public static void takeInput(){
        Scanner sc = new Scanner(System.in); // binds with the input I/O
        try {
            String str = sc.next();
            str = null;
            System.out.println(str.length());
        } catch (ArithmeticException e) {
            System.out.println("String was null");
        } finally {
            // used for cleaning up resources
            // always executes -> no matter what, exceptions happen, handled or not
            System.out.println("FInally block executed");
            sc.close(); // cleaning up scanner resource
        }
    }
}


// ArithmeticException -> Runtime Exception || Unchecked exception
// FileNotFoundException -> Compile Exception || Checked exception