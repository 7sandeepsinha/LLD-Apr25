package Projects.ParkingLot.service.strategy.billCalculationStrategy;

public class BillCalculationStrategyFactory {
    public static BillCalculationStrategy getBillCalculationStrategy(PricingStrategy pricingStrategy){
        return switch (pricingStrategy) {
            case LINEAR -> new LinearBillCalculationStrategy();
            case SURGE ->  new SurgeBillCalculationStrategy();
        };
    }
}
