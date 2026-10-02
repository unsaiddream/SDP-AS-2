package delivery.core;

import delivery.model.DeliveryEvent;

public interface TrackingService {
    String track(String shipmentId, String route);

    String recordEvent(
            String shipmentId,
            String route,
            DeliveryEvent event
    );
}
