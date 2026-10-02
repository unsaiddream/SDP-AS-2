package delivery.family.express;

import delivery.core.DeliveryCreator;
import delivery.core.DeliveryFactory;
import delivery.core.RoutePlanner;
import delivery.core.ShipmentProcessor;
import delivery.core.TrackingService;

public class ExpressDeliveryFactory implements DeliveryFactory {
    @Override
    public ShipmentProcessor createShipmentProcessor() {
        return new ExpressShipmentProcessor();
    }

    @Override
    public RoutePlanner createRoutePlanner() {
        return new ExpressRoutePlanner();
    }

    @Override
    public TrackingService createTrackingService() {
        return new ExpressTrackingService();
    }

    @Override
    public DeliveryCreator createDeliveryCreator() {
        return new ExpressDeliveryCreator();
    }
}
