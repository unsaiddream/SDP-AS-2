package delivery.family.intercity;

import delivery.core.ShipmentProcessor;
import delivery.model.Parcel;

public class IntercityShipmentProcessor implements ShipmentProcessor{
    public String process(Parcel parcel) {
        String shipmentId = "INTERCITY-" + parcel.getId();

        System.out.println(
                "Intercity shipment created: " + shipmentId
                        + ", weight: " + parcel.getWeightKg() + " kg"
        );

        return shipmentId;
    }
}
