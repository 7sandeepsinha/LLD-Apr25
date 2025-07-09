package designPatterns.strategy;

public class PathCalculatorFactory {

    public static PathCalculator getPathCalculator(TransportMode mode){
        return switch (mode) {
            case CAR -> new CarPathCalculator();
            case BIKE -> new BikePathCalculator();
            case WALK -> new WalkPathCalculator();
        };
    }
}
