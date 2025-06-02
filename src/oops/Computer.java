package oops;

public class Computer {
    private int ram;
    private static String cpuArch; // stored at class level

    public static void printRam(){
        //access ram
    }

    public void printCPUArch(){
        //access static cpuArch
    }
    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public static String getCpuArch() {
        return cpuArch;
    }

    public static void setCpuArch(String cpuArch) {
        Computer.cpuArch = cpuArch;
    }
}
