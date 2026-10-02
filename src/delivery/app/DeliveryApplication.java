package delivery.app;

import delivery.core.DeliveryFactory;
import delivery.model.Parcel;
import delivery.service.DeliveryFactorySelector;
import delivery.service.DeliveryService;

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
            String deliveryStatus = service.deliver(parcel);
            System.out.println("Delivery result: " + deliveryStatus);

            Parcel updatedParcel = new Parcel(
                    parcel.getId(),
                    parcel.getOrigin(),
                    "New customer address",
                    parcel.getWeightKg()
            );

            String rerouteResult = service.reroute(
                    family.toUpperCase() + "-" + parcel.getId(),
                    updatedParcel
            );
            System.out.println("Reroute result: " + rerouteResult);

            String returnResult = service.returnToSender(parcel);
            System.out.println("Return result: " + returnResult);

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            System.out.println("Use: city, intercity, international or express");
        }
    }
}
