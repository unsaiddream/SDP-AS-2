package delivery.core;

import delivery.model.Parcel;

public abstract class DeliveryCreator {
    protected abstract ShipmentProcessor createProcessor();

    public String register(Parcel parcel) {
        if (parcel.getWeightKg() <= 0) {
            throw new IllegalArgumentException("Parcel weight must be positive");
        }

        if (parcel.getOrigin() == null || parcel.getOrigin().isBlank()
                || parcel.getDestination() == null || parcel.getDestination().isBlank()) {
            throw new IllegalArgumentException("Origin and destination are required");
        }

        ShipmentProcessor processor = createProcessor();
        String shipmentId = processor.process(parcel);

        System.out.println("Registration receipt: " + shipmentId);
        return shipmentId;
    }
}
