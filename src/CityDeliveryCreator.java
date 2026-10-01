public class CityDeliveryCreator extends DeliveryCreator {
    @Override
    protected ShipmentProcessor createProcessor() {
        return new CityShipmentProcessor();
    }
}