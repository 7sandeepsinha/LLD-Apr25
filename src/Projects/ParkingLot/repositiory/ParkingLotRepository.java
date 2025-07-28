package Projects.ParkingLot.repositiory;

import Projects.ParkingLot.model.ParkingLot;

public interface ParkingLotRepository {
    ParkingLot get(int parkingLotId);
    void put(ParkingLot parkingLot);
}
