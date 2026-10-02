package delivery.family.express;

import delivery.core.TrackingService;
import delivery.model.DeliveryEvent;

public class ExpressTrackingService implements TrackingService {
    @Override
    public String track(String shipmentId, String route) {
        String status = "Priority courier assigned for " + shipmentId;

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
        String message = "Priority dispatch notified: " + event
                + ", shipment: " + shipmentId
                + ", route: " + route;

        System.out.println(message);
        return message;
    }
}
