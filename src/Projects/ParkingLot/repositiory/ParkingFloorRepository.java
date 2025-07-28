package Projects.ParkingLot.repositiory;

import Projects.ParkingLot.model.ParkingFloor;
import Projects.ParkingLot.model.ParkingLot;

public interface ParkingFloorRepository {
    ParkingFloor get(int id);
    void put(ParkingFloor parkingFloor);
}
