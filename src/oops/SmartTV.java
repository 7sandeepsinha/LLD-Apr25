package oops;

public class SmartTV extends TV{

    public void brightness(){
        System.out.println("Adjust brightness automatically");
    }

    @Override
    public void volume() {
        System.out.println("Adjust volume smartly");
    }
}

//3 methods -> 1 inherited, 1 inherited and overridden, 1 new
