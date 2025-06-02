package oops;

public class Car {
    private int noOfWheels;
    private String headLight;
    private String brakeLight;

    public Car() {
    }

    public Car(int noOfWheels, String headLight, String brakeLight) {
        this.noOfWheels = noOfWheels;
        this.headLight = headLight;
        this.brakeLight = brakeLight;
    }

    public Car(int noOfWheels){
        this.noOfWheels = noOfWheels;
       System.out.println("Prints from Car constructor");
    }

    public Car(String headLight, String brakeLight){
        this.headLight = headLight;
        this.brakeLight = brakeLight;
    }

    public void printCar(){
        System.out.println("No. of Wheels: " + noOfWheels);
        System.out.println("Head Light brand: " + headLight);
        System.out.println("Brake Light brand: " + brakeLight);
    }

    public void startEngine(){
        System.out.println("Start a normal car engine");
    }

    public int getNoOfWheels() {
        return noOfWheels;
    }

    public void setNoOfWheels(int noOfWheels) {
        this.noOfWheels = noOfWheels;
    }

    public String getHeadLight() {
        return headLight;
    }

    public void setHeadLight(String headLight) {
        this.headLight = headLight;
    }

    public String getBrakeLight() {
        return brakeLight;
    }

    public void setBrakeLight(String brakeLight) {
        this.brakeLight = brakeLight;
    }
}
