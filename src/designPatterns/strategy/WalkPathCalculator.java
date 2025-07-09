package designPatterns.strategy;

public class WalkPathCalculator implements  PathCalculator{
    @Override
    public void findPath(String source, String destination) {
        //algo for finding path via Walk
        System.out.println("Find path via Walk");
    }
}
