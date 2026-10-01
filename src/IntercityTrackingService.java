public class IntercityTrackingService implements TrackingService{
    public String track(String shipmentId, String route) {
        String status = "Arrived at regional sorting center: " + shipmentId;

        System.out.println("Tracking: " + status);
        System.out.println("Tracking route: " + route);

        return status;
    }
    @Override
    public String recordEvent(
            String shipmentId,
            String route,
            DeliveryEvent event
    ) {
        String message = "Regional sorting center notified: " + event
                + ", shipment: " + shipmentId
                + ", route: " + route;

        System.out.println(message);
        return message;
    }
}