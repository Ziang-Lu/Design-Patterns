# Delegation Pattern (委托模式)

## Definition & Explanation

The Delegation Pattern is a **structural pattern** that **allows object aggregation to achieve the same code reuse as inheritance: an object handles a request by delegating the request to a internal object (the delegate)**, within the context of the original object.

*Delegation Pattern passes the responsibility of the sender object to a receiver object.*

<br>

## Code Example

```java
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
     * Receiver object of the designing delegation.
     */
    private final WhoCanDesign designer;
    /**
     * Receiver object of the coding delegation.
     */
    private final WhoCanCode programmer;

    /**
     * Default constructor.
     */
    public LazyEmployee() {
        designer = new GoodDesigner();
        programmer = new FastCoder();
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

<br>

```python
from abc import ABC, abstractmethod


class WhoCanDesign(ABC):
    """
    Abstract class of a person who can design.
    """
    __slots__ = []

    @abstractmethod
    def design(self) -> None:
        """
        Designs a program.
        :return: None
        """
        pass


class GoodDesigner(WhoCanDesign):
    """
    Good designer.
    """
    __slots__ = []

    def design(self):
        print('Designed by GoodDesigner')


class WhoCanCode(ABC):
    """
    Abstract class of a person who can program.
    """
    __slots__ = []

    @abstractmethod
    def code(self) -> None:
        """
        Codes a program.
        :return: None
        """
        pass


class FastCoder(WhoCanCode):
    """
    Fast coder.
    """
    __slots__ = []

    def code(self):
        print('Coded by FastCoder')


class WhoCanTest(ABC):
    """
    Abstract class of a person who can test.
    """
    __slots__ = []

    @abstractmethod
    def test(self) -> None:
        """
        Tests a program.
        :return: None
        """
        pass


class DangerousTester(WhoCanTest):
    """
    Dangerous tester.
    """
    __slots__ = []

    def test(self):
        print('Tested by DangerousTester')


class LazyEmployee(WhoCanDesign, WhoCanCode):
    """
    LazyEmployee class that uses Delegation Pattern to delegate some of the
    responsibilities of this class to a receiver object.
    This is like a lazy employee delegating his work to some outsourcing
    companies or individuals.
    """
    __slots__ = ['_designer', '_programmer']

    def __init__(self):
        """
        Default constructor.
        """
        self._designer = GoodDesigner()
        self._programmer = FastCoder()

    def design(self):
        self._designer.design()

    def code(self):
        self._programmer.code()

    def test(self, tester: WhoCanTest) -> None:
        """
        Tests a program using the given tester.
        This method is an example of delegation without aggregation, but by
        simply passing in the receiver object for delegation.
        :param tester: WhoCanTest
        :return: None
        """
        tester.test()


def main():
    employee = LazyEmployee()
    employee.design()
    employee.code()
    employee.test(DangerousTester())


if __name__ == '__main__':
    main()

# Output:
# Designed by GoodDesigner
# Coded by FastCoder
# Tested by DangerousTester

```

