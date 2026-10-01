public class InternationalTrackingService implements TrackingService{
    public String track(String shipmentId, String route) {
        String status = "Waiting for customs clearance: " + shipmentId;

        System.out.println("Tracking: " + status);
        System.out.println("Tracking route: " + route);

        return status;
    }
}