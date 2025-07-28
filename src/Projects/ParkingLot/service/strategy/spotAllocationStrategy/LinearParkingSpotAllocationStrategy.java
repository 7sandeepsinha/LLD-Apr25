package Projects.ParkingLot.service.strategy.spotAllocationStrategy;

import Projects.ParkingLot.exception.NoAvailableParkingSpotException;
import Projects.ParkingLot.model.ParkingFloor;
import Projects.ParkingLot.model.ParkingLot;
import Projects.ParkingLot.model.ParkingSpot;
import Projects.ParkingLot.model.Vehicle;
import Projects.ParkingLot.model.constants.ParkingSpotStatus;
import Projects.ParkingLot.model.constants.ParkingSpotType;

public class LinearParkingSpotAllocationStrategy implements SpotAllocationStrategy {

    @Override
    public ParkingSpot allocateSpot(ParkingLot parkingLot, Vehicle vehicle, ParkingSpotType parkingSpotType) {
        for(ParkingFloor floor : parkingLot.getParkingFloors()) {
            for(ParkingSpot spot : floor.getParkingSpots()) {
                if(spot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY)
                && spot.getVehicleType().equals(vehicle.getVehicleType())){
                    return spot;
                }
            }
        }
        throw new NoAvailableParkingSpotException("Parking lot is full");
    }
}
