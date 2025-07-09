package designPatterns.Decorator;

// base-add-on -> it can be the first item, or could be an addon to existing ice cream
public class OrangeCone implements Icecream{

    private Icecream icecream;

    //when added as addon on existing ice-cream
    public OrangeCone(Icecream icecream) {
        this.icecream = icecream;
    }

    //when starting as base for a new ice-cream
    public OrangeCone() {
    }

    @Override
    public int getCost() {
        if(icecream == null){
            return 20;
        } else {
            return icecream.getCost() + 20;
        }
    }

    @Override
    public String getDescription() {
        if(icecream == null){
            return "Orange Cone";
        } else {
            return icecream.getDescription() + ", Orange Cone";
        }
    }
}
