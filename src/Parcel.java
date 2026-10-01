public class Parcel {
    private final String id;
    private final String origin;
    private final String destination;
    private final double weightKg;

    public Parcel(String id, String origin, String destination, double weightKg) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.weightKg = weightKg;
    }

    public String getId() {
        return id;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public double getWeightKg() {
        return weightKg;
    }
}