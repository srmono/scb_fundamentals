* **Association** is the broad concept of relationships between objects.
* **Aggregation** and **Composition** are special types of Association.

---

## **1. Association Example**

**File:** `AssociationExample.java`

```java
// Association: Two separate classes with a relationship
class Driver {
    String name;

    Driver(String name) {
        this.name = name;
    }
}

class Car {
    String model;

    Car(String model) {
        this.model = model;
    }
}

public class AssociationExample {
    public static void main(String[] args) {
        Driver driver = new Driver("John");
        Car car = new Car("Toyota");

        // Association: Driver drives a Car
        System.out.println(driver.name + " drives a " + car.model);
    }
}
```

**Run:**

```bash
javac AssociationExample.java
java AssociationExample
```

**Output:**

```
John drives a Toyota
```

Here, `Driver` and `Car` are **independent** objects but have a relationship.

---

## **2. Aggregation Example**

**File:** `AggregationExample.java`

```java
// Aggregation: Has-A relationship but independent lifecycle
class Engine {
    String type;

    Engine(String type) {
        this.type = type;
    }
}

class Bus {
    String model;
    Engine engine; // Aggregation

    Bus(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    void displayInfo() {
        System.out.println(model + " bus has a " + engine.type + " engine.");
    }
}

public class AggregationExample {
    public static void main(String[] args) {
        Engine engine = new Engine("Diesel");
        Bus bus = new Bus("Volvo", engine);

        bus.displayInfo();
    }
}
```

**Run:**

```bash
javac AggregationExample.java
java AggregationExample
```

**Output:**

```
Volvo bus has a Diesel engine.
```

Here, `Bus` has an `Engine`, but the engine can exist separately.

---

## **3. Composition Example**

**File:** `CompositionExample.java`

```java
// Composition: Strong Has-A relationship, dependent lifecycle
class Heart {
    void pump() {
        System.out.println("Heart is pumping blood.");
    }
}

class Human {
    private Heart heart; // Composition

    Human() {
        this.heart = new Heart(); // created inside
    }

    void live() {
        heart.pump();
        System.out.println("Human is alive.");
    }
}

public class CompositionExample {
    public static void main(String[] args) {
        Human human = new Human();
        human.live();
    }
}
```

**Run:**

```bash
javac CompositionExample.java
java CompositionExample
```

**Output:**

```
Heart is pumping blood.
Human is alive.
```

Here, `Human` **cannot exist without** `Heart` — if the human is destroyed, the heart is gone too.

---

## **Key Differences Table**

| Concept     | Relationship Type          | Object Lifecycles Linked? | Example in Real Life    |
| ----------- | -------------------------- | ------------------------- | ----------------------- |
| Association | General relationship       | ❌                         | Teacher teaches Student |
| Aggregation | Has-A, weak relationship   | ❌                         | Bus has Engine          |
| Composition | Has-A, strong relationship | ✅                         | Human has Heart         |

