public class CityDeliveryFactory implements DeliveryFactory {
    @Override
    public ShipmentProcessor createShipmentProcessor() {
        return new CityShipmentProcessor();
    }

    @Override
    public RoutePlanner createRoutePlanner() {
        return new CityRoutePlanner();
    }

    @Override
    public TrackingService createTrackingService() {
        return new CityTrackingService();
    }

    @Override
    public DeliveryCreator createDeliveryCreator() {
        return new CityDeliveryCreator();
    }
}