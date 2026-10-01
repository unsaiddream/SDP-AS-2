import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeliverySystemTest {
    private Parcel parcel() {
        return new Parcel("1001", "Warehouse A", "Customer B", 2.5);
    }

    private void assertFamily(
            DeliveryFactory factory,
            Class<? extends ShipmentProcessor> processorClass,
            Class<? extends RoutePlanner> plannerClass,
            Class<? extends TrackingService> trackingClass,
            Class<? extends DeliveryCreator> creatorClass,
            String prefix
    ) {
        assertEquals(processorClass, factory.createShipmentProcessor().getClass());
        assertEquals(plannerClass, factory.createRoutePlanner().getClass());
        assertEquals(trackingClass, factory.createTrackingService().getClass());
        assertEquals(creatorClass, factory.createDeliveryCreator().getClass());

        String shipmentId = factory.createDeliveryCreator().register(parcel());
        assertTrue(shipmentId.startsWith(prefix));
    }

    @Test
    void cityFactoryCreatesCityFamily() {
        assertFamily(new CityDeliveryFactory(),
                CityShipmentProcessor.class,
                CityRoutePlanner.class,
                CityTrackingService.class,
                CityDeliveryCreator.class,
                "CITY-");
    }

    @Test
    void intercityFactoryCreatesIntercityFamily() {
        assertFamily(new IntercityDeliveryFactory(),
                IntercityShipmentProcessor.class,
                IntercityRoutePlanner.class,
                IntercityTrackingService.class,
                IntercityDeliveryCreator.class,
                "INTERCITY-");
    }

    @Test
    void internationalFactoryCreatesInternationalFamily() {
        assertFamily(new InternationalDeliveryFactory(),
                InternationalShipmentProcessor.class,
                InternationalRoutePlanner.class,
                InternationalTrackingService.class,
                InternationalDeliveryCreator.class,
                "INTERNATIONAL-");
    }

    @Test
    void expressFactoryCreatesExpressFamily() {
        assertFamily(new ExpressDeliveryFactory(),
                ExpressShipmentProcessor.class,
                ExpressRoutePlanner.class,
                ExpressTrackingService.class,
                ExpressDeliveryCreator.class,
                "EXPRESS-");
    }

    @Test
    void selectsCityFactory() {
        assertInstanceOf(CityDeliveryFactory.class,
                DeliveryFactorySelector.select("city"));
    }

    @Test
    void selectsIntercityFactory() {
        assertInstanceOf(IntercityDeliveryFactory.class,
                DeliveryFactorySelector.select("intercity"));
    }

    @Test
    void selectsInternationalFactory() {
        assertInstanceOf(InternationalDeliveryFactory.class,
                DeliveryFactorySelector.select("international"));
    }

    @Test
    void selectsExpressFactory() {
        assertInstanceOf(ExpressDeliveryFactory.class,
                DeliveryFactorySelector.select("express"));
    }

    @Test
    void deliversCityParcel() {
        DeliveryService service = new DeliveryService(new CityDeliveryFactory());

        String result = service.deliver(parcel());

        assertTrue(result.contains("CITY-1001"));
        assertTrue(result.contains("Courier assigned"));
    }

    @Test
    void reroutesIntercityParcel() {
        DeliveryService service = new DeliveryService(
                new IntercityDeliveryFactory()
        );
        Parcel updated = new Parcel(
                "1001", "Warehouse A", "New address", 2.5
        );

        String result = service.reroute("INTERCITY-1001", updated);

        assertTrue(result.contains("REROUTED"));
        assertTrue(result.contains("New address"));
    }

    @Test
    void returnsInternationalParcelToSender() {
        DeliveryService service = new DeliveryService(
                new InternationalDeliveryFactory()
        );

        String result = service.returnToSender(parcel());

        assertTrue(result.contains("INTERNATIONAL-1001-RETURN"));
        assertTrue(result.contains("RETURN_REQUESTED"));
        assertTrue(result.contains("Customer B"));
        assertTrue(result.contains("Warehouse A"));
    }

    @Test
    void expressFamilyWorksWithExistingBusinessLogic() {
        DeliveryService service = new DeliveryService(
                new ExpressDeliveryFactory()
        );

        String result = service.deliver(parcel());

        assertTrue(result.contains("EXPRESS-1001"));
        assertTrue(result.contains("Priority courier"));
    }

    @Test
    void rejectsUnknownFamily() {
        assertThrows(IllegalArgumentException.class,
                () -> DeliveryFactorySelector.select("unknown"));
    }

    @Test
    void rejectsParcelWithZeroWeight() {
        Parcel invalid = new Parcel(
                "1001", "Warehouse A", "Customer B", 0
        );
        DeliveryService service = new DeliveryService(new CityDeliveryFactory());

        assertThrows(IllegalArgumentException.class,
                () -> service.deliver(invalid));
    }

    @Test
    void rejectsParcelWithoutOrigin() {
        Parcel invalid = new Parcel(
                "1001", " ", "Customer B", 2.5
        );
        DeliveryService service = new DeliveryService(new CityDeliveryFactory());

        assertThrows(IllegalArgumentException.class,
                () -> service.deliver(invalid));
    }

    @Test
    void rejectsMissingFactory() {
        assertThrows(IllegalArgumentException.class,
                () -> new DeliveryService(null));
    }

    @Test
    void serviceWorksWithAFactoryUnknownToItsSourceCode() {
        DeliveryFactory fakeFactory = new DeliveryFactory() {
            @Override
            public ShipmentProcessor createShipmentProcessor() {
                return p -> "FAKE-" + p.getId();
            }

            @Override
            public RoutePlanner createRoutePlanner() {
                return p -> "fake route";
            }

            @Override
            public TrackingService createTrackingService() {
                return new TrackingService() {
                    @Override
                    public String track(String shipmentId, String route) {
                        return shipmentId + " tracked on " + route;
                    }

                    @Override
                    public String recordEvent(
                            String shipmentId,
                            String route,
                            DeliveryEvent event
                    ) {
                        return event + ": " + shipmentId;
                    }
                };
            }

            @Override
            public DeliveryCreator createDeliveryCreator() {
                return new DeliveryCreator() {
                    @Override
                    protected ShipmentProcessor createProcessor() {
                        return fakeFactoryProcessor();
                    }

                    private ShipmentProcessor fakeFactoryProcessor() {
                        return p -> "FAKE-" + p.getId();
                    }
                };
            }
        };

        DeliveryService service = new DeliveryService(fakeFactory);

        assertEquals(
                "FAKE-1001 tracked on fake route",
                service.deliver(parcel())
        );
    }
}