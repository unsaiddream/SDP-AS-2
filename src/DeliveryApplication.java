public class DeliveryApplication {
    public static void main(String[] args) {
        String family = args.length > 0 ? args[0].toLowerCase() : "city";

        Parcel parcel = new Parcel(
                "1001",
                "Almaty",
                "Astana",
                2.5
        );

        String shipmentId;
        String route;
        String status;

        switch (family) {
            case "city":
                DeliveryCreator cityCreator = new CityDeliveryCreator();
                CityRoutePlanner cityPlanner = new CityRoutePlanner();
                CityTrackingService cityTracking = new CityTrackingService();

                shipmentId = cityCreator.register(parcel);
                route = cityPlanner.plan(parcel);
                status = cityTracking.track(shipmentId, route);
                break;

            case "intercity":
                DeliveryCreator intercityCreator = new IntercityDeliveryCreator();
                IntercityShipmentProcessor intercityProcessor =
                        new IntercityShipmentProcessor();
                IntercityRoutePlanner intercityPlanner =
                        new IntercityRoutePlanner();
                IntercityTrackingService intercityTracking =
                        new IntercityTrackingService();

                shipmentId = intercityCreator.register(parcel);
                route = intercityPlanner.plan(parcel);
                status = intercityTracking.track(shipmentId, route);
                break;

            case "international":
                DeliveryCreator internationalCreator = new InternationalDeliveryCreator();
                InternationalShipmentProcessor internationalProcessor =
                        new InternationalShipmentProcessor();
                InternationalRoutePlanner internationalPlanner =
                        new InternationalRoutePlanner();
                InternationalTrackingService internationalTracking =
                        new InternationalTrackingService();

                shipmentId = internationalCreator.register(parcel);
                route = internationalPlanner.plan(parcel);
                status = internationalTracking.track(shipmentId, route);
                break;

            default:
                System.out.println("Unknown delivery family: " + family);
                System.out.println("Use: city, intercity or international");
                return;
        }

        System.out.println("Final status: " + status);
    }
}