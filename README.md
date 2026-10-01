# Delivery System

A Java application demonstrating Factory Method and Abstract Factory through city, intercity, international, and express parcel delivery.

## How to run

Run `DeliveryApplication` with one program argument: `city`, `intercity`, `international`, or `express`. If no argument is supplied, the application uses `city`.

Each run demonstrates three operations: dispatching a parcel, changing its route, and returning it to the sender.

## Design before factories

The initial implementation created concrete products directly in `DeliveryApplication`. This caused three problems:

1. The client depended on concrete delivery classes.
2. The same creation and processing sequence was repeated for every family.
3. Adding another family required changing the client's creation logic.

The initial version is preserved in Git history.

## Factory Method

`DeliveryCreator.register()` validates a parcel, creates a shipment processor, and produces a registration receipt. Its subclasses override `createProcessor()` to choose the processor for their delivery family.

## Abstract Factory and compatibility

`DeliveryFactory` defines methods for creating a shipment processor, route planner, tracking service, and delivery creator. Each concrete factory supplies products from one delivery family.

`DeliveryService` receives one `DeliveryFactory` and obtains the components for its operations from that factory. Its normal workflow therefore uses a consistent family.

## Adding the express family

The express family was added after the first three families. The following files were added:

- `ExpressShipmentProcessor.java`
- `ExpressRoutePlanner.java`
- `ExpressTrackingService.java`
- `ExpressDeliveryCreator.java`
- `ExpressDeliveryFactory.java`

The following files were changed:

- `DeliveryFactorySelector.java` — added selection of the express factory.
- `DeliveryApplication.java` — updated the list of valid arguments.

`DeliveryService.java` did not need to change. Its existing business operations work with the new family.

## Tests and UML

`DeliverySystemTest.java` contains 17 JUnit tests covering product families, concrete product creation, factory selection, business operations, invalid input, the express extension, and use of abstractions.

The class diagram is in `delivery-system.puml`; its exported image is `delivery-system.png`.