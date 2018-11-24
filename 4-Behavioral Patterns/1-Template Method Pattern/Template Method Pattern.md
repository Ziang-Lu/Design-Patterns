# Template Method Pattern (模板方法模式)

## Applicability

* When we want to implement an algorithm, which consists of a fixed sequence of steps; however, the specific steps may vary depending on the context

  ***

  **Compare to a simply polymorphic override:**

  In a simply polymorphic override, the base method would be entirely rewritten in subclasses, which allows radical change to the workflow. However, we want the general workflow of the base method to be fixed, and only the specific details of the workflow are allowed to change.

  ***

<br>

## Definition & Explanation

The Template Method Pattern is a **behavioral pattern** that **defines a sequence of steps (program skeleton) of an algorithm, so that the subclasses are allowed to override the steps themselves, but not allowed to change the algorithm's structure**. In other words, in Template Method Pattern, we <u>put the general logic in the abstract parent class, and let the child classes define the specifics</u>.

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/1-Template%20Method%20Pattern/template_method_pattern_illustration.png?raw=true">

=> At runtime, a concrete class is instantiated. The template method performs the overall algorithm in the same steps every time, but the details of some steps depend on which subclass was instantiated.

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/1-Template%20Method%20Pattern/template_method_pattern.png?raw=true">

* Note that **the template method should be defined as `final`, so that subclasses cannot override it, i.e., they cannot change the sequence of steps of the algorithm**
* The `operation1()`, `operation2()`, `operation3()` methods in the abstract `Template` class works like a placeholder for the steps of the algorithm.

<br>

## Code Example

```java
/**
 * Abstract TemplateHouse class that works as "Template" and actually uses
 * Template Method Pattern.
 * This class contains the template method, which defines a sequence of steps
 * of an algorithm, so that the subclasses are allowed to override the steps
 * themselves, but not allowed to change the algorithm's structure.
 */
abstract class TemplateHouse {
    /**
     * Template method to build this house.
     * This method contains the general logic to build the house, which is fixed
     * and should not be changed, and let the child classes define the
     * specifics.
     *
     * Note that this method should be defined as "final", so that subclasses
     * cannot override it, i.e., they cannot change the sequence of steps of the
     * algorithm
     */
    final void buildHouse() {
        System.out.println("Start building a " + getClass().getSimpleName());
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
        System.out.println(getClass().getSimpleName() + " successfully built!");
    }

    /**
     * Private helper method to build the foundation of this house.
     */
    private void buildFoundation() {
        System.out.println("Building foundation with cement, sand and iron rods");
    }

    /**
     * Protected helper method to build the pillars of this house.
     * This method works like a placeholder for a step of the above algorithm.
     */
    protected abstract void buildPillars();

    /**
     * Protected helper method to build the walls of this house.
     * This method works like a placeholder for a step of the above algorithm.
     */
    protected abstract void buildWalls();

    /**
     * Protected helper method to build the windows of this house.
     * This method works like a placeholder for a step of the above algorithm.
     */
    protected abstract void buildWindows();
}

/**
 * Concrete WoodenHouse class that works as "Implementation".
 * This class contains methods to override the steps defined in the template
 * method in the abstract parent class.
 */
class WoodenHouse extends TemplateHouse {
    @Override
    protected void buildPillars() {
        System.out.println("Building pillars with Wood coating");
    }

    @Override
    protected void buildWalls() {
        System.out.println("Building Wooden walls");
    }

    @Override
    protected void buildWindows() {
        System.out.println("Building Wooden windows");
    }
}

/**
 * Concrete GlassHouse class that works as "Implementation".
 * This class contains methods to override the steps defined in the template
 * method in the abstract parent class.
 */
class GlassHouse extends TemplateHouse {
    @Override
    protected void buildPillars() {
        System.out.println("Building pillars with Glass coating");
    }

    @Override
    protected void buildWalls() {
        System.out.println("Building Glass walls");
    }

    @Override
    protected void buildWindows() {
        System.out.println("Building Glass windows");
    }
}

/**
 * Application that actually uses Template Method Pattern.
 *
 * @author Ziang Lu
 */
public class TemplateMethodPatternTest {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        TemplateHouse house = new WoodenHouse();
        // Call the template method, and let the concrete class to implement the steps of the algorithm in this template
        // method
        house.buildHouse();

        System.out.println();

        house = new GlassHouse();
        // Call the template method, and let the concrete class to implement the steps of the algorithm in this template
        // method
        house.buildHouse();

        /*
         * Output:
         * Start building a WoodenHouse
         * Building foundation with cement, sand and iron rods
         * Building pillars with Wood coating
         * Building Wooden walls
         * Building Wooden windows
         * WoodenHouse successfully built!
         *
         * Start building a GlassHouse
         * Building foundation with cement, sand and iron rods
         * Building pillars with Glass coating
         * Building Glass walls
         * Building Glass windows
         * GlassHouse successfully built!
         */
    }

}
```

<br>

```python
from abc import ABC, abstractmethod


class TemplateHouse(ABC):
    """
    Abstract TemplateHouse class that works as "Template" and actually uses
    Template Method Pattern.
    This class contains the template method, which defines a sequence of steps
    of an algorithm, so that the subclasses are allowed to override the steps
    themselves, but not allowed to change the algorithm's structure.
    """
    __slots__ = []

    def build_house(self) -> None:
        """
        Template method to build this house.
        This method contains the general logic to build the house, which is
        fixed and should not be changed, and let the child classes define the
        specifics.

        Note that this method should be defined as "final", so that subclasses
        cannot override it, i.e., they cannot change the sequence of steps of
        the algorithm
        :return: None
        """
        print(f'Start building {type(self).__name__}...')
        self._build_foundation()
        self._build_pillars()
        self._build_walls()
        self._build_windows()
        print(f'{type(self).__name__} successfully built!')

    def _build_foundation(self) -> None:
        """
        Private helper function to build the foundation of this house.
        :return: None
        """
        print('Building foundation with cement, sand and iron rods')

    @abstractmethod
    def _build_pillars(self) -> None:
        """
        Protected helper function to build the pillars of this house.
        This method works like a placeholder for a step of the above algorithm.
        :return: None
        """
        pass

    @abstractmethod
    def _build_walls(self) -> None:
        """
        Protected helper function to build the walls of this house.
        This method works like a placeholder for a step of the above algorithm.
        :return: None
        """
        pass

    @abstractmethod
    def _build_windows(self) -> None:
        """
        Protected helper function to build the windows of this house.
        This method works like a placeholder for a step of the above algorithm.
        :return: None
        """
        pass


class WoodenHouse(TemplateHouse):
    """
    Concrete WoodenHouse class that works as "Implementation".
    This class contains methods to override the steps defined in the template
    method in the abstract parent class.
    """
    __slots__ = []

    def _build_pillars(self):
        print('Building pillars using Wood coating')

    def _build_walls(self):
        print('Building Wooden walls')

    def _build_windows(self):
        print('Building Wooden windows')


class GlassHouse(TemplateHouse):
    """
    Concrete GlassHouse class that works as "Implementation".
    This class contains methods to override the steps defined in the template
    method in the abstract parent class.
    """
    __slots__ = []

    def _build_pillars(self):
        print('Building pillars using Glass coating')

    def _build_walls(self):
        print('Building Glass walls')

    def _build_windows(self):
        print('Building Glass windows')


def main():
    house = WoodenHouse()
    # Call the template method, and let the concrete class to implement the
    # steps of the algorithm in this template method
    house.build_house()

    print()

    house = GlassHouse()
    # Call the template method, and let the concrete class to implement the
    # steps of the algorithm in this template method
    house.build_house()


if __name__ == '__main__':
    main()

# Output:
# Start building WoodenHouse...
# Building foundation using cement, sand, iron rods and sand
# Building pillars using Wood coating
# Building Wooden walls
# Building Wooden windows
# WoodenHouse successfully built!
#
# Start building GlassHouse...
# Building foundation using cement, sand and iron rods
# Building pillars using Glass coating
# Building Glass walls
# Building Glass windows
# GlassHouse successfully built!
```

<br>

## Benefits

* Since we implement the general workflow structure only once in the abstract parent class (in `templateMethod()`), and implement the necessary variations within the workflow in subclasses (`operation1()`, `operation2()`, `operation3()`), we successfully minimized code duplication.
* Open for extension, close for modification

