package delivery.core;

import delivery.model.Parcel;

public interface RoutePlanner {
    String plan(Parcel parcel);
}
