package Projects.ParkingLot.service.strategy.spotAllocationStrategy;

public class SpotAllocationStrategyFactory {
    public static SpotAllocationStrategy getSpotAllocationStrategy(AllocationStrategy allocationStrategy) {
        //TODO: add switch case basis on the allocation strategy selected
        return new LinearParkingSpotAllocationStrategy();
    }
}
