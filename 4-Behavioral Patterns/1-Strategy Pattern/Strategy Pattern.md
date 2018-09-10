# Strategy Pattern (策略模式)

### Applicability

Sometimes, we need to carry out several computations / algorithms depending on certain conditions. Generally we go ahead in implementing those by applying either ternary operator or switch or if else.

Though initially somehow we manage to write those programs, if the program demands become too complex, then it is difficult to frame as well as maintain such, and writing all the logic in a single place is not advisable as it yields to tight coupling.

* When <u>a class defines many related behaviors and they appear in multiple conditional statements</u>

  => Instead of many conditional statements, <u>move the related conditional branches into their own strategy classes</u>

* When there are <u>different variants of an algorithm</u>
* => When there are many related classes that differ only in their behaviors

<br>

### Definition & Explanation

Strategy Pattern is a **behavioral pattern** that **provide multiple algorithms, a family of alrogithms, to perform a specific task (solve a specific problem), so that the client can select which actual implementation to use at runtime**.

*To simplify, Strategy Pattern enables <u>selecting an algorithm to perform a specific task at runtime</u>.*

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/1-Strategy%20Pattern/strategy_pattern_concept.png?raw=true" width="600px">

*The <u>client will decide</u> whether to use Solution A, Solution B or Solution C to finish the task <u>at runtime</u>.*

* `Context` is the interface to the outside world.
* `Algorithm (Strategy)` is the common interface for different algorithms
* `ConcreteStrategy` is an actual implementation for the algorithm.

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/1-Strategy%20Pattern/strategy_pattern.png?raw=true" width="300px">

The Strategy Pattern uses composition: behaviors of the client code are defined as separate interfaces and specific classes that implement these interfaces. This allows better decoupling between the behavior itself and the class that uses the behavior (the client).

In this way, <u>the behavior can be changed without breaking the classes that use it (the client), and the classes (the client) can switch between behaviors by changing the specific implementation used without requiring any significant code changed</u>.

<br>

## Benefit

* <u>Eliminates large number of conditional statements</u> (by delegating the specific behavior to the `Strategy` interface)

* Provides an <u>alternative to sub-classing the `Context` class to get a variety of algorithms or behaviors</u>.

* Deferring the decision about which algorithm to use until runtime allows the <u>calling code (the client code) to be more flexible and reusable</u>.

  => We can easily add or remove specific behaviors without having to change the client code.

<br>

## Drawback

It <u>increases the number of classes</u> in the code.

