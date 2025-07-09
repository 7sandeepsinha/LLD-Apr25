package designPatterns.strategy;

public class CarPathCalculator implements  PathCalculator{
    @Override
    public void findPath(String source, String destination) {
        //algo for finding path via car
        System.out.println("Find path via car");
    }
}
