package designPatterns.Decorator;

//add on -> cant be base, can only be added on top of existing ice-cream
public class VanillaScoop implements Icecream{
    private Icecream icecream;

    //can only be added as addon on existing ice-cream
    public VanillaScoop(Icecream icecream) {
        this.icecream = icecream;
    }

    @Override
    public int getCost() {
        return icecream.getCost() + 40;
    }

    @Override
    public String getDescription() {
        return icecream.getDescription() + ", Vanilla Scoop";
    }
}
