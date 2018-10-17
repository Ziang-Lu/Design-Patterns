# Visitor Pattern (访问者模式)

## Applicability

* <u>When you have distinct and unrelated operations to perform across an object structure</u>

<br>

### Definition & Explanation

Visitor Pattern is a **behavioral pattern** that **separates an algorithm (an operation) from the object structure it operates on, and the executing algorithm (operation) is encapsulated in a visitor object**. <u>The elements in the object structure has to accept the visitor object, and let the visitor object perform the algorithm (handle the operation) on them.</u>

=> In this way, we can <u>change the executing algorithm (operation) on each element in the object structure</u> by simply <u>varying the visitor object</u>, without needing to modify the object structure itself.

* `Element/Visitable`
  * Represents an element in the object structure
  * <u>Can be visited by a `Visitor`, so that the `Visitor` can perform algorithm (handle operation) on this `Element`</u>
* `Visitor`
  * <u>Encapsulates the executing algorithm (operation) on elements in the object structures</u>
  * <u>Can visit each `Element` in the object structure, and perform desired algorithm (handle operation) on that `Element`</u>

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/2-Visitor%20Pattern/visitor_pattern.png?raw=true" width="500px">

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/2-Visitor%20Pattern/visitor_pattern_sequence_diagram.png?raw=true" width="500px">

<br>

## Benefit

* <u>Gains ability to modify operations and add new operations to existing object structure without modifying the object structure itself</u>

