package delivery.family.international;

import delivery.core.TrackingService;
import delivery.model.DeliveryEvent;

public class InternationalTrackingService implements TrackingService{
    public String track(String shipmentId, String route) {
        String status = "Waiting for customs clearance: " + shipmentId;

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
        String message = "International logistics partner notified: " + event
                + ", shipment: " + shipmentId
                + ", route: " + route;

        System.out.println(message);
        return message;
    }
}
