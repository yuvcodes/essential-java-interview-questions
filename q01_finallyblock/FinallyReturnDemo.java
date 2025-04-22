package q01_finallyblock;

public class FinallyReturnDemo {
    public static void main(String[] args) {
        System.out.println(testMethod());
    }

    static String testMethod() {
        try {
            System.out.println("In try block");
            //int res = 10 / 0; // exception
            return "Returned from try";
        } catch (Exception e) {
            System.out.println("In catch block");
            return "Returned from catch";
        } finally {
            System.out.println("In finally block");  // This WILL execute
        }
    }
}

/* output without exception:
    In try block
    In finally block
    Returned from try
*/

/* output with exception:
    In try block
    In catch block
    In finally block
    Returned from catch
*/

