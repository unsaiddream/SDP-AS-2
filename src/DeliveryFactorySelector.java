import java.util.Locale;

public class DeliveryFactorySelector {
    public static DeliveryFactory select(String family) {
        if (family == null) {
            throw new IllegalArgumentException("Delivery family is required");
        }

        switch (family.toLowerCase(Locale.ROOT)) {
            case "city":
                return new CityDeliveryFactory();

            case "intercity":
                return new IntercityDeliveryFactory();

            case "international":
                return new InternationalDeliveryFactory();

            case "express":
                return new ExpressDeliveryFactory();

            default:
                throw new IllegalArgumentException(
                        "Unknown delivery family: " + family
                );
        }
    }
}