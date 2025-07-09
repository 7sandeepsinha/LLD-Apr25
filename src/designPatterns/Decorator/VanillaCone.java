package designPatterns.Decorator;

// base-add-on -> it can be the first item, or could be an addon to existing ice cream
public class VanillaCone implements Icecream{

    private Icecream icecream;

    //when added as addon on existing ice-cream
    public VanillaCone(Icecream icecream) {
        this.icecream = icecream;
    }

    //when starting as base for a new ice-cream
    public VanillaCone() {
    }

    @Override
    public int getCost() {
        if(icecream == null){
            return 15;
        } else {
            return icecream.getCost() + 15;
        }
    }

    @Override
    public String getDescription() {
        if(icecream == null){
            return "Vanilla Cone";
        } else {
            return icecream.getDescription() + ", Vanilla Cone";
        }
    }
}
