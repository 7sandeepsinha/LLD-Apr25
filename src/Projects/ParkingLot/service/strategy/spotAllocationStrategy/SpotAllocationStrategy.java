package Projects.ParkingLot.service.strategy.spotAllocationStrategy;

import Projects.ParkingLot.model.ParkingLot;
import Projects.ParkingLot.model.ParkingSpot;
import Projects.ParkingLot.model.Vehicle;
import Projects.ParkingLot.model.constants.ParkingSpotType;

public interface SpotAllocationStrategy {
    ParkingSpot allocateSpot(ParkingLot parkingLot, Vehicle vehicle, ParkingSpotType parkingSpotType);
}
