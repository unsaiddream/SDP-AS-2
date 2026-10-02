package delivery.family.international;

import delivery.core.DeliveryCreator;
import delivery.core.DeliveryFactory;
import delivery.core.RoutePlanner;
import delivery.core.ShipmentProcessor;
import delivery.core.TrackingService;

public class InternationalDeliveryFactory implements DeliveryFactory {
    @Override
    public ShipmentProcessor createShipmentProcessor() {
        return new InternationalShipmentProcessor();
    }

    @Override
    public RoutePlanner createRoutePlanner() {
        return new InternationalRoutePlanner();
    }

    @Override
    public TrackingService createTrackingService() {
        return new InternationalTrackingService();
    }

    @Override
    public DeliveryCreator createDeliveryCreator() {
        return new InternationalDeliveryCreator();
    }
}
