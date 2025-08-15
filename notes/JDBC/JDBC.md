
```
java -cp h2-2.1.214.jar org.h2.tools.Server -web -webPort 9001 -tcp -tcpPort 9002 -ifNotExists -baseDir C:/Users/<your bank id>/h2db
```

### 1. **`java`**

Runs the Java runtime to execute a Java application.

---

### 2. **`-cp h2-2.1.214.jar`**

`-cp` means “classpath” — it tells Java where to find classes and resources.
Here, it's pointing to the H2 database JAR file:

* `h2-2.1.214.jar` contains the H2 database engine and its tools.

---

### 3. **`org.h2.tools.Server`**

This is the Java class that starts the H2 server mode.
The H2 database has a built-in `Server` tool that can run in different modes (web, TCP).

---

### 4. **`-web`**

Enables the H2 web console so you can access the database via a browser.

---

### 5. **`-webPort 9001`**

Specifies the port number for the web console.
Example: you could access it at `http://localhost:9001`.

---

### 6. **`-tcp`**

Enables TCP connections so external applications can connect to the database.

---

### 7. **`-tcpPort 9002`**

Specifies the TCP server port for database connections (e.g., JDBC connections).

---

### 8. **`-ifNotExists`**

Only creates the database if it doesn’t already exist.
Prevents overwriting existing data.

---

### 9. **`-baseDir C:/Users/<your bank id>/h2db`**

Sets the base directory where database files will be stored.
Here, `<your bank id>` is a placeholder — you’d replace it with your actual folder name.

