public class CityTrackingService implements TrackingService{
    public String track(String shipmentId, String route) {
        String status = "Courier assigned for " + shipmentId;

        System.out.println("Tracking: " + status);
        System.out.println("Tracking route: " + route);

        return status;
    }
}