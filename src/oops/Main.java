package oops;

public class Main {
    public static void main(String[] args) {
        //constructors demo
        /*
        //default constructor
        Student student = new Student();
        student.id = 1;
        student.name = "Ravi";
        student.school = "ABC SCHOOL";
        student.print();

        //parameterised constructor
        Student st = new Student(10, "Ravi");
        st.print();

        //Copy constructor
        Iphone iphone13 = new Iphone(13, 13, 50000, "Iphone", "Apple", 6, 4, 3500);
        Iphone iphone14 = new Iphone(iphone13);
        Iphone iphone15 = new Iphone(iphone14);

        //deep and shallow copy
        Student std = new Student(12, "Anand");
        Student std1 = std;
        Student std2 = new Student(std);

         */

        //Inheritance Demo

        ElectricCar electricCar = new ElectricCar(4, "XEON LED", "MATRIX LED", 5000);
        electricCar.printCar();

        //Polymorphism Demo
        Calculator calculator = new Calculator();
        calculator.add(4,5);
        calculator.add(4.4,5);
        calculator.add(4,5.5);
        calculator.add(4.4,5.5);

        Car car = new Car();
        car.startEngine();

        ElectricCar ec = new ElectricCar();
        ec.startEngine();


        Computer c1 = new Computer();
        c1.setRam(4);
        Computer c2 = new Computer();
        c2.setRam(5);
        Computer c3 = new Computer();
        c3.setRam(6);

        System.out.println(c1.getRam());
        System.out.println(c2.getRam());
        System.out.println(c3.getRam());
        c1.setCpuArch("ARM");

        System.out.println(c3.getCpuArch());

        Computer.setCpuArch("ARM CPU");

        System.out.println(c2.getCpuArch());

        TV tv = new TV();
        tv.channel();
        tv.volume();

        SmartTV smartTV = new SmartTV();
        smartTV.channel();
        smartTV.volume();
        smartTV.brightness();

        System.out.println("------------");
        // old remote new tv || UPCASTING || IMPLICIT CASTING
        TV tvobj = new SmartTV(); // parent ref || child object --> works fine, with limited capability
        tvobj.volume();
        tvobj.channel();

        //new remote old tv || DOWNCASTING || EXPLICIT CASTING
        SmartTV smartObj = (SmartTV) new TV();
        smartObj.volume();
    }
}

/*
    Whenever you make a class, make all its attributes as private and then
    create public getters and setters

    Homework -
    1. Create static method and try to access non-static attributes from the class
    inside the method
    2. Create non-static method and try to access static attributes from the class
    inside the method
    3. Try to overload and override static methods

 */
