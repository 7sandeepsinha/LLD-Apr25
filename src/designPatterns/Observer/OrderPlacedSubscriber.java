package designPatterns.Observer;

// any class implementing this interface would become
// subscriber to order placed event, and would trigger orderPlaceAction()
public interface OrderPlacedSubscriber {
    void orderPlaceAction();
}
