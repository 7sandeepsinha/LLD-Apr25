package oops;

public class ElectricCar extends Car{
    public int batteryCapacity;

    public ElectricCar(int noOfWheels, String headLight, String brakeLight, int batteryCapacity){
        super(noOfWheels, headLight, brakeLight);
        this.batteryCapacity = batteryCapacity;
    }

    public ElectricCar(int noOfWheels){
        super(noOfWheels); // super. and super() // super() -> means calling the parent constructor with required values// super() should always be the first time of the constructor
        System.out.println("Inside ElectricCar");
    }

    public ElectricCar(String headLight, String brakeLight){
        super(headLight, brakeLight);
        System.out.println("Inside ElectricCar");
    }

    public ElectricCar() {
        super();
    }

    public void printElectricCarWheels(){
        System.out.println("NoOfWheels : " + super.getNoOfWheels());
    }

    @Override // does nothing, just for better readability and verifies override || adding or removing this wont impact method overriding
    public void startEngine(){
        super.startEngine(); // call any method from parent you can use super keyword
        this.chargeBattery(); // call any method present inside the same class
        System.out.println("Starting electric motor from battery in electric car");
    }

    public void chargeBattery(){
        System.out.println("Hey charging battery");
    }
}
// super == parent