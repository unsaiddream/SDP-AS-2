public class DeliveryApplication {
    public static void main(String[] args) {
        Parcel parcel = new Parcel(
                "1001",
                "Almaty, Abay Avenue 10",
                "Almaty, Dostyk Avenue 50",
                2.5
        );

        CityShipmentProcessor processor = new CityShipmentProcessor();
        CityRoutePlanner planner = new CityRoutePlanner();
        CityTrackingService tracking = new CityTrackingService();

        String shipmentId = processor.process(parcel);
        String route = planner.plan(parcel);
        String status = tracking.track(shipmentId, route);

        System.out.println("Final status: " + status);
    }
}