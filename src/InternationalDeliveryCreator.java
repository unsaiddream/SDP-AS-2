public class InternationalDeliveryCreator extends DeliveryCreator {
    @Override
    protected ShipmentProcessor createProcessor() {
        return new InternationalShipmentProcessor();
    }
}