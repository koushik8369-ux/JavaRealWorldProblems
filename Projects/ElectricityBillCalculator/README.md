# Electricity Bill Calculator

A Java console-based application that calculates electricity bills using slab-based pricing.

## Features

- Customer name input
- Electricity units input
- Slab-based energy charge calculation
- Fixed charge
- High-usage surcharge
- Input validation
- Object-Oriented Programming
- Formatted electricity bill

## Electricity Rate Slabs

| Units | Rate |
|---|---:|
| 0–100 | ₹2/unit |
| 101–200 | ₹3/unit |
| 201–500 | ₹5/unit |
| Above 500 | ₹7/unit |

## Additional Charges

- Fixed charge: ₹100
- If the energy charge exceeds ₹2000, a 5% surcharge is applied.

## Java Concepts Used

- Classes and Objects
- Encapsulation
- Private fields
- Constructor
- Methods
- `this` keyword
- `static final` constants
- Conditional statements
- Arithmetic operators
- `Scanner`
- Formatted output
- Basic validation

## Version History

### Version 1 — Basic Calculator

- Customer input
- Unit input
- Slab-based calculation
- Fixed charge
- Total bill

### Version 2 — Improved Calculator

- Object-Oriented structure
- `ElectricityBill` class
- Constructor
- Calculation methods
- Input validation
- 5% high-usage surcharge
- Improved formatted bill
- README documentation

## How to Run

Compile:

```bash
javac ElectricityBillCalculator.java

run:
java ElectricityBillCalculator