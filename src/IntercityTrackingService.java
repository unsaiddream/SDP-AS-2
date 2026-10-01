public class IntercityTrackingService {
    public String track(String shipmentId, String route) {
        String status = "Arrived at regional sorting center: " + shipmentId;

        System.out.println("Tracking: " + status);
        System.out.println("Tracking route: " + route);

        return status;
    }
}