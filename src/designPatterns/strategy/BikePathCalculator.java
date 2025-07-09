package designPatterns.strategy;

public class BikePathCalculator implements  PathCalculator{
    @Override
    public void findPath(String source, String destination) {
        //algo for finding path via Bike
        System.out.println("Find path via Bike");
    }
}
