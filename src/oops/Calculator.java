package oops;

public class Calculator {
    //method overloading

    public void add(int x, int y) {
        System.out.println(x+y);
    }  // add(int,int)

    public void add(double x, int y){
        System.out.println(x+y);
    } // add(double,int)

    public void add(int x, double y){
        System.out.println(x+y);
    } // add(int,double)

    public void add(double x, double y){
        System.out.println(x+y);
    } // add(double,double)
}

/*
        Class(int, int)
        Java identifies a method by its method signature, not by the method name
        Method Signature -> name + corresponding args with data types

 */