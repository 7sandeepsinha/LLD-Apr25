package designPatterns.Decorator;

//add on -> cant be base, can only be added on top of existing ice-cream
public class ChocolateScoop implements Icecream{
    private Icecream icecream;

    //can only be added as addon on existing ice-cream
    public ChocolateScoop(Icecream icecream) {
        this.icecream = icecream;
    }

    @Override
    public int getCost() {
        return icecream.getCost() + 60;
    }

    @Override
    public String getDescription() {
        return icecream.getDescription() + ", Chocolate Scoop";
    }
}
