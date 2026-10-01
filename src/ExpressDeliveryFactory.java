public class ExpressDeliveryFactory implements DeliveryFactory {
    @Override
    public ShipmentProcessor createShipmentProcessor() {
        return new ExpressShipmentProcessor();
    }

    @Override
    public RoutePlanner createRoutePlanner() {
        return new ExpressRoutePlanner();
    }

    @Override
    public TrackingService createTrackingService() {
        return new ExpressTrackingService();
    }

    @Override
    public DeliveryCreator createDeliveryCreator() {
        return new ExpressDeliveryCreator();
    }
}