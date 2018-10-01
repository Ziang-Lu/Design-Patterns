# Lazy Initialization Pattern (惰性初始化模式)

## Definition & Explanation

=> Lazy Initialization Pattern is a **creational pattern** of **delaying the initialization of objects until the first time it is needed**.

This is typically accomplished by augmenting an accessor method to <u>check whether a private member, acting as a cache, has already been initialized. If it has, it is returned straight away. If not, a new instance is created, placed into the member variable, and returned to the caller just-in-time for its first use</u>.

<br>

## Code Example

```java
import java.util.HashMap;
import java.util.Map;

/**
 * Fruit types.
 */
enum FruitType {
    APPLE, BANANA, NONE
}

/**
 * Fruit class.
 */
class Fruit {
    /**
     * Mapping between fruit types and the corresponding fruit instances.
     */
    private static final Map<FruitType, Fruit> fruits = new HashMap<>();

    /**
     * Gets the corresponding fruit by the given fruit type.
     * However, this implementation is thread-unsafe. Check out the method body.
     * @param type type of the fruit
     * @return corresponding fruit instance
     */
    static Fruit getFruitByTypeThreadUnsafe(FruitType type) {
        if (!fruits.containsKey(type)) { // Thread-A, Thread-B
            Fruit fruit = new Fruit(type); // Thread-A, Thread-B
            // In this case, this instance is created twice, which shouldn't be correct.
            fruits.put(type, fruit);
        }
        return fruits.get(type);
    }

    /**
     * Gets the corresponding fruit by the given fruit type.
     * To avoid the above case, use a double-check locking mechanism.
     * @param type type of the fruit
     * @return corresponding fruit instance
     */
    static Fruit getFruitByTypeThreadSafe(FruitType type) {
        if (!fruits.containsKey(type)) { // Thread-A, Thread-B
            synchronized (fruits) { // Thread-A   ->   Thread-B
                // For Thread-A, it simply creates the instance.

                // However, since at the moment Thread-B enters this synchronized block, it has already passed the
                // null-check at [1], so if we don't do another null-check here, Thread-B will again create the
                // instance, which shouldn't be correct.

                // Thus, we need to do another null-check.
                // Now at the moment Thread-B enters this synchronized block, since Thread-A has created the instance,
                // Thread-B will do nothing and exit the block.
                if (!fruits.containsKey(type)) {
                    Fruit fruit = new Fruit(type);
                    fruits.put(type, fruit);
                }
            }
        }
        return fruits.get(type);
    }

    /**
     * Shows all the fruits.
     */
    static void showAll() {
        if (!fruits.isEmpty()) {
            System.out.println("Number of fruit instances made: " + fruits.size());
            for (FruitType type : fruits.keySet()) {
                String typeName = type.toString();
                String prettyTypeName = typeName.charAt(0) + typeName.substring(1).toLowerCase();
                System.out.println(prettyTypeName);
            }
        }
    }

    /**
     * Type of this fruit.
     */
    private final FruitType type;

    /**
     * Private constructor with parameter.
     * This has to be private so that the class instances
     * @param type type of the fruit
     */
    private Fruit(FruitType type) {
        this.type = type;
    }
}

/**
 * Simple Lazy Initialization Pattern implementation.
 *
 * @author Ziang Lu
 */
public class LazyInitialization {

    /**
     * Main driver.
     * @param args arguments from command line.
     */
    public static void main(String[] args) {
        Fruit.getFruitByTypeThreadSafe(FruitType.apple);
        Fruit.showAll();
        Fruit.getFruitByTypeThreadSafe(FruitType.banana);
        Fruit.showAll();
        Fruit.getFruitByTypeThreadSafe(FruitType.apple);
        Fruit.showAll();

        /*
         * Output:
         * Number of fruit instances made: 1
         * Apple
         *
         * Number of fruit instances made: 2
         * Apple
         * Banana
         *
         * Number of fruit instances made: 2
         * Apple
         * Banana
         */
    }

}

```

<br>

```python
from enum import Enum, auto


class FruitType(Enum):
    """
    Fruit type.
    """
    APPLE = auto()
    BANANA = auto()
    NONE = auto()


class Fruit(object):
    """
    Fruit class.
    """
    __slots__ = ['_type']
    _fruits = {}

    @classmethod
    def get_fruit_by_type(cls, type_: FruitType):
        """
        Gets the corresponding fruit by the given fruit type.
        :param type_: FruitType
        :return: Fruit
        """
        if type_ not in cls._fruits:
            cls._fruits[type_] = Fruit(type_)
        return cls._fruits[type_]

    @classmethod
    def show_all(cls) -> None:
        """
        Shows all fruits.
        :return: None
        """
        if cls._fruits:
            print(f'Number of fruit instances made: {len(cls._fruits)}')
            for type_ in cls._fruits.keys():
                type_name = str(type_)
                pretty_type_name = cls._process_fruit_type(type_name)
                print(pretty_type_name)

    @staticmethod
    def _process_fruit_type(fruit_type_name: str) -> str:
        """
        Private static helper function to process the given FruitType name.
        :param fruit_type_name: str
        :return: str
        """
        dot = fruit_type_name.find('.')
        fruit_name =  fruit_type_name[dot + 1:]
        return fruit_name[0] + fruit_name[1:].lower()

    def __init__(self, type_: FruitType):
        """
        Constructor with parameter.
        :param type_: FruitType
        """
        self._type = type_


def main():
    Fruit.get_fruit_by_type(FruitType.APPLE)
    Fruit.show_all()
    Fruit.get_fruit_by_type(FruitType.BANANA)
    Fruit.show_all()
    Fruit.get_fruit_by_type(FruitType.APPLE)
    Fruit.show_all()


if __name__ == '__main__':
    main()


# Output:
# Number of fruit instances made: 1
# Apple
# Number of fruit instances made: 2
# Apple
# Banana
# Number of fruit instances made: 2
# Apple
# Banana
```

<br>

## Benefit

<u>Impact of object instantiation is spread in time rather than concentrated in the startup phase of a system</u>, and thus mean response times can be greatly improved.

