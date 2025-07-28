package Projects.ParkingLot.repositiory;

import Projects.ParkingLot.exception.ParkingLotNotFoundException;
import Projects.ParkingLot.model.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepositoryImpl implements ParkingLotRepository{
    private Map<Integer, ParkingLot> parkingLotMap;
    private static int idCounter = 1;

    public ParkingLotRepositoryImpl() {
        this.parkingLotMap = new HashMap<>();
    }

    @Override
    public ParkingLot get(int parkingLotId) {
        ParkingLot parkingLot = parkingLotMap.get(parkingLotId);
        if(parkingLot == null) {
            throw new ParkingLotNotFoundException("Parking Lot does not exist");
        }
        return parkingLot;
    }

    @Override
    public void put(ParkingLot parkingLot) {
        parkingLot.setId(idCounter++);
        parkingLotMap.put(parkingLot.getId(), parkingLot);
        System.out.println("Parking lot has been added successfully");
    }
}
