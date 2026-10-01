public class IntercityDeliveryFactory implements DeliveryFactory {
    @Override
    public ShipmentProcessor createShipmentProcessor() {
        return new IntercityShipmentProcessor();
    }

    @Override
    public RoutePlanner createRoutePlanner() {
        return new IntercityRoutePlanner();
    }

    @Override
    public TrackingService createTrackingService() {
        return new IntercityTrackingService();
    }

    @Override
    public DeliveryCreator createDeliveryCreator() {
        return new IntercityDeliveryCreator();
    }
}