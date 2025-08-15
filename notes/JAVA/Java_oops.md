## **Java OOP Concepts — Beginner to Advanced with Real Examples**

---

### **1. Class & Object**

**Definition:**

* A **class** is a blueprint for creating objects.
* An **object** is an instance of a class, containing data (**fields**) and behavior (**methods**).

**Real-World Example:**
A `Car` blueprint defines brand, model, and actions like `start()` or `stop()`. An actual Toyota Camry is an **object**.

**Code:**

```java
class Car {
    String brand;
    String model;
    
    Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    
    void start() {
        System.out.println(brand + " " + model + " is starting...");
    }
}

public class ClassObjectDemo {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camry");
        car1.start();
    }
}
```

---

### **2. Encapsulation**

**Definition:**

* Wrapping data and methods together in a class.
* Protecting data using `private` fields and `public` getters/setters.

**Real-World Example:**
An ATM machine — you can deposit/withdraw money but cannot directly access the internal balance variable.

**Code:**

```java
class BankAccount {
    private double balance;
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount");
        }
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        acc.deposit(1000);
        acc.withdraw(500);
        System.out.println("Balance: " + acc.getBalance());
    }
}
```

---

### **3. Inheritance**

(We already covered **Single, Multilevel, Hierarchical, Multiple via Interfaces, Hybrid**) — full examples above.
These will be kept in the document.

---

### **4. Polymorphism**

#### **Compile-Time (Method Overloading)**

Same method name but different parameter lists.

**Real-World Example:**
A printer can print different formats — text, photo, PDF — but the action is still “print”.

**Code:**

```java
class Printer {
    void print(String text) {
        System.out.println("Printing text: " + text);
    }
    
    void print(int number) {
        System.out.println("Printing number: " + number);
    }
}

public class OverloadingDemo {
    public static void main(String[] args) {
        Printer p = new Printer();
        p.print("Hello");
        p.print(123);
    }
}
```

#### **Run-Time (Method Overriding)**

Child class provides its own implementation.

**Real-World Example:**
All animals make sounds, but a dog barks and a cat meows.

**Code:**

```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class OverridingDemo {
    public static void main(String[] args) {
        Animal a = new Dog(); // Upcasting
        a.sound();
    }
}
```

---

### **5. Abstraction**

#### **Abstract Class**

**Real-World Example:**
A `Payment` system — method `processPayment()` is defined but implemented differently by `CreditCardPayment` or `UPIPayment`.

**Code:**

```java
abstract class Payment {
    abstract void processPayment(double amount);
}

class CreditCardPayment extends Payment {
    void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

public class AbstractClassDemo {
    public static void main(String[] args) {
        Payment p = new CreditCardPayment();
        p.processPayment(250.75);
    }
}
```

#### **Interface**

**Real-World Example:**
A `Flyable` contract — any class that implements it must define `fly()`.

**Code:**

```java
interface Flyable {
    void fly();
}

class Bird implements Flyable {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        Flyable f = new Bird();
        f.fly();
    }
}
```

---

### **6. `this` Keyword**

Refers to current object instance.

**Real-World Example:**
When introducing yourself, you refer to yourself as “I”.

**Code:**

```java
class Student {
    String name;
    
    Student(String name) {
        this.name = name; // differentiating field from parameter
    }
    
    void introduce() {
        System.out.println("Hi, I am " + this.name);
    }
}

public class ThisKeywordDemo {
    public static void main(String[] args) {
        Student s = new Student("Alice");
        s.introduce();
    }
}
```

---

### **7. `super` Keyword**

Refers to the parent class.

**Code:**

```java
class Parent {
    Parent() {
        System.out.println("Parent constructor");
    }
}

class Child extends Parent {
    Child() {
        super(); // calling parent constructor
        System.out.println("Child constructor");
    }
}

public class SuperKeywordDemo {
    public static void main(String[] args) {
        Child c = new Child();
    }
}
```

---

### **8. Constructor Overloading**

Multiple constructors for flexibility.

**Code:**

```java
class Book {
    String title;
    String author;
    
    Book() {
        title = "Unknown";
        author = "Unknown";
    }
    
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    void display() {
        System.out.println(title + " by " + author);
    }
}

public class ConstructorOverloadingDemo {
    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("1984", "George Orwell");
        b1.display();
        b2.display();
    }
}
```

---

### **9. Static Keyword**

**Code:**

```java
class Counter {
    static int count = 0;
    
    Counter() {
        count++;
    }
    
    static void displayCount() {
        System.out.println("Objects created: " + count);
    }
}

public class StaticDemo {
    public static void main(String[] args) {
        new Counter();
        new Counter();
        Counter.displayCount();
    }
}
```

---

### **10. Final Keyword**

* Final variable → constant
* Final method → cannot override
* Final class → cannot extend

---

### **11. Inner Classes**

**Code:**

```java
class Outer {
    int outerValue = 10;
    
    class Inner {
        void show() {
            System.out.println("Outer value: " + outerValue);
        }
    }
}

public class InnerClassDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.show();
    }
}
```

---


---

## **Inheritance in Java — All Types with Examples**

Java supports the following **types of inheritance**:

1. **Single Inheritance**
2. **Multilevel Inheritance**
3. **Hierarchical Inheritance**
4. **Multiple Inheritance (via interfaces)**
5. **Hybrid Inheritance (combination — only possible with interfaces)**

Java **does not** support **multiple inheritance with classes** directly, to avoid the *Diamond Problem*.

---

### **1. Single Inheritance**

**Definition:** One child class inherits from one parent class.
**Example:** A `Car` inherits from `Vehicle`.

```java
class Vehicle {
    String brand;
    
    Vehicle(String brand) {
        this.brand = brand;
    }
    
    void start() {
        System.out.println(brand + " is starting...");
    }
}

class Car extends Vehicle {
    int doors;
    
    Car(String brand, int doors) {
        super(brand);
        this.doors = doors;
    }
    
    void displayInfo() {
        System.out.println("Brand: " + brand + ", Doors: " + doors);
    }
}

public class SingleInheritanceDemo {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", 4);
        myCar.displayInfo();
        myCar.start(); // inherited method
    }
}
```

---

### **2. Multilevel Inheritance**

**Definition:** A class inherits from another class, which itself inherits from another class.
**Example:** `ElectricCar` → `Car` → `Vehicle`.

```java
class Vehicle {
    String brand;
    
    Vehicle(String brand) {
        this.brand = brand;
    }
    
    void start() {
        System.out.println(brand + " is starting...");
    }
}

class Car extends Vehicle {
    int doors;
    
    Car(String brand, int doors) {
        super(brand);
        this.doors = doors;
    }
    
    void honk() {
        System.out.println(brand + " is honking!");
    }
}

class ElectricCar extends Car {
    int batteryCapacity;
    
    ElectricCar(String brand, int doors, int batteryCapacity) {
        super(brand, doors);
        this.batteryCapacity = batteryCapacity;
    }
    
    void charge() {
        System.out.println(brand + " is charging with " + batteryCapacity + " kWh battery.");
    }
}

public class MultilevelInheritanceDemo {
    public static void main(String[] args) {
        ElectricCar tesla = new ElectricCar("Tesla", 4, 75);
        tesla.start();  // From Vehicle
        tesla.honk();   // From Car
        tesla.charge(); // From ElectricCar
    }
}
```

---

### **3. Hierarchical Inheritance**

**Definition:** Multiple child classes inherit from the same parent class.
**Example:** `Car` and `Bike` both inherit from `Vehicle`.

```java
class Vehicle {
    String brand;
    
    Vehicle(String brand) {
        this.brand = brand;
    }
    
    void start() {
        System.out.println(brand + " is starting...");
    }
}

class Car extends Vehicle {
    Car(String brand) {
        super(brand);
    }
    
    void honk() {
        System.out.println(brand + " car horn!");
    }
}

class Bike extends Vehicle {
    Bike(String brand) {
        super(brand);
    }
    
    void kickStart() {
        System.out.println(brand + " bike is kick-started.");
    }
}

public class HierarchicalInheritanceDemo {
    public static void main(String[] args) {
        Car car = new Car("Toyota");
        car.start();
        car.honk();
        
        Bike bike = new Bike("Yamaha");
        bike.start();
        bike.kickStart();
    }
}
```

---

### **4. Multiple Inheritance (via Interfaces)**

Java doesn’t allow a class to inherit from multiple classes, but it **can implement multiple interfaces**.
**Example:** A `FlyingCar` implements both `Drivable` and `Flyable`.

```java
interface Drivable {
    void drive();
}

interface Flyable {
    void fly();
}

class FlyingCar implements Drivable, Flyable {
    public void drive() {
        System.out.println("Flying car is driving on the road.");
    }
    
    public void fly() {
        System.out.println("Flying car is soaring in the sky!");
    }
}

public class MultipleInheritanceDemo {
    public static void main(String[] args) {
        FlyingCar fc = new FlyingCar();
        fc.drive();
        fc.fly();
    }
}
```

---

### **5. Hybrid Inheritance (Combination)**

Combination of **two or more types of inheritance**. Possible only with **interfaces**.
**Example:** `ElectricFlyingCar` inherits behavior from `ElectricVehicle` and `Flyable`.

```java
interface ElectricVehicle {
    void charge();
}

interface Flyable {
    void fly();
}

class ElectricCar implements ElectricVehicle {
    public void charge() {
        System.out.println("Electric car is charging...");
    }
}

class ElectricFlyingCar extends ElectricCar implements Flyable {
    public void fly() {
        System.out.println("Electric flying car is in the air!");
    }
}

public class HybridInheritanceDemo {
    public static void main(String[] args) {
        ElectricFlyingCar efc = new ElectricFlyingCar();
        efc.charge(); // From ElectricVehicle
        efc.fly();    // From Flyable
    }
}
```

---

✅ **Summary Table of Java Inheritance Types**

| Type                      | Supported in Java? | Example Above |
| ------------------------- | ------------------ | ------------- |
| Single                    | ✅ Yes              | 1             |
| Multilevel                | ✅ Yes              | 2             |
| Hierarchical              | ✅ Yes              | 3             |
| Multiple (via classes)    | ❌ No               | —             |
| Multiple (via interfaces) | ✅ Yes              | 4             |
| Hybrid (via interfaces)   | ✅ Yes              | 5             |


---

# Method Overloading (compile-time polymorphism)

**Definition:** Same method name, different parameter lists (type/count/sequence) in the *same* class.
**Analogy:** A phone has one `call(...)` action but you can call by phone number, by contact name, or by voice command — same action, different inputs.

```java
// File: MethodOverloadingDemo.java
class Calculator {
    // add two ints
    int add(int a, int b) {
        return a + b;
    }

    // add three ints
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // add two doubles
    double add(double a, double b) {
        return a + b;
    }
}

public class MethodOverloadingDemo {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(2, 3));          // 5
        System.out.println(calc.add(2, 3, 4));       // 9
        System.out.println(calc.add(2.5, 3.1));      // 5.6
    }
}
```

---

# Method Overriding (runtime polymorphism)

**Definition:** Subclass provides its own implementation for a method defined in a superclass. Used with inheritance.
**Analogy:** `Employee.makeReport()` default method vs `Manager.makeReport()` where manager writes a managerial report.

```java
// File: MethodOverridingDemo.java
class Animal {
    void sound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks: Woof!");
    }
}

public class MethodOverridingDemo {
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal d = new Dog(); // polymorphic reference
        a.sound(); // generic
        d.sound(); // Dog's override (runtime binding)
    }
}
```

---

# Constructor Overloading (not overriding)

**Definition:** Multiple constructors in the same class with different parameter lists. Constructors cannot be overridden because they're not inherited.
**Analogy:** When you buy a phone, you can get it unboxed (no accessories), with basic accessories, or with a premium bundle — same product (class) but different ways to create it (constructors).

```java
// File: ConstructorOverloadingDemo.java
class Book {
    String title;
    String author;
    double price;

    // no-arg constructor
    Book() {
        this("Unknown", "Unknown", 0.0);
    }

    // two-arg constructor
    Book(String title, String author) {
        this(title, author, 0.0);
    }

    // full constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display() {
        System.out.println(title + " by " + author + " ($" + price + ")");
    }
}

public class ConstructorOverloadingDemo {
    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("1984", "George Orwell");
        Book b3 = new Book("Clean Code", "Robert C. Martin", 42.50);
        b1.display();
        b2.display();
        b3.display();
    }
}
```

**Note:** *Constructor overriding* is not possible — constructors are not inherited so you can’t “override” them.

---

# `Object` class methods (`toString()`, `equals()`, `hashCode()`, `clone()`)

**Definition / Analogy:** `Object` is the root class. Important methods are used widely:

* `toString()` — readable representation (like name tag)
* `equals()` — logical equality (do they mean the same?)
* `hashCode()` — bucket id for hash collections (must align with `equals`)
* `clone()` — make a copy (shallow by default; requires `Cloneable`)

**Example:** Person with overridden `toString`, `equals`, `hashCode`, and `clone`.

```java
// File: ObjectMethodsDemo.java
class Person implements Cloneable {
    private String name;
    private int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // human-readable
    @Override
    public String toString() {
        return "Person{name='" + name + "', id=" + id + "}";
    }

    // logical equality (based on id)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person other = (Person) o;
        return this.id == other.id;
    }

    // hashCode consistent with equals
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    // shallow clone
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class ObjectMethodsDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person("Alice", 101);
        Person p2 = new Person("Bob", 101); // same id => logically equal

        System.out.println(p1); // calls toString
        System.out.println("p1.equals(p2): " + p1.equals(p2));
        System.out.println("p1.hashCode() == p2.hashCode(): " + (p1.hashCode() == p2.hashCode()));

        Person p3 = (Person) p1.clone();
        System.out.println("Cloned p3: " + p3);
    }
}
```

> Tip: `clone()` has pitfalls (shallow vs deep). Many prefer copy constructors or factory methods.

---

# Aggregation vs Composition

**Definition & Analogy:** Both are *has-a* relationships.

* **Aggregation (weak)**: The part can exist independently of the whole — e.g., `Team` and `Player` (a player exists without a team).
* **Composition (strong)**: The part’s lifecycle is tied to the whole — e.g., `Car` and `Engine` created with the car; if car is destroyed, engine is too.

```java
// File: AggregationCompositionDemo.java

// Aggregation example: Team has Players (players can exist without team)
class Player {
    String name;
    Player(String name) { this.name = name; }
}

class Team { // aggregation (Team references externally created Player objects)
    String name;
    java.util.List<Player> roster;
    Team(String name, java.util.List<Player> roster) {
        this.name = name;
        this.roster = roster; // does not create players
    }
}

// Composition example: House -> Room (House creates Rooms; rooms don't make sense alone)
class Room {
    String type;
    Room(String type) { this.type = type; }
}

class House {
    String address;
    Room[] rooms; // composition: created inside House
    House(String address) {
        this.address = address;
        this.rooms = new Room[] { new Room("Bedroom"), new Room("Kitchen") };
    }
}

public class AggregationCompositionDemo {
    public static void main(String[] args) {
        // Aggregation usage
        Player p1 = new Player("Alice");
        Player p2 = new Player("Bob");
        java.util.List<Player> roster = new java.util.ArrayList<>();
        roster.add(p1); roster.add(p2);
        Team team = new Team("Warriors", roster);
        System.out.println("Team " + team.name + " has players: " + team.roster.size());

        // Composition usage
        House house = new House("221B Baker Street");
        System.out.println("House at " + house.address + " has " + house.rooms.length + " rooms.");
    }
}
```

---

# `instanceof` Operator

**Definition:** Checks whether an object is an instance of a class/interface (safe runtime type check).
**Analogy:** You ask “Is this person a driver?” before calling driver-specific methods.

```java
// File: InstanceofDemo.java
class Shape { }
class Circle extends Shape {
    void draw() { System.out.println("Drawing Circle"); }
}
class Rectangle extends Shape {
    void draw() { System.out.println("Drawing Rectangle"); }
}

public class InstanceofDemo {
    static void tryDraw(Shape s) {
        if (s instanceof Circle) {
            Circle c = (Circle) s;
            c.draw();
        } else if (s instanceof Rectangle) {
            ((Rectangle) s).draw();
        } else {
            System.out.println("Unknown shape");
        }
    }

    public static void main(String[] args) {
        Shape s1 = new Circle();
        Shape s2 = new Rectangle();
        tryDraw(s1);
        tryDraw(s2);
    }
}
```

> Note: Newer Java versions support *pattern matching for instanceof* to declare the cast variable inline (shorter syntax).

---

# Covariant Return Types

**Definition:** Overridden methods may return a subtype (more specific type) of the original method’s return type.
**Analogy:** A factory method `Animal create()` in base class can be overridden by `Dog create()` in subclass factory.

```java
// File: CovariantReturnDemo.java
class Animal {
    Animal reproduce() {
        System.out.println("Animal reproduces generic offspring");
        return new Animal();
    }
}

class Dog extends Animal {
    @Override
    Dog reproduce() { // covariant return: Dog is a subtype of Animal
        System.out.println("Dog reproduces a puppy");
        return new Dog();
    }
}

public class CovariantReturnDemo {
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal baby1 = a.reproduce();

        Animal d = new Dog();
        Animal baby2 = d.reproduce(); // actually returns Dog, but reference type is Animal
        System.out.println("baby2 is instance of Dog? " + (baby2 instanceof Dog));
    }
}
```

---

# Enums

**Definition:** Special class to represent fixed sets of constants, can have fields, methods, and constructors.
**Analogy:** Days of week, months, traffic light colors.

```java
// File: EnumDemo.java
enum Day {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4),
    FRIDAY(5), SATURDAY(6), SUNDAY(7);

    private final int order;
    Day(int order) { this.order = order; }
    public int order() { return order; }
}

public class EnumDemo {
    public static void main(String[] args) {
        Day today = Day.WEDNESDAY;
        System.out.println("Today: " + today + " order: " + today.order());

        for (Day d : Day.values()) {
            System.out.println(d + " -> " + d.order());
        }
    }
}
```

---

# Records (Java 16+)

**Definition:** Compact syntax for immutable data carriers (final fields, auto-generated equals/hashCode/toString/accessors).
**Analogy:** A coordinate pair (x,y) or a simple DTO/struct.

```java
// File: RecordDemo.java
record Point(int x, int y) { }

public class RecordDemo {
    public static void main(String[] args) {
        Point p = new Point(3, 7);
        System.out.println("Point: " + p);         // auto toString
        System.out.println("x: " + p.x() + ", y: " + p.y());
    }
}
```

> Records are immutable and ideal for value objects.

---

# Sealed Classes (Java 17+)

**Definition:** Restrict which other classes can extend a class (or implement an interface). Useful for exhaustive switch and controlled hierarchies.
**Analogy:** A company allows only a fixed list of partner firms to implement a specific contract.

```java
// File: SealedDemo.java
// Requires Java 17+ to compile and run
sealed abstract class Shape permits Circle, Square {
    abstract double area();
}

final class Circle extends Shape {
    private final double r;
    Circle(double r) { this.r = r; }
    @Override double area() { return Math.PI * r * r; }
}

final class Square extends Shape {
    private final double side;
    Square(double side) { this.side = side; }
    @Override double area() { return side * side; }
}

public class SealedDemo {
    public static void main(String[] args) {
        Shape s1 = new Circle(2.0);
        Shape s2 = new Square(3.0);
        System.out.println("Circle area: " + s1.area());
        System.out.println("Square area: " + s2.area());
    }
}
```

---

# Anonymous Classes

**Definition:** Create one-off subclasses or implementations without naming the class. Useful for quick behavior overrides.
**Analogy:** You hire a temporary helper with one job — you don’t name them, you just give them a task.

```java
// File: AnonymousClassDemo.java
public class AnonymousClassDemo {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running in anonymous class");
            }
        };
        r.run();
    }
}
```

---

# Lambdas (Java 8+)

**Definition:** Concise way to implement functional interfaces (single abstract method). Lambdas are often used with collections, threads, and functional APIs.
**Analogy:** Instead of writing a full class for a single short task, you write the action inline — like handing a sticky note with instructions.

```java
// File: LambdaDemo.java
import java.util.*;
import java.util.function.*;

public class LambdaDemo {
    public static void main(String[] args) {
        // Runnable lambda
        Runnable r = () -> System.out.println("Running via lambda");
        r.run();

        // Comparator using lambda
        List<String> names = Arrays.asList("Bob", "Alice", "Charlie");
        names.sort((a, b) -> a.compareTo(b));
        System.out.println(names);

        // Custom functional interface
        Function<Integer, Integer> square = x -> x * x;
        System.out.println("Square of 5: " + square.apply(5));
    }
}
```

---

# Bonus: Anonymous class vs Lambda — quick note

* **Anonymous class:** creates a new class at runtime; can access `this` differently; can have multiple methods (not limited to SAM).
* **Lambda:** cleaner syntax for functional interfaces; `this` refers to enclosing class, not the lambda object.

---
