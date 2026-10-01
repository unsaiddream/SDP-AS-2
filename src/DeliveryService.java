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

    public String reroute(String shipmentId, Parcel updatedParcel) {
        RoutePlanner planner = factory.createRoutePlanner();
        TrackingService tracking = factory.createTrackingService();

        String newRoute = planner.plan(updatedParcel);
        return tracking.recordEvent(
                shipmentId,
                newRoute,
                DeliveryEvent.REROUTED
        );
    }

    public String returnToSender(Parcel originalParcel) {
        Parcel returnParcel = new Parcel(
                originalParcel.getId() + "-RETURN",
                originalParcel.getDestination(),
                originalParcel.getOrigin(),
                originalParcel.getWeightKg()
        );

        DeliveryCreator creator = factory.createDeliveryCreator();
        RoutePlanner planner = factory.createRoutePlanner();
        TrackingService tracking = factory.createTrackingService();

        String returnShipmentId = creator.register(returnParcel);
        String returnRoute = planner.plan(returnParcel);

        return tracking.recordEvent(
                returnShipmentId,
                returnRoute,
                DeliveryEvent.RETURN_REQUESTED
        );
    }
}