public class CityRoutePlanner {
    public String plan(Parcel parcel) {
        String route = parcel.getOrigin()
                + " -> local courier hub -> "
                + parcel.getDestination();

        System.out.println("City route: " + route);
        return route;
    }
}