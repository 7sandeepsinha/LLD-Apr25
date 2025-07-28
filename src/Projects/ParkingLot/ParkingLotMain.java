package Projects.ParkingLot;

import Projects.ParkingLot.repositiory.*;
import Projects.ParkingLot.service.InitialisationService;

public class ParkingLotMain {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepositoryImpl();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepositoryImpl();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepositoryImpl();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepositoryImpl();

        InitialisationService initialisationService = new InitialisationService(
               gateRepository, parkingLotRepository, parkingFloorRepository, parkingSpotRepository
        );
        initialisationService.init();
    }
}
