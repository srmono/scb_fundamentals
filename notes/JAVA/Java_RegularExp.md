## **1. What Are Regular Expressions in Java?**

Regular Expressions (regex) in Java are patterns used to match character sequences in strings.
They’re implemented in the **`java.util.regex`** package:

* **Pattern** → compiled representation of the regex.
* **Matcher** → engine that applies the pattern to a text.
* **PatternSyntaxException** → thrown if the regex is invalid.

---

## **2. Basic Syntax Recap**

| Pattern | Meaning                       |    |
| ------- | ----------------------------- | -- |
| `.`     | Any single character          |    |
| `\d`    | Digit \[0-9]                  |    |
| `\D`    | Non-digit                     |    |
| `\w`    | Word character \[a-zA-Z\_0-9] |    |
| `\W`    | Non-word character            |    |
| `\s`    | Whitespace                    |    |
| `^`     | Start of string               |    |
| `$`     | End of string                 |    |
| `[]`    | Character class               |    |
| `[^ ]`  | Negated character class       |    |
| `*`     | 0 or more repetitions         |    |
| `+`     | 1 or more repetitions         |    |
| `?`     | 0 or 1 repetition             |    |
| `{n}`   | Exactly n repetitions         |    |
| `{n,}`  | n or more repetitions         |    |
| `{n,m}` | Between n and m repetitions   |    |
| \`      | \`                            | OR |
| `(...)` | Capturing group               |    |

---

## **3. Full Java Example with Real Use Cases**

```java
import java.util.regex.*;

public class RegexExamples {
    public static void main(String[] args) {

        // 1. SIMPLE MATCH
        String text1 = "Java is fun";
        Pattern pattern1 = Pattern.compile("Java");
        Matcher matcher1 = pattern1.matcher(text1);
        System.out.println("Contains 'Java': " + matcher1.find());

        // 2. EMAIL VALIDATION
        String email = "test.user@example.com";
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        System.out.println("Valid email? " + email.matches(emailRegex));

        // 3. PHONE NUMBER VALIDATION (Indian format)
        String phone = "+91-9876543210";
        String phoneRegex = "^\\+91-\\d{10}$";
        System.out.println("Valid phone? " + phone.matches(phoneRegex));

        // 4. FIND ALL DIGITS IN TEXT
        String text2 = "Order numbers: 12345, 67890.";
        Pattern digitPattern = Pattern.compile("\\d+");
        Matcher digitMatcher = digitPattern.matcher(text2);
        System.out.print("Numbers found: ");
        while (digitMatcher.find()) {
            System.out.print(digitMatcher.group() + " ");
        }
        System.out.println();

        // 5. SPLITTING TEXT BY REGEX
        String sentence = "apple,banana;grapes|orange";
        String[] fruits = sentence.split("[,;|]");
        System.out.println("Fruits:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // 6. REPLACING TEXT WITH REGEX
        String messy = "This   has    multiple   spaces";
        String cleaned = messy.replaceAll("\\s+", " ");
        System.out.println("Cleaned: " + cleaned);

        // 7. EXTRACTING HASHTAGS FROM TEXT
        String tweet = "Loving #Java and #coding!";
        Pattern hashPattern = Pattern.compile("#\\w+");
        Matcher hashMatcher = hashPattern.matcher(tweet);
        System.out.print("Hashtags: ");
        while (hashMatcher.find()) {
            System.out.print(hashMatcher.group() + " ");
        }
        System.out.println();

        // 8. CASE-INSENSITIVE MATCH
        Pattern ciPattern = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        Matcher ciMatcher = ciPattern.matcher("I love JAVA programming");
        System.out.println("Case-insensitive match found? " + ciMatcher.find());

        // 9. URL VALIDATION
        String url = "https://www.example.com";
        String urlRegex = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$";
        System.out.println("Valid URL? " + url.matches(urlRegex));
    }
}
```

---

## **4. What This Code Demonstrates**

✅ Checking for exact word in text
✅ Email validation
✅ Phone number validation
✅ Extracting all digits
✅ Splitting text with multiple delimiters
✅ Removing extra spaces
✅ Extracting hashtags from text
✅ Case-insensitive search
✅ URL validation

---

## **5. Sample Output**

```
Contains 'Java': true
Valid email? true
Valid phone? true
Numbers found: 12345 67890 
Fruits:
apple
banana
grapes
orange
Cleaned: This has multiple spaces
Hashtags: #Java #coding 
Case-insensitive match found? true
Valid URL? true
```

