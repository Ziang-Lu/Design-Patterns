# Strategy Pattern (策略模式)

### Applicability

* When there are <u>different variants of an algorithm</u>
* => When there are related classes that differ only in their behaviors

<br>

### Definition & Explanation

Strategy Pattern is a **behavioral pattern** that **provide multiple algorithms, a family of alrogithms, to perform a specific task (solve a specific problem), so that the client can select which actual implementation to use at runtime**.

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/1-Strategy%20Pattern/strategy_pattern_concept.png?raw=true" width="600px">

*The <u>client will decide</u> whether to use Solution A, Solution B or Solution C to finish the task <u>at runtime</u>.*

* `Context` is the interface to the outside world.
* `Algorithm (Strategy)` is the common interface for different algorithms
* `ConcreteStrategy` is an actual implementation for the algorithm.

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/1-Strategy%20Pattern/strategy_pattern.png?raw=true" width="300px">

