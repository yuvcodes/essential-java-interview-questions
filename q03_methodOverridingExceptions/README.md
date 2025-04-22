# Java Exceptions: Checked vs Unchecked

Understanding exception types is **crucial for writing robust and error-free Java applications**. This guide simplifies the core concepts behind **Checked** and **Unchecked Exceptions**, with real-world examples, best practices, and tips.

---

## What is an Exception?
> An **exception** is an event that disrupts the normal flow of your program's execution. It occurs during runtime.

---

## Java Exception Hierarchy
```
Object  
└── Throwable  
    ├── Error           (JVM related, you shouldn't handle these)
    └── Exception  
        ├── Checked Exceptions (must be handled)  
        └── Unchecked Exceptions (optional to handle)  
```

---

## Checked Exceptions
> These are **compile-time exceptions**.  
> The compiler forces you to **either handle them using `try-catch` or declare them with `throws`**.

### Key Points:
- Occur at **compile time**.
- Must be handled explicitly.
- Represent conditions outside program control (like file not found, DB error, etc.)

### Examples:
- `IOException`
- `SQLException`
- `FileNotFoundException`
- `ParseException`

### Example Code:
```java
import java.io.*;

public class CheckedExample {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
```

---

## Unchecked Exceptions
> These are **runtime exceptions**.  
> The compiler does **not force you** to handle them, though you can.

### Key Points:
- Occur at **runtime**.
- Not required to catch or declare.
- Usually caused by **programming errors** (null access, bad casting, etc.)

### Examples:
- `NullPointerException`
- `ArithmeticException`
- `ArrayIndexOutOfBoundsException`
- `IllegalArgumentException`

### Example Code:
```java
public class UncheckedExample {
    public static void main(String[] args) {
        int a = 10 / 0; // ArithmeticException
    }
}
```

---

## Comparison Table
| Feature                  | Checked Exception        | Unchecked Exception       |
|--------------------------|--------------------------|----------------------------|
| Compiler Check           | Yes                      | No                         |
| When Detected            | Compile Time             | Runtime                    |
| Handling Requirement     | Must handle or declare   | Optional                   |
| Common Causes            | External issues (File, DB)| Code logic errors          |
| Examples                 | `IOException`, `SQLException` | `NullPointerException`, `ArithmeticException` |

---

## Best Practices
- ✅ Always handle **checked exceptions** properly using `try-catch` or `throws`.
- ✅ Use custom exceptions (extending `Exception` or `RuntimeException`) when needed.
- ❌ Don't suppress exceptions with empty catch blocks.
- ❌ Avoid throwing generic `Exception` or `Throwable`.

---

## Summary
> ☑️ **Checked = Must Handle | Compile Time | External Causes**  
> ☑️ **Unchecked = Optional | Runtime | Coding Mistakes**

---

# Java Method Overriding: Exception Rules 

## Java Exception Hierarchy (Simplified)

```
java.lang.Object
└── java.lang.Throwable
    ├── java.lang.Exception (Checked)
    │   ├── java.io.IOException
    │   │   ├── java.io.FileNotFoundException
    │   │   ├── java.io.EOFException
    │   │   ├── java.io.InterruptedIOException
    │   │   └── java.io.UTFDataFormatException
    │   ├── java.sql.SQLException
    │   ├── java.lang.ClassNotFoundException
    │   ├── java.lang.CloneNotSupportedException
    │   ├── java.lang.InstantiationException
    │   ├── java.lang.InterruptedException
    │   ├── java.lang.NoSuchMethodException
    │   ├── java.lang.NoSuchFieldException
    │   └── java.lang.InvocationTargetException
    ├── java.lang.RuntimeException (Unchecked)
    │   ├── java.lang.ArithmeticException
    │   ├── java.lang.ArrayStoreException
    │   ├── java.lang.ClassCastException
    │   ├── java.lang.EnumConstantNotPresentException
    │   ├── java.lang.IllegalArgumentException
    │   │   ├── java.lang.NumberFormatException
    │   │   └── java.nio.file.InvalidPathException
    │   ├── java.lang.IllegalStateException
    │   ├── java.lang.IllegalMonitorStateException
    │   ├── java.lang.IndexOutOfBoundsException
    │   │   ├── java.lang.ArrayIndexOutOfBoundsException
    │   │   └── java.lang.StringIndexOutOfBoundsException
    │   ├── java.lang.NullPointerException
    │   ├── java.lang.SecurityException
    │   ├── java.lang.UnsupportedOperationException
    │   └── java.lang.TypeNotPresentException
    └── java.lang.Error (Unchecked)
        ├── java.lang.AssertionError
        ├── java.lang.OutOfMemoryError
        ├── java.lang.StackOverflowError
        ├── java.lang.VirtualMachineError
        │   ├── java.lang.InternalError
        │   └── java.lang.UnknownError
        ├── java.lang.LinkageError
        │   ├── java.lang.AbstractMethodError
        │   ├── java.lang.ClassCircularityError
        │   ├── java.lang.ClassFormatError
        │   ├── java.lang.IllegalAccessError
        │   ├── java.lang.IncompatibleClassChangeError
        │   ├── java.lang.InstantiationError
        │   ├── java.lang.NoClassDefFoundError
        │   └── java.lang.UnsupportedClassVersionError
            
```

---

## ✅ Rule 1: Overriding method can throw **unchecked exceptions** freely
- No restriction on **RuntimeExceptions** (unchecked).
- The compiler doesn't enforce any checks for them.

```java
class Parent {
    void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    @Override
    void show() throws ArithmeticException { // ✅ Allowed
        System.out.println("Child");
    }
}
```

---

## ✅ Rule 2: Overriding method can throw **same or subclass of checked exception**
- If the superclass method throws a **checked exception**, the subclass can:
    - Throw the **same** exception, or
    - Throw a **subclass** of that exception

```java
import java.io.*;

class Parent {
    void read() throws IOException {
        System.out.println("Reading file...");
    }
}

class Child extends Parent {
    @Override
    void read() throws FileNotFoundException { // ✅ Allowed (subclass of IOException)
        System.out.println("Reading file (child)...");
    }
}
```

---

## ❌ Rule 3: Overriding method **cannot throw a new or broader checked exception**
- If the superclass method does **not throw** a checked exception, subclass method **cannot add one**.

```java
import java.io.*;

class Parent {
    void write() {
        System.out.println("Writing...");
    }
}

class Child extends Parent {
    @Override
    void write() throws IOException { // ❌ Compile-time error
        System.out.println("Child writing...");
    }
}
```

---

## ✅ Rule 4: Overriding method can choose to **not throw any exception**
- Even if the superclass method throws a checked exception, the subclass method can override it **without any exceptions**.

```java
import java.io.*;

class Parent {
    void connect() throws IOException {
        System.out.println("Connecting...");
    }
}

class Child extends Parent {
    @Override
    void connect() { // ✅ Allowed
        System.out.println("Child connecting...");
    }
}
```

---

## ✅ Rule 5: Overriding method can throw **unchecked exceptions** even if superclass doesn't
- Runtime exceptions (like `NullPointerException`, `ArithmeticException`) **can be added** even if not in superclass.

```java
class Parent {
    void calculate() {
        System.out.println("Parent calculating...");
    }
}

class Child extends Parent {
    @Override
    void calculate() throws NullPointerException { // ✅ Allowed
        System.out.println("Child calculating...");
    }
}
```

---

## ✅ Rule 6: Constructors are **not inherited**, so exception overriding doesn't apply
- Constructor exceptions are not subject to method overriding rules.
- They follow their own chaining and declaration rules.

```java
class Parent {
    Parent() throws Exception {
        System.out.println("Parent constructor");
    }
}

class Child extends Parent {
    Child() throws Exception { // ✅ Must declare or handle
        super();
        System.out.println("Child constructor");
    }
}
```

---

## ⚠️ Summary Table
| Case | Rule | Checked Exception | Unchecked Exception |
|------|------|-------------------|----------------------|
| 1 | Subclass throws same exception | ✅ | ✅ |
| 2 | Subclass throws narrower (subclass) | ✅ | ✅ |
| 3 | Subclass throws broader/extra checked | ❌ | ✅ |
| 4 | Subclass throws nothing | ✅ | ✅ |
| 5 | Superclass throws none, subclass throws checked | ❌ | ✅ |
| 6 | Constructors and exceptions | N/A | N/A |

---

## 🧠 Cheat Code Summary
> ☑️ **Unchecked (runtime)**: Free to throw in child.  
> ☑️ **Checked (compile-time)**: Follow same or narrower rule.  
> ❌ Never add new checked exceptions if parent doesn't throw any.

---
