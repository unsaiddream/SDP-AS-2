public class InternationalShipmentProcessor {
    public String process(Parcel parcel) {
        String shipmentId = "INTERNATIONAL-" + parcel.getId();

        System.out.println(
                "International shipment created: " + shipmentId
                        + ", customs declaration required"
        );

        return shipmentId;
    }
}