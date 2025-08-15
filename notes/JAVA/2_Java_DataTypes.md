Let's Understand **Java Data Types**  **Primitive** and **Non-Primitive** types.

---

## **1. Primitive Data Types**

Primitive data types are the most basic types in Java. They are predefined by the language and store simple values (not objects).

### **a. Boolean Type**

* **Type**: `boolean`
* **Values**: `true` or `false`
* **Example**:

```java
boolean isJavaFun = true;
boolean isFishTasty = false;
```

---

### **b. Numeric Types**

#### **i. Character Type**

* **Type**: `char`
* **Stores**: A single 16-bit Unicode character.
* **Example**:

```java
char grade = 'A';
char symbol = '#';
```

---

#### **ii. Integral Types**

**Stores whole numbers (no decimals)**

* **byte**: 8-bit, range `-128` to `127`

```java
byte age = 25;
```

* **short**: 16-bit, range `-32,768` to `32,767`

```java
short year = 2025;
```

* **int**: 32-bit, range about `-2 billion` to `2 billion`

```java
int population = 1000000;
```

* **long**: 64-bit, used for large integers

```java
long distanceToMoon = 384400000L;
```

---

#### **iii. Floating-Point Types**

**Stores numbers with decimal points**

* **float**: 32-bit, single precision

```java
float price = 19.99f;
```

* **double**: 64-bit, double precision

```java
double pi = 3.14159265359;
```

---

## **2. Non-Primitive Data Types**

Non-primitive (or reference) types are created by the programmer and refer to objects.

* **String**: Stores sequences of characters.

```java
String name = "Java";
```

* **Array**: Stores multiple values of the same type.

```java
int[] numbers = {1, 2, 3, 4};
```

* **Others**: Classes, Interfaces, Collections, etc.

---

✅ **Summary Table:**

| Type    | Category       | Example Value   |
| ------- | -------------- | --------------- |
| boolean | Boolean        | `true`          |
| char    | Character      | `'A'`           |
| byte    | Integer        | `100`           |
| short   | Integer        | `32000`         |
| int     | Integer        | `1000000`       |
| long    | Integer        | `9999999999L`   |
| float   | Floating-point | `3.14f`         |
| double  | Floating-point | `3.14159265359` |
| String  | Non-Primitive  | `"Java"`        |
| Array   | Non-Primitive  | `{1,2,3}`       |


---

## **Primitive Data Types**

### **1. Boolean**

* Stores only two values: `true` or `false`.

```java
boolean isJavaFun = true;
boolean isRaining = false;
System.out.println("Is Java fun? " + isJavaFun);
```

---

### **2. char (Character)**

* Stores a single 16-bit Unicode character.

```java
char grade = 'A';
char currencySymbol = '$';
System.out.println("Grade: " + grade);
```

---

### **3. byte**

* 8-bit integer; range: -128 to 127.

```java
byte age = 25;
System.out.println("Age: " + age);
```

---

### **4. short**

* 16-bit integer; range: -32,768 to 32,767.

```java
short year = 2025;
System.out.println("Year: " + year);
```

---

### **5. int**

* 32-bit integer; commonly used.

```java
int population = 1000000;
System.out.println("Population: " + population);
```

---

### **6. long**

* 64-bit integer; ends with `L` for large values.

```java
long distanceToMoon = 384400000L;
System.out.println("Distance to Moon: " + distanceToMoon + " meters");
```

---

### **7. float**

* 32-bit floating-point number; ends with `f`.

```java
float price = 19.99f;
System.out.println("Price: $" + price);
```

---

### **8. double**

* 64-bit floating-point number; higher precision than `float`.

```java
double pi = 3.14159265359;
System.out.println("Value of Pi: " + pi);
```

---

## **Non-Primitive Data Types**

### **1. String**

* Stores a sequence of characters.

```java
String language = "Java Programming";
System.out.println("Language: " + language);
```

---

### **2. Array**

* Stores multiple values of the same type.

```java
int[] numbers = {1, 2, 3, 4, 5};
System.out.println("First number: " + numbers[0]);
```

---

### **3. Example with All Together**

Here’s a complete Java program that demonstrates **all** data types:

```java
public class DataTypesExample {
    public static void main(String[] args) {
        // Primitive types
        boolean isJavaFun = true;
        char grade = 'A';
        byte age = 25;
        short year = 2025;
        int population = 1000000;
        long distanceToMoon = 384400000L;
        float price = 19.99f;
        double pi = 3.14159265359;

        // Non-primitive types
        String language = "Java Programming";
        int[] numbers = {1, 2, 3, 4, 5};

        // Output all values
        System.out.println("Boolean: " + isJavaFun);
        System.out.println("Char: " + grade);
        System.out.println("Byte: " + age);
        System.out.println("Short: " + year);
        System.out.println("Int: " + population);
        System.out.println("Long: " + distanceToMoon);
        System.out.println("Float: " + price);
        System.out.println("Double: " + pi);
        System.out.println("String: " + language);
        System.out.println("Array first element: " + numbers[0]);
    }
}
```
