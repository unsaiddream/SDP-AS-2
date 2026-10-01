public class DeliveryApplication {
    public static void main(String[] args) {
        String family = args.length > 0 ? args[0].toLowerCase() : "city";

        Parcel parcel = new Parcel(
                "1001",
                "Almaty",
                "Astana",
                2.5
        );

        DeliveryFactory factory;

        switch (family) {
            case "city":
                factory = new CityDeliveryFactory();
                break;

            case "intercity":
                factory = new IntercityDeliveryFactory();
                break;

            case "international":
                factory = new InternationalDeliveryFactory();
                break;

            default:
                System.out.println("Unknown delivery family: " + family);
                System.out.println("Use: city, intercity or international");
                return;
        }

        DeliveryCreator creator = factory.createDeliveryCreator();
        RoutePlanner planner = factory.createRoutePlanner();
        TrackingService tracking = factory.createTrackingService();

        String shipmentId = creator.register(parcel);
        String route = planner.plan(parcel);
        String status = tracking.track(shipmentId, route);

        System.out.println("Final status: " + status);
    }
}