package delivery.family.city;

import delivery.core.ShipmentProcessor;
import delivery.model.Parcel;

public class CityShipmentProcessor implements ShipmentProcessor{
    public String process(Parcel parcel) {
        String shipmentId = "CITY-" + parcel.getId();

        System.out.println(
                "City shipment created: " + shipmentId
                        + ", weight: " + parcel.getWeightKg() + " kg"
        );

        return shipmentId;
    }
}
