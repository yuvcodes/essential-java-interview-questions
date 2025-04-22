package q01_finallyBlockTryCatch;

public class FinallyExitDemo {
    public static void main(String[] args) {
        testMethod();
    }

    static void testMethod() {
        try {
            System.out.println("In try block");
            System.exit(0); // Forcefully terminates JVM
        } catch (Exception e) {
            System.out.println("In catch block");
        } finally {
            System.out.println("In finally block");  // This will NOT execute
        }
    }
}

/*
    output:
        In try block
*/