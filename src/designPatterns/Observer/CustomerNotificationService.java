package designPatterns.Observer;

public class CustomerNotificationService implements OrderPlacedSubscriber{
    @Override
    public void orderPlaceAction() {
        System.out.println("Customer is being notified by something");
    }
}
