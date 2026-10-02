package delivery.family.international;

import delivery.core.ShipmentProcessor;
import delivery.model.Parcel;

public class InternationalShipmentProcessor implements ShipmentProcessor{
    public String process(Parcel parcel) {
        String shipmentId = "INTERNATIONAL-" + parcel.getId();

        System.out.println(
                "International shipment created: " + shipmentId
                        + ", customs declaration required"
        );

        return shipmentId;
    }
}
