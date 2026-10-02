package delivery.family.intercity;

import delivery.core.DeliveryCreator;
import delivery.core.ShipmentProcessor;

public class IntercityDeliveryCreator extends DeliveryCreator {
    @Override
    protected ShipmentProcessor createProcessor() {
        return new IntercityShipmentProcessor();
    }
}
