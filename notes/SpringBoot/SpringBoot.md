#  Spring Boot – Core Fundamentals (From Basics to Advanced)

---

## 1. **What is Spring Boot?**

* A framework that simplifies building Java-based enterprise applications.
* Built on top of **Spring Framework**.
* Provides:

  * **Auto-configuration** (no need to define everything manually).
  * **Starter dependencies** (easy dependency management).
  * **Embedded servers** (Tomcat/Jetty/Undertow → no need for external server).
  * **Production-ready features** (health checks, metrics, logging).

👉 Example (Bank App):
Instead of configuring Spring MVC, Hibernate, Jackson separately, you just add **spring-boot-starter-web** and Spring Boot wires it for you.

---

## 2. **Spring Boot Application Structure**

* A Spring Boot app typically has:

  1. `@SpringBootApplication` annotated main class
  2. `application.properties` or `application.yml`
  3. Business logic classes (Services, Repositories, Controllers)
  4. Model/Entity classes (BankAccount, Customer, Transaction)

👉 Minimal Example:

```java
@SpringBootApplication
public class BankApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }
}
```

---

## 3. **Spring Boot Starters**

* Starters are pre-defined dependency sets.
* Examples:

  * `spring-boot-starter-web` → REST + Tomcat + JSON
  * `spring-boot-starter-data-jpa` → Hibernate + JPA
  * `spring-boot-starter-security` → Security
  * `spring-boot-starter-test` → JUnit, Mockito

👉 Example (pom.xml):

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```

---

## 4. **Spring Boot Auto-Configuration**

* Uses `@EnableAutoConfiguration`.
* Reads classpath, beans, and properties → configures beans automatically.
* Example: If H2 DB dependency is present, Spring Boot auto-configures an in-memory DB.

👉 Example:

```java
// If spring-boot-starter-data-jpa is in pom.xml
// and application.properties contains DB configs
// Spring Boot auto-creates EntityManager, DataSource, TransactionManager
```

---

## 5. **Configuration Files**

* Two formats:

  * `application.properties`
  * `application.yml`

👉 Example (Bank DB setup):

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bankdb
spring.datasource.username=root
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=update
```

---

## 6. **Spring Boot Annotations (Core)**

* `@SpringBootApplication` → marks main class.
* `@RestController` → REST APIs.
* `@Service` → business logic.
* `@Repository` → database layer.
* `@Autowired` → inject dependencies.
* `@Value` → read from config file.
* `@Configuration` → define beans manually.
* `@Bean` → create custom bean.

👉 Example (Bank Service):

```java
@Service
public class BankService {
    @Autowired
    private AccountRepository repo;

    public double getBalance(Long accountId) {
        return repo.findById(accountId).get().getBalance();
    }
}
```

---

## 7. **Dependency Injection (DI)**

* Spring Boot uses DI to manage object creation.
* Types:

  * Constructor Injection (preferred)
  * Setter Injection
  * Field Injection

👉 Example:

```java
@Service
public class TransactionService {
    private final AccountRepository accountRepo;

    @Autowired
    public TransactionService(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }
}
```

---

## 8. **Spring Boot Application Lifecycle**

1. Application start → `SpringApplication.run()`
2. Creates ApplicationContext
3. Auto-configuration loads beans
4. Dependency injection occurs
5. Embedded server starts
6. Application ready
7. Shutdown gracefully

👉 Example (Bank):

* Spring Boot loads `BankApplication`
* Auto-configures DataSource (MySQL)
* Creates beans (BankService, AccountRepository)
* Starts Tomcat
* Exposes REST endpoints

---

## 9. **Profiles**

* Used for environment-specific configs.
* Example:

  * `application-dev.properties`
  * `application-prod.properties`

👉 Example:

```properties
# application-dev.properties
spring.datasource.url=jdbc:h2:mem:bankdb

# application-prod.properties
spring.datasource.url=jdbc:mysql://prod-server/bankdb
```

---

## 10. **Spring Boot Actuator**

* Adds monitoring endpoints.
* Examples:

  * `/actuator/health`
  * `/actuator/info`
  * `/actuator/metrics`

👉 Example (Bank Health Check):

```properties
management.endpoints.web.exposure.include=health,info
```

---

## 11. **Exception Handling**

* `@ControllerAdvice` + `@ExceptionHandler`.

👉 Example:

```java
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<String> handleAccountNotFound(AccountNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
```

---

## 12. **Spring Boot Testing**

* `@SpringBootTest` → Integration test.
* `@WebMvcTest` → Controller test.
* `@DataJpaTest` → Repository test.

👉 Example:

```java
@SpringBootTest
class BankServiceTest {
    @Autowired
    private BankService service;

    @Test
    void testBalance() {
        double balance = service.getBalance(1L);
        assertEquals(1000.0, balance);
    }
}
```

---

## 13. **Spring Boot Core Concepts Summary**

* Simplifies Spring setup (Auto-configuration + Starters)
* Embedded servers (no need for WAR deployment)
* Profiles for environment separation
* Dependency injection is core
* Config files centralize settings
* Actuator for monitoring
* Strong testing support

