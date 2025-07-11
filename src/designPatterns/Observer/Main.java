package designPatterns.Observer;

public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        CustomerNotificationService notificationService = new CustomerNotificationService();
        InvoiceGenerationService invoiceService = new InvoiceGenerationService();

        orderService.add(notificationService);
        orderService.add(invoiceService);

        orderService.placeOrder();
        orderService.placeOrder();
        orderService.placeOrder();
    }
}
