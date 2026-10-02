package delivery.family.express;

import delivery.core.DeliveryCreator;
import delivery.core.ShipmentProcessor;

public class ExpressDeliveryCreator extends DeliveryCreator {
    @Override
    protected ShipmentProcessor createProcessor() {
        return new ExpressShipmentProcessor();
    }
}
