package delivery.core;

import delivery.model.Parcel;

public interface ShipmentProcessor {
    String process(Parcel parcel);
}
