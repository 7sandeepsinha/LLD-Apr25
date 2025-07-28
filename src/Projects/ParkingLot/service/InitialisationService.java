package Projects.ParkingLot.service;

import Projects.ParkingLot.model.Gate;
import Projects.ParkingLot.model.ParkingFloor;
import Projects.ParkingLot.model.ParkingLot;
import Projects.ParkingLot.model.ParkingSpot;
import Projects.ParkingLot.model.constants.GateType;
import Projects.ParkingLot.model.constants.ParkingLotStatus;
import Projects.ParkingLot.model.constants.ParkingSpotStatus;
import Projects.ParkingLot.model.constants.VehicleType;
import Projects.ParkingLot.repositiory.GateRepository;
import Projects.ParkingLot.repositiory.ParkingFloorRepository;
import Projects.ParkingLot.repositiory.ParkingLotRepository;
import Projects.ParkingLot.repositiory.ParkingSpotRepository;

import java.util.ArrayList;
import java.util.List;

public class InitialisationService {
    private GateRepository gateRepository;
    private ParkingLotRepository parkingLotRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private ParkingSpotRepository parkingSpotRepository;

    public InitialisationService(GateRepository gateRepository, ParkingLotRepository parkingLotRepository, ParkingFloorRepository parkingFloorRepository, ParkingSpotRepository parkingSpotRepository) {
        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public ParkingLot init(){
        System.out.println("****Starting Initialisation****");

        //Creating a parking Lot object
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("Radhe Parking Center");
        parkingLot.setAddress("Somewhere inside a costly mall");
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        parkingLot.setCapacity(100);
        parkingLot.setVehicleTypesSupported(List.of(VehicleType.TWO_WHEELER, VehicleType.FOUR_WHEELER));

        List<ParkingFloor> floors = new ArrayList<>();
        //Running a loop to create 10 parking floor object
        for(int i=1;i<=10;i++){
            // Creating parkingFloor object
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setFloorNumber(i);
            List<ParkingSpot> spots = new ArrayList<>();
            //for each floor creating 10 parking spot objects
            for(int j=1;j<=10;j++){
                ParkingSpot parkingSpot = new ParkingSpot();
                parkingSpot.setNumber((i * 100)+ j);
                parkingSpot.setParkingSpotStatus(ParkingSpotStatus.EMPTY);
                parkingSpot.setVehicleType(VehicleType.FOUR_WHEELER);
                spots.add(parkingSpot);
                parkingSpotRepository.put(parkingSpot);
            }
            parkingFloor.setParkingSpots(spots);
            //creating entry gate object
            Gate entryGate = new Gate();
            entryGate.setId((i*1000) + 1);
            entryGate.setGateNumber(i*100 + 1);
            entryGate.setGateType(GateType.ENTRY_GATE);
            entryGate.setOperatorName("Operator : " + i + 1);
            parkingFloor.setEntryGate(entryGate);
            gateRepository.put(entryGate);

            //creating exit gate object
            Gate exitGate = new Gate();
            exitGate.setId((i*1000) + 2);
            exitGate.setGateNumber(i*100 + 2);
            exitGate.setGateType(GateType.EXIT_GATE);
            exitGate.setOperatorName("Operator : " + i + 2);
            parkingFloor.setExitGate(exitGate);
            gateRepository.put(exitGate);

            floors.add(parkingFloor); // adding the floor to floor list
            parkingFloorRepository.put(parkingFloor); // saving the floor to repository
        }
        parkingLot.setParkingFloors(floors);  // adding floor list to parking lot
        parkingLotRepository.put(parkingLot);
        return parkingLotRepository.get(1);
    }

}
