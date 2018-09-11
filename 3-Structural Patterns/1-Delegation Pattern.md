# Delegation Pattern (委托模式)

## Definition & Explanation

The Delegation Pattern is a **structural pattern** that **allows object aggregation to achieve the same code reuse as inheritance: an object handles a request by delegating the request to a internal object (the delegate)**, within the context of the original object.

*Delegation Pattern passes the responsibility of the sender object to a receiver object.*

<br>

## Code Example

```java
package delegation;

/**
 * Interface of a person who can design a program.
 */
interface WhoCanDesign {
    /**
     * Designs a program.
     */
    void design();
}

/**
 * Good designer.
 */
class GoodDesigner implements WhoCanDesign {
    @Override
    public void design() {
        System.out.println("Designed by GoodDesigner");
    }
}

/**
 * Interface of a person who can code a program.
 */
interface WhoCanCode {
    /**
     * Codes a program.
     */
    void code();
}

/**
 * Fast coder.
 */
class FastCoder implements WhoCanCode {
    @Override
    public void code() {
        System.out.println("Coded by FastCoder");
    }
}

/**
 * Interface of a person who can test a program.
 */
interface WhoCanTest {
    /**
     * Tests a program.
     */
    void test();
}

/**
 * Dangerous tester.
 */
class DangerousTester implements WhoCanTest {
    @Override
    public void test() {
        System.out.println("Tested by DangerousTester");
    }
}

/**
 * LazyEmployee class that uses Delegation Pattern to delegate some of the
 * responsibilities of this class to a receiver object.
 * This is like a lazy employee delegating his work to some outsourcing
 * companies or individuals.
 *
 * @author Ziang Lu
 */
public class LazyEmployee implements WhoCanDesign, WhoCanCode {

    /**
     * Receiver object of the coding delegation.
     */
    private final WhoCanCode programmer;
    /**
     * Receiver object of the designing delegation.
     */
    private final WhoCanDesign designer;

    /**
     * Default constructor.
     */
    public LazyEmployee() {
        programmer = new FastCoder();
        designer = new GoodDesigner();
    }

    @Override
    public void design() {
        designer.design();
    }

    @Override
    public void code() {
        programmer.code();
    }

    /**
     * Tests a program using the given tester.
     * This method is an example of delegation without aggregation, but by
     * simply passing in the receiver object for delegation.
     * @param tester tester used to test a program
     */
    public void test(WhoCanTest tester) {
        tester.test();
    }

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        LazyEmployee employee = new LazyEmployee();
        employee.design();
        employee.code();
        employee.test(new DangerousTester());

        /*
         * Output:
         * Designed by GoodDesigner.
         * Coded by FastCoder.
         * Tested by DangerousTester.
         */
    }

}

```

