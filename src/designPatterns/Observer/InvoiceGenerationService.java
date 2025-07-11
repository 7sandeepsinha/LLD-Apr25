package designPatterns.Observer;

public class InvoiceGenerationService implements OrderPlacedSubscriber{
    @Override
    public void orderPlaceAction() {
        System.out.println("Generating invoice for the order placed");
    }
}
