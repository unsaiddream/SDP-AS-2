public class IntercityDeliveryCreator extends DeliveryCreator {
    @Override
    protected ShipmentProcessor createProcessor() {
        return new IntercityShipmentProcessor();
    }
}