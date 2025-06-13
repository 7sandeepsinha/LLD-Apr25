package advancedConcepts;

import oops.Student;

import java.util.*;

public class Main {
    public static void main(String[] args) {
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
        // ---> new ClassName(); -- supported for generics -- NOT RECOMMEDED
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
         */
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
