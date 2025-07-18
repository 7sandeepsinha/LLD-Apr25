package advancedConcepts;

import oops.Student;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Car c = new Car(4, "Car");


        /*
        Calculator<String, String> strCalculator = new Calculator<>("A", "B");
        strCalculator.print("A", "B");

        Calculator<Integer, String> intStrCalculator = new Calculator<>(12, "B");
        intStrCalculator.print(12, "B");

        Calculator<Boolean, Boolean> booleanCal = new Calculator<>(true, true); // raw data type --- backward compatibility - not recommended

        HashMap<String, Student> studentMap = new HashMap<>();
        Set<String> stringSet = new HashSet<>();
        List<Student> students = new ArrayList<>();

        // ClassName objName = new ClassName();
        // ---> new ClassName(); -- supported for generics -- NOT RECOMMENDED -- Raw Data Type
        // ---> new ClassName<>(); -- supported for generics --- RECOMMENDED

        // Integer -- int
        // Boolean -- boolean
        // Double -- double -----> wrapper classes
        // Generics only support objects -> Object class
        // Generics dont support primitive variables, it only supports object as it built on top of object class
        // We need to use wrapper classes for primitive variables

        // Wrapper class -> primitive variables inside a class
        Integer i = 10;
        int x = i;

        int y = 10;
        Integer z = y;
        // auto-boxing -> automatically converting wrapper class object to primitive and vice-versa
        /

        Animal animal = new Animal();
        Dog dog = new Dog();

        print(animal);
        print(dog); // Animal animal = new Dog(); || upcasting

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal());
        animals.add(new Animal());

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());

        printList(animals);
        // printList(dogs); // upcasting inside generics does not work

        Printer<Animal> printer = new Printer<>();
        printer.print(animal);
        printer.print(dog);

        List<?> allList = new ArrayList<>(); // wildcard list
        List<? extends Animal> animalAndChildrenList = new ArrayList<>();
        List<? super Animal> animalAndParentList = new ArrayList<>();
        List<Animal> animalList = new ArrayList<>();

        HashMap<Integer, Animal> animalMap = new HashMap<>();

         */
        // Anonymous class - demo
        /*
        StatusNodeValidator statusNodeValidator = new StatusNodeValidator();
        statusNodeValidator.validate();

        ReviewNodeValidator reviewNodeValidator = new ReviewNodeValidator();
        reviewNodeValidator.validate();

        Validator statusNodeValidatorAC = new Validator() { // statusNodeValidatorAnonymousClass
            public boolean validate(){
                System.out.println("Anonymous class - status node validator");
                return true;
            }
        };
        statusNodeValidatorAC.validate();

        Validator reviewNodeValidatorAC = new Validator() {
            public boolean validate(){
                System.out.println("Anonymous class - review node validator");
                return true;
            }
        };
        reviewNodeValidatorAC.validate();

        // Anonymous class - Helps to create objects from an interface
        // definition of methods by giving their implementations

        InterfaceName objName = new InterfaceName() {
                //implement ALL methods for the interface --- ALL methods are mandatory
                public void method1(){
                }

                public void method2(){
                }
        };
         */

        // lambdas
        // lambas -> shorter code for anonymous class implementation, for FIs
        // statusNodeValidatorAnonymousClass

        Validator statusNodeValidatorAC = () -> {
                System.out.println("Anonymous class - status node validator");
                return true;
            };
        statusNodeValidatorAC.validate();

        Validator passValidatorLambda = () -> true;
        passValidatorLambda.validate();

        Validator statusNodeValidatorLambda = () -> {
            System.out.println("Anonymous class - status node validator");
            return true;
        };
        statusNodeValidatorAC.validate();

        // 1st option
        SingleLineValidator singleLineValidator = new SingleLineValidator();
        singleLineValidator.validate();

        //2nd option
        Validator singleLineValidatorAC = new Validator() {
            @Override
            public boolean validate() {
                return StaticValidation.validate();
            }
        };
        singleLineValidatorAC.validate();

        //3rd option
        Validator singleLineValidatorLambda = () -> StaticValidation.validate();
        singleLineValidatorLambda.validate();

        // task -> print helloworld from a different thread
        // implemented traditionally using class
        HelloWorldPrinter hwp = new HelloWorldPrinter();
        Thread thread = new Thread(hwp);
        thread.start();

        //implemented using lambda
        Runnable helloWorldPrinter =  () ->
                System.out.println("Hello World" + Thread.currentThread().getName());
        Thread thread1 = new Thread(helloWorldPrinter);
        thread1.start();

        //shorter
        Thread t2 = new Thread(
                () -> System.out.println("Hello World" + Thread.currentThread().getName())
        );
        t2.start();

        // int x = 1
        // int y = 2
        // add(x,y)
        // add(1,2)

    }

    public static void print(Animal animal){
        animal.print();
    }

    public static void printList(List<Animal> list){
        System.out.println("Printing from list method");
        for(int i=0;i<list.size();i++){
            list.get(i).print();
        }
    }
}

/*
                Animal
                Dog

                Animal is parent Animal --- NO

                List is parent List --- NO
                List<Animal> is at the same level as List<Dog> because both are nothing but lists
                so, List<Animal> is not parent of List<Dog>

 */