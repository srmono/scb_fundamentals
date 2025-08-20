# 📘 Apache Maven – Complete Core Fundamentals

---

## 1. What is Maven?

* **Build Automation + Dependency Management + Project Management Tool.**
* Standardizes project structure across teams.
* Automates compile → test → package → install → deploy.
* Based on **POM (Project Object Model)**.

---

## 2. Maven Installation & Setup

1. Install **Java JDK** (Maven runs on Java).

   ```bash
   java -version
   ```
2. Download Maven: [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)
3. Extract → Add `MAVEN_HOME/bin` to PATH.
4. Verify:

   ```bash
   mvn -version
   ```

---

## 3. Maven Directory Layout (Convention over Configuration)

Standard project layout:

```
project/
 ├─ src/
 │   ├─ main/
 │   │   ├─ java/        → application source
 │   │   ├─ resources/   → config, XML, properties
 │   └─ test/
 │       ├─ java/        → test cases
 │       └─ resources/   → test configs
 ├─ target/              → build output (auto-created)
 └─ pom.xml              → Maven config
```

If you follow this structure, Maven builds automatically without extra config.

---

## 4. Project Object Model (POM)

`pom.xml` is the **heart of Maven**.

### Minimal POM

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.example</groupId>   <!-- Company / org -->
  <artifactId>demo-app</artifactId> <!-- Project name -->
  <version>1.0.0</version>          <!-- Project version -->
  <packaging>jar</packaging>        <!-- jar | war | ear | pom -->
</project>
```

### Key Elements

* **groupId**: Unique org ID (`com.company.project`).
* **artifactId**: The project’s name.
* **version**: Version number (`1.0.0`, `1.0-SNAPSHOT`).
* **packaging**: Type of output (jar/war/ear).

---

## 5. Maven Repositories

Maven stores and fetches dependencies from:

1. **Local repository** → `~/.m2/repository/`
2. **Central repository** → Maven Central (default).
3. **Remote repositories** → e.g., Nexus, Artifactory.

When you add a dependency, Maven:

* Checks **local repo** → if not found
* Downloads from **remote** (Central, Nexus, etc.)
* Caches it in local `~/.m2`

---

## 6. Maven Dependencies

### Example

```xml
<dependencies>
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
  </dependency>
</dependencies>
```

### Dependency Scopes

* **compile** → Default, needed everywhere.
* **provided** → Available at compile time but supplied by runtime (e.g., Servlet API).
* **runtime** → Needed only at runtime (e.g., JDBC drivers).
* **test** → Used only for tests (e.g., JUnit).
* **system** → Explicit local JARs (not recommended).
* **import** → Import dependencies from another POM (for dependency management).

Inspect dependency tree:

```bash
mvn dependency:tree
```

---

## 7. Maven Build Lifecycle

Maven defines **lifecycles**, each with **phases**, each running **goals** (plugins).

### Main Lifecycles

1. **default** → Project build (compile, package, install).
2. **clean** → Cleans `target/`.
3. **site** → Generates project documentation.

---

### The Default Lifecycle Phases

(You usually run a phase → Maven runs all phases before it.)

| Phase            | Description                                    |
| ---------------- | ---------------------------------------------- |
| **validate**     | Check project structure & POM.                 |
| **compile**      | Compile source code (`src/main/java`).         |
| **test-compile** | Compile test code (`src/test/java`).           |
| **test**         | Run unit tests.                                |
| **package**      | Package compiled code (JAR/WAR).               |
| **verify**       | Run additional checks (integration tests, QA). |
| **install**      | Install into local repository (`~/.m2`).       |
| **deploy**       | Deploy to remote repository (shared for team). |

👉 Example:
If you run `mvn package`, Maven executes:

```
validate → compile → test-compile → test → package
```

---

### Clean Lifecycle

* **pre-clean**
* **clean** (delete target/)
* **post-clean**

Run:

```bash
mvn clean
```

---

### Site Lifecycle

* **pre-site**
* **site** (generate docs)
* **post-site**
* **site-deploy**

Run:

```bash
mvn site
```

---

## 8. Maven Plugins

Plugins extend Maven’s capabilities.
Each **phase** executes **plugin goals**.

### Common Plugins

* **Compiler Plugin**

```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-compiler-plugin</artifactId>
  <version>3.11.0</version>
  <configuration>
    <source>17</source>
    <target>17</target>
  </configuration>
</plugin>
```

* **Surefire Plugin** → Runs unit tests.
* **Failsafe Plugin** → Runs integration tests.
* **Shade Plugin** → Builds “fat JAR”.

Run a plugin goal manually:

```bash
mvn compiler:compile
mvn surefire:test
```

---

## 9. Maven Build Profiles

Profiles = Different build configs (dev, test, prod).

Example:

```xml
<profiles>
  <profile>
    <id>dev</id>
    <properties>
      <db.url>jdbc:h2:mem:dev</db.url>
    </properties>
  </profile>

  <profile>
    <id>prod</id>
    <properties>
      <db.url>jdbc:mysql://localhost/prod</db.url>
    </properties>
  </profile>
</profiles>
```

Run:

```bash
mvn package -Pdev
```

---

## 10. Effective POM

Maven merges:

* Your POM
* Super POM (defaults)
* Parent POM (if any)

Check final merged config:

```bash
mvn help:effective-pom
```

---

## 11. Dependency Management & Versions

* **SNAPSHOT** → Development version (changes often).
* **Release version** → Stable.
* Parent POM can define versions for all children.

Example:

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-dependencies</artifactId>
      <version>3.3.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>
```

---

## 12. Multi-Module Projects

For enterprise apps → Parent POM + child modules.

```
parent-project/
 ├─ pom.xml   (packaging=pom)
 ├─ service/
 │   └─ pom.xml
 ├─ web/
 │   └─ pom.xml
```

Parent POM declares modules:

```xml
<modules>
  <module>service</module>
  <module>web</module>
</modules>
```

---

## 13. Key Maven Commands Cheat Sheet

```bash
mvn clean             # Delete target/
mvn compile           # Compile main sources
mvn test              # Run tests
mvn package           # Create JAR/WAR
mvn install           # Install to local repo
mvn deploy            # Deploy to remote repo

# Inspect
mvn dependency:tree
mvn help:effective-pom
mvn help:describe -Dplugin=compiler
```

---

## 14. Maven Best Practices

✅ Always lock dependency versions.
✅ Use parent POM for large org projects.
✅ Avoid SNAPSHOT in production.
✅ Keep plugins updated.
✅ Use `dependency:tree` to resolve conflicts.
✅ Stick to standard directory layout.

---

👉 This is the **Maven Core Roadmap**:

* Installation
* POM basics
* Dependencies & scopes
* Repositories
* Lifecycle (default, clean, site)
* Plugins & goals
* Profiles
* Multi-module
* Effective POM
* Best practices

