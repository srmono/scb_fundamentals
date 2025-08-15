## **1. Abstract Class in Java**

### **Meaning**

* A class that **cannot be instantiated** (you cannot create objects from it directly).
* Can have **abstract methods** (no body) and **concrete methods** (with body).
* Acts as a **blueprint** for other classes.

### **Layman’s Analogy**

Think of an **Employee ID card design template**:

* The template itself is not usable for work.
* It only defines what *must* be on the card (name, photo, ID number).
* Actual departments (subclasses) fill in the details.

---

### **Example: Abstract Class**

```java
// Abstract Class
abstract class Vehicle {
    abstract void start(); // abstract method (no body)

    public void fuel() { // concrete method
        System.out.println("Vehicle is refueling...");
    }
}

// Concrete subclass
class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Car starts with a key.");
    }
}

class Bike extends Vehicle {
    @Override
    void start() {
        System.out.println("Bike starts with a kick.");
    }
}

public class AbstractDemo {
    public static void main(String[] args) {
        Vehicle v1 = new Car();
        v1.start(); // Car's start method
        v1.fuel();  // from abstract class

        Vehicle v2 = new Bike();
        v2.start();
        v2.fuel();
    }
}
```

**Output:**

```
Car starts with a key.
Vehicle is refueling...
Bike starts with a kick.
Vehicle is refueling...
```

---

## **2. Interface in Java**

### **Meaning**

* A completely abstract contract that defines **what a class must do**, but not **how**.
* All methods are **public and abstract** by default (Java 8+ allows default and static methods).
* Supports **multiple inheritance** (a class can implement multiple interfaces).

### **Layman’s Analogy**

Think of an **Electrical Plug interface**:

* It defines the *shape* of the pins and voltage — any appliance can use it if it follows this design.
* The actual appliance (TV, fridge, phone charger) decides *how* to work internally.

---

### **Example: Interface**

```java
// Interface
interface Payment {
    void pay(double amount);
}

interface Refund {
    void refund(double amount);
}

// Implementing multiple interfaces
class CreditCardPayment implements Payment, Refund {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded $" + amount + " to Credit Card.");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        CreditCardPayment payment = new CreditCardPayment();
        payment.pay(250.0);
        payment.refund(100.0);
    }
}
```

**Output:**

```
Paid $250.0 using Credit Card.
Refunded $100.0 to Credit Card.
```

---

## **3. Abstract Class vs Interface — Quick Table**

| Feature         | Abstract Class                       | Interface                         |
| --------------- | ------------------------------------ | --------------------------------- |
| Object Creation | ❌ Cannot create                      | ❌ Cannot create                   |
| Method Types    | Abstract + Concrete                  | Abstract (default/static allowed) |
| Variables       | Any type                             | `public static final` only        |
| Inheritance     | Single                               | Multiple                          |
| Use Case        | "is-a" relationship with shared code | Contract/Capabilities             |

---

## **4. Real-Time Scenario**

Imagine building an **online payment system**:

* **Abstract Class (`PaymentProcessor`)** → Common code like transaction logging.
* **Interfaces (`Payment`, `Refund`)** → Ensure all payment types follow same rules for `pay()` and `refund()`.

