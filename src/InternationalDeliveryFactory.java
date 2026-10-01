public class InternationalDeliveryFactory implements DeliveryFactory {
    @Override
    public ShipmentProcessor createShipmentProcessor() {
        return new InternationalShipmentProcessor();
    }

    @Override
    public RoutePlanner createRoutePlanner() {
        return new InternationalRoutePlanner();
    }

    @Override
    public TrackingService createTrackingService() {
        return new InternationalTrackingService();
    }

    @Override
    public DeliveryCreator createDeliveryCreator() {
        return new InternationalDeliveryCreator();
    }
}