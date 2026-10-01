public class DeliveryApplication {
    public static void main(String[] args) {
        String family = args.length > 0 ? args[0] : "city";

        Parcel parcel = new Parcel(
                "1001",
                "Warehouse A",
                "Customer B",
                2.5
        );

        try {
            DeliveryFactory factory = DeliveryFactorySelector.select(family);
            DeliveryService service = new DeliveryService(factory);
            service.deliver(parcel);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            System.out.println("Use: city, intercity or international");
        }
    }
}