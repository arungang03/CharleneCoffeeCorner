# CharleneCoffeeCorner
Coffee Shop Receipt Program

Overview:

The Coffee Shop Receipt Program is a Java-based application designed to manage orders, apply discounts, and generate formatted receipts for a fictional coffee shop. The program allows customers to order beverages and snacks, add extras to their items, and apply bonus programs based on specific eligibility criteria.

Features

Order Management: Create and manage orders with multiple items (beverages and snacks).

Extras: Add extras like extra milk or special roast coffee to beverages.

Bonus Programs: Apply discounts based on eligibility (e.g., free beverage after 5th beverage, free snack extra).

Receipt Generation: Generate a well-formatted receipt displaying all items, extras, and the total price.

Technologies Used:

Java SE: Core programming language.

JUnit/TestNG: Testing frameworks used for unit tests.

Maven: Build automation tool.

Getting Started:

Prerequisites

Java Development Kit (JDK) 8 or higher: Ensure that you have Java installed on your system.

Maven: Ensure that Maven is installed to manage dependencies and build the project.

Classes and Methods

Order: Manages the items in the order.

Beverage: Represents a beverage item.

Snack: Represents a snack item.

Extra: Represents an additional option that can be added to a beverage or snack.

BonusProgram: Handles the application of discounts based on eligibility.

ReceiptGenerator: Generates the receipt string.

Installation
Clone the repository:

git clone https://github.com/arungang03/CharleneCoffeeCorner.git
cd coffee-shop-receipt


Build the project using Maven:
mvn clean install
Run the application:
java -jar target/coffee-shop-receipt.jar

Running Tests
Unit tests are written using both JUnit and TestNG. You can run the tests with Maven:

mvn test