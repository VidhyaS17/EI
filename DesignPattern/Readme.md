# DesignPatternsDemo - Java Project

## Overview
This Java project demonstrates **six common software design patterns** across three categories:  
- **Behavioral Patterns**: Observer, Strategy  
- **Creational Patterns**: Singleton, Factory  
- **Structural Patterns**: Adapter, Decorator  

The focus of this repository is to provide **console-based examples** showing how design patterns work in real Java applications.  
All classes are modular, follow OOP principles, and can be run individually or through the `MainApp.java` class.

---

## Project Structure

DesignPatternsDemo/
│── src/
│ ├── MainApp.java # Main class to run all demos
│ ├── behavioral/
│ │ ├── ObserverPatternDemo.java
│ │ └── StrategyPatternDemo.java
│ ├── creational/
│ │ ├── SingletonPatternDemo.java
│ │ └── FactoryPatternDemo.java
│ ├── structural/
│ │ ├── AdapterPatternDemo.java
│ │ └── DecoratorPatternDemo.java

markdown
Copy code

---

## Decorator Pattern Demo

### Description
The **Decorator Pattern** allows you to **add new functionality to an existing object dynamically** without altering its structure.  
This project demonstrates decorating a simple coffee with milk dynamically.

### Classes in DecoratorPatternDemo
- **Coffee (Interface)**: Base component with `getDescription()` and `cost()` methods.
- **SimpleCoffee (Concrete Component)**: Implements Coffee; provides base description and cost.
- **CoffeeDecorator (Abstract Decorator)**: Holds a reference to Coffee object and extends its behavior.
- **MilkDecorator (Concrete Decorator)**: Extends CoffeeDecorator; adds milk to description and cost.

### Sample Output
Simple Coffee:
Description: Simple Coffee
Cost: 5.0

Coffee with Milk:
Description: Simple Coffee, Milk
Cost: 7.0

yaml
Copy code

---

## How to Run

1. Clone the repository:
bash
git clone https://github.com/VidhyaS17/DesignPatternsDemo.git
Navigate to the src folder and compile:

bash
Copy code
cd DesignPatternsDemo/src
javac MainApp.java
Run the project:

bash
Copy code
java MainApp
