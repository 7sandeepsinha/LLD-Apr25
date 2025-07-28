package Projects.ParkingLot.service.strategy.billCalculationStrategy;

import Projects.ParkingLot.model.ParkingLot;
import Projects.ParkingLot.model.Ticket;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SurgeBillCalculationStrategy implements BillCalculationStrategy{
    private static double BASIC_RATE = 50;
    private static double HOURLY_RATE = 40;
    private static double L1_SURGE = 1.2; // 50% occupied
    private static double L2_SURGE = 1.65; // 75%
    private static double L3_SURGE = 2; // 90%

    @Override
    public double calculateAmount(ParkingLot parkingLot, Ticket ticket) {
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();
        double amount = calculateLinearBillAmount(ticket);

        double occupancyRate = parkingLot.getOccupiedSlots() / parkingLot.getCapacity();
        if(occupancyRate >= 0.5 && occupancyRate < 0.75){
            amount = amount * L1_SURGE;
        } else if(occupancyRate >= 0.75 && occupancyRate < 0.9){
            amount = amount * L2_SURGE;
        } else if(occupancyRate >= 0.9) {
            amount = amount * L3_SURGE;
        }
        return amount;
    }

    private double calculateLinearBillAmount(Ticket ticket) {
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();
        boolean basicRateCalculated = false;
        double amount = 0;

        long numberOfSeconds = ChronoUnit.SECONDS.between(entryTime, exitTime);
        while(numberOfSeconds > 0){
            if(!basicRateCalculated){
                amount = amount + BASIC_RATE;
                basicRateCalculated = true;
            } else {
                amount = amount + HOURLY_RATE;
            }
            numberOfSeconds = numberOfSeconds - 3600;
        }
        return amount;
    }
}
/*
 Linear Pricing -> 3 hours  -> cost -> 50 + 40* 2 = 130
 Surge Pricing -> 80% occupancy -> 3 hours -> cost -> 50 + 40*2 => 130 => Surge 130 * 1.65 -> 214.5 Rs
 */