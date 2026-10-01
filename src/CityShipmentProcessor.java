public class CityShipmentProcessor {
    public String process(Parcel parcel) {
        String shipmentId = "CITY-" + parcel.getId();

        System.out.println(
                "City shipment created: " + shipmentId
                        + ", weight: " + parcel.getWeightKg() + " kg"
        );

        return shipmentId;
    }
}