package delivery.family.intercity;

import delivery.core.RoutePlanner;
import delivery.model.Parcel;

public class IntercityRoutePlanner implements RoutePlanner{
    public String plan(Parcel parcel) {
        String route = parcel.getOrigin()
                + " -> regional sorting center -> "
                + parcel.getDestination();

        System.out.println("Intercity route: " + route);
        return route;
    }
}
