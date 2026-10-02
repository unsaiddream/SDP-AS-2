package delivery.core;

public interface DeliveryFactory {
    ShipmentProcessor createShipmentProcessor();

    RoutePlanner createRoutePlanner();

    TrackingService createTrackingService();

    DeliveryCreator createDeliveryCreator();
}
