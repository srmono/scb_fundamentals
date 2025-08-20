# Spring Framework Runtime — Concepts + Examples + Use Cases

---

## 1. **Core Container**

### 🔹 Beans

* **What:** Provides the `BeanFactory` for managing beans (objects) and their lifecycle.
* **Example:**

  ```java
  @Component
  class Engine {}
  ```
* **Use Case (1-liner):** Manage application objects like `Car` and `Engine` without `new`.

---

### 🔹 Core

* **What:** Provides core IoC (Inversion of Control) and Dependency Injection.
* **Example:**

  ```java
  class Car {
      private Engine engine;
      @Autowired
      Car(Engine engine) { this.engine = engine; }
  }
  ```
* **Use Case:** Decouple business classes by injecting dependencies automatically.

---

### 🔹 Context

* **What:** Extends Core/Beans, provides `ApplicationContext` for enterprise features (i18n, events).
* **Example:**

  ```java
  ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
  Car car = ctx.getBean(Car.class);
  ```
* **Use Case:** Central hub to load and manage beans with enterprise support.

---

### 🔹 SpEL (Spring Expression Language)

* **What:** Expression language to inject values dynamically.
* **Example:**

  ```java
  @Value("#{2+3}") 
  private int speed;
  ```
* **Use Case:** Configure bean values dynamically (like formulas, property values).

---

## 2. **Data Access / Integration**

### 🔹 JDBC

* **What:** Simplifies JDBC boilerplate code (connections, statements, exceptions).
* **Example:**

  ```java
  jdbcTemplate.query("SELECT * FROM users", new UserRowMapper());
  ```
* **Use Case:** Fetch or update DB records without writing repetitive JDBC code.

---

### 🔹 ORM

* **What:** Integrates with ORM tools (Hibernate, JPA).
* **Example:**

  ```java
  @Entity
  class Customer { @Id int id; String name; }
  ```
* **Use Case:** Save/retrieve Java objects directly into DB tables.

---

### 🔹 OXM

* **What:** Object-XML Mapping (like JAXB).
* **Example:**
  Convert Java object → XML:

  ```java
  marshaller.marshal(customer, new StreamResult(System.out));
  ```
* **Use Case:** Easily convert between Java objects and XML.

---

### 🔹 JMS

* **What:** Java Messaging Service integration.
* **Example:**

  ```java
  jmsTemplate.convertAndSend("orderQueue", new Order(123));
  ```
* **Use Case:** Send/receive messages asynchronously (e.g., order processing).

---

### 🔹 Transactions

* **What:** Unified transaction management.
* **Example:**

  ```java
  @Transactional
  public void transferMoney(Account a, Account b, int amt) { ... }
  ```
* **Use Case:** Ensure DB operations either **all succeed or all fail** (atomicity).

---

## 3. **Web**

### 🔹 Web

* **What:** Basic web support (file uploads, context integration).
* **Use Case:** Build standard web apps.

---

### 🔹 Servlet (Spring MVC)

* **What:** MVC web framework (`DispatcherServlet`, Controllers, Views).
* **Example:**

  ```java
  @Controller
  class HomeController {
      @GetMapping("/") String home() { return "index"; }
  }
  ```
* **Use Case:** Build structured web apps with MVC pattern.

---

### 🔹 WebSocket

* **What:** Real-time communication support.
* **Example:** Live chat application.
* **Use Case:** Push stock updates or chat messages instantly.

---

### 🔹 Portlet

* **What:** Support for Portlet-based apps (like Liferay portals).
* **Use Case:** Build apps for enterprise portal frameworks.

---

## 4. **AOP (Aspect-Oriented Programming)**

* **What:** Modularizes cross-cutting concerns (logging, transactions, security).
* **Example:**

  ```java
  @Aspect
  class LoggingAspect {
      @Before("execution(* com.app.*.*(..))")
      public void log() { System.out.println("Logging..."); }
  }
  ```
* **Use Case:** Add logging/security without polluting business code.

---

## 5. **Aspects**

* **What:** Implementation support for AOP using AspectJ.
* **Use Case:** Add custom behavior before/after methods (e.g., audit trails).

---

## 6. **Instrumentation**

* **What:** Provides classloader-level instrumentation.
* **Use Case:** Profiling, performance monitoring of classes at runtime.

---

## 7. **Messaging**

* **What:** Messaging abstraction (STOMP, WebSocket, RabbitMQ, Kafka).
* **Example:**

  ```java
  @MessageMapping("/chat")
  @SendTo("/topic/messages")
  public String chat(String msg) { return msg; }
  ```
* **Use Case:** Enable chat, notifications, or event-driven microservices.

---

## 8. **Test**

* **What:** Testing support for Spring apps.
* **Example:**

  ```java
  @SpringBootTest
  class MyTests {
      @Autowired Service service;
      @Test void testService() { assertNotNull(service); }
  }
  ```
* **Use Case:** Write unit & integration tests with Spring context loaded.

---

# ✅ Quick Reference (Use Cases)

* **Beans/Core/Context/SpEL** → Manage and inject application objects.
* **JDBC/ORM/OXM/JMS/Transactions** → Simplify DB and messaging integration.
* **Web/Servlet/WebSocket/Portlet** → Build modern or portal web apps.
* **AOP/Aspects** → Apply cross-cutting concerns (logging, security).
* **Instrumentation** → Runtime monitoring/profiling.
* **Messaging** → Event-driven real-time apps.
* **Test** → Simplified Spring application testing.

