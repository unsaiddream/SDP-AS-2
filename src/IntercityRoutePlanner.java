public class IntercityRoutePlanner {
    public String plan(Parcel parcel) {
        String route = parcel.getOrigin()
                + " -> regional sorting center -> "
                + parcel.getDestination();

        System.out.println("Intercity route: " + route);
        return route;
    }
}