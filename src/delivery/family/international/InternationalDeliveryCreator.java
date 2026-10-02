package delivery.family.international;

import delivery.core.DeliveryCreator;
import delivery.core.ShipmentProcessor;

public class InternationalDeliveryCreator extends DeliveryCreator {
    @Override
    protected ShipmentProcessor createProcessor() {
        return new InternationalShipmentProcessor();
    }
}
