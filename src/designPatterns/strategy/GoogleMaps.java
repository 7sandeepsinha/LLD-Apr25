package designPatterns.strategy;

public class GoogleMaps {

    public void findPath(String source, String destination, TransportMode mode){
        PathCalculator pc = PathCalculatorFactory.getPathCalculator(mode);
        pc.findPath(source, destination);
    }
}
