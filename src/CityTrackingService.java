public class CityTrackingService implements TrackingService{
    public String track(String shipmentId, String route) {
        String status = "Courier assigned for " + shipmentId;

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
        String message = "City courier notified: " + event
                + ", shipment: " + shipmentId
                + ", route: " + route;

        System.out.println(message);
        return message;
    }
}