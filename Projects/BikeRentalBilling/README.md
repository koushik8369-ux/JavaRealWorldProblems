# Bike Rental Billing System

A Java console-based application that calculates bike rental charges and generates a detailed rental bill.

## Features

- Customer and bike details
- Bike category selection
- Rental duration calculation
- Helmet rental charges
- Extra helmet charges
- Late return charges
- Long-rental discount
- Membership discount
- Promo code discount
- Refundable security deposit
- Input validation
- Detailed formatted bill

## Discount Rules

### Long Rental Discount

- 1–2 days → No discount
- 3–5 days → 10% discount
- More than 5 days → 15% discount

### Membership Discount

Members receive an additional 5% discount.

### Promo Code

`SAVE100` gives a maximum discount of ₹100.

## Charges

- Helmet: ₹50 per helmet per day
- Late return: ₹100 per hour
- Security deposit: ₹2000

The security deposit is refundable and is shown separately from the rental amount.

## Java Concepts Used

- Classes and Objects
- Encapsulation
- Private Data Members
- Constructor
- `this` Keyword
- Methods
- Conditional Statements
- `switch`
- Boolean Variables
- Arithmetic Operators
- User Input using `Scanner`
- Formatted Output
- Basic Input Validation

## Project Structure

```text
BikeRentalBilling/
├── BikeRentalBilling.java
└── README.md