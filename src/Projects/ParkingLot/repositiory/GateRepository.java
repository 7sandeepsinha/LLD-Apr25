package Projects.ParkingLot.repositiory;

import Projects.ParkingLot.model.Gate;

public interface GateRepository {
    Gate get(int id);
    void put(Gate gate);
}
