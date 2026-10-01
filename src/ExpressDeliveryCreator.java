public class ExpressDeliveryCreator extends DeliveryCreator {
    @Override
    protected ShipmentProcessor createProcessor() {
        return new ExpressShipmentProcessor();
    }
}