package delivery.family.express;

import delivery.core.RoutePlanner;
import delivery.model.Parcel;

public class ExpressRoutePlanner implements RoutePlanner {
    @Override
    public String plan(Parcel parcel) {
        String route = parcel.getOrigin()
                + " -> priority dispatch hub -> "
                + parcel.getDestination();

        System.out.println("Express route: " + route);
        return route;
    }
}
