package designPatterns.Decorator;

//add on -> cant be base, can only be added on top of existing ice-cream
public class ChocolateSyrup implements Icecream{
    private Icecream icecream;

    //can only be added as addon on existing ice-cream
    public ChocolateSyrup(Icecream icecream) {
        this.icecream = icecream;
    }

    @Override
    public int getCost() {
        return icecream.getCost() + 25;
    }

    @Override
    public String getDescription() {
        return icecream.getDescription() + ", Chocolate Syrup";
    }
}
