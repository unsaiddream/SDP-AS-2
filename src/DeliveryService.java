public class DeliveryService {
    private final DeliveryFactory factory;

    public DeliveryService(DeliveryFactory factory) {
        if (factory == null) {
            throw new IllegalArgumentException("Delivery factory is required");
        }

        this.factory = factory;
    }

    public String deliver(Parcel parcel) {
        DeliveryCreator creator = factory.createDeliveryCreator();
        RoutePlanner planner = factory.createRoutePlanner();
        TrackingService tracking = factory.createTrackingService();

        String shipmentId = creator.register(parcel);
        String route = planner.plan(parcel);
        String status = tracking.track(shipmentId, route);

        System.out.println("Final status: " + status);
        return status;
    }
}