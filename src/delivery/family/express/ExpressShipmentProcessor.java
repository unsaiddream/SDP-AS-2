package delivery.family.express;

import delivery.core.ShipmentProcessor;
import delivery.model.Parcel;

public class ExpressShipmentProcessor implements ShipmentProcessor {
    @Override
    public String process(Parcel parcel) {
        String shipmentId = "EXPRESS-" + parcel.getId();

        System.out.println(
                "Priority shipment created: " + shipmentId
                        + ", weight: " + parcel.getWeightKg() + " kg"
        );

        return shipmentId;
    }
}
