package oops;

public class CalculatorImpl implements ICalculator{

    @Override
    public void add(int a, int b){
        System.out.println(a+b);
    }

    @Override
    public void subtract(int a, int b){
        System.out.println(a-b);
    }

    @Override
    public void multiply(int a, int b){
        System.out.println(a*b);
    }

    @Override
    public void divide(int a, int b){
        System.out.println(a/b);
    }
}


/*
Interface - forces the child class to implement the methods written in the interface
CLASS -> methods already available for implementation

Class 'CalculatorImpl' must either be declared abstract
or implement abstract method 'add(int, int)' in 'ICalculator'

Class 'CalculatorImpl' must either be declared abstract or\
 implement abstract method 'subtract(int, int)' in 'ICalculator'
 */