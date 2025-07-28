package Projects.ParkingLot.service.strategy.billCalculationStrategy;

import Projects.ParkingLot.model.ParkingLot;
import Projects.ParkingLot.model.Ticket;

public interface BillCalculationStrategy {
    double calculateAmount(ParkingLot parkingLot, Ticket ticket);
}
