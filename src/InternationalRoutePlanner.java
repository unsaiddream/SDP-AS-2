public class InternationalRoutePlanner {
    public String plan(Parcel parcel) {
        String route = parcel.getOrigin()
                + " -> export customs -> international hub -> import customs -> "
                + parcel.getDestination();

        System.out.println("International route: " + route);
        return route;
    }
}