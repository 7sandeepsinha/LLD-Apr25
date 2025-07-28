package Projects.ParkingLot.repositiory;

import Projects.ParkingLot.model.ParkingLot;
import Projects.ParkingLot.model.ParkingSpot;

public interface ParkingSpotRepository {
    ParkingSpot get(int parkingSpotId);
    void put(ParkingSpot parkingSpot);
}
