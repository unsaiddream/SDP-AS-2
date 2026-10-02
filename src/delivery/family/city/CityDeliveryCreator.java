package delivery.family.city;

import delivery.core.DeliveryCreator;
import delivery.core.ShipmentProcessor;

public class CityDeliveryCreator extends DeliveryCreator {
    @Override
    protected ShipmentProcessor createProcessor() {
        return new CityShipmentProcessor();
    }
}
