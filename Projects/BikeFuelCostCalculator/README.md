# Bike Fuel Cost Calculator V2

A simple Java console program that calculates the fuel required and total petrol cost for a round-trip bike journey, then checks the cost against a fuel budget.

## Formulas

- Total Distance = One-Way Distance * 2
- Fuel Required = Total Distance / Mileage
- Total Fuel Cost = Fuel Required * Petrol Price
- Average Distance Per Day = Total Distance / Trip Duration

## Run

```text
javac BikeFuelCostCalculator.java
java BikeFuelCostCalculator
```

The program asks for the one-way distance, bike mileage, petrol price, trip duration, and fuel budget. It displays a complete trip summary and reports whether the calculated fuel cost is within the budget.

Version 1 calculated basic fuel and cost. Version 2 adds round-trip planning and budget analysis.