package Projects.ParkingLot.repositiory;

import Projects.ParkingLot.exception.ParkingLotNotFoundException;
import Projects.ParkingLot.model.ParkingLot;
import Projects.ParkingLot.model.ParkingSpot;

import java.util.HashMap;
import java.util.Map;

public class ParkingSpotRepositoryImpl implements ParkingSpotRepository{
    private Map<Integer, ParkingSpot> parkingSpotMap;
    private static int idCounter = 1;

    public ParkingSpotRepositoryImpl() {
        this.parkingSpotMap = new HashMap<>();
    }

    @Override
    public ParkingSpot get(int parkingSpotId) {
        ParkingSpot parkingSpot = parkingSpotMap.get(parkingSpotId);
        if(parkingSpot == null) {
            throw new ParkingLotNotFoundException("Parking Lot does not exist");
        }
        return parkingSpot;
    }

    @Override
    public void put(ParkingSpot parkingSpot) {
        parkingSpot.setId(idCounter++);
        parkingSpotMap.put(parkingSpot.getId(), parkingSpot);
        System.out.println("Parking lot has been added successfully");
    }
}
