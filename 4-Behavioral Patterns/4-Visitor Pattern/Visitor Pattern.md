# Visitor Pattern (访问者模式)

## Applicability

* When you have distinct and unrelated operations to perform across an object structure

  *(这当然可以用inheritance实现, 但是那样的话未来如果增添、删除、修改这些operation就很困难: 需要直接修改该object structure的代码. => 违反了Open/Close Principle)*

* When new operations need to be added frequently

* When you want an object structure that adding, removing, or mainitaining operations on that objet structrure can be done without changing its code

  => When you want to avoid pollution of concrete classes with many different operations

  => You want to centralize each operation on the object structure into its own class.

<br>

### Definition & Explanation

Visitor Pattern is a **behavioral pattern** that **separates an algorithm (an operation) from the object structure it operates on, and the executing algorithm (operation) is encapsulated in a visitor object**. <u>The elements in the object structure has to accept the visitor object, and let the visitor object perform the algorithm (handle the operation) on them.</u>

=> In this way, we can <u>change the executing algorithm (operation) on each element in the object structure</u> by simply <u>varying the visitor object</u>, without needing to modify the object structure itself.

* `Element/Visitable`
  * Represents an element in the object structure
  * Can be visited by a `Visitor`, so that the `Visitor` can perform algorithm (handle operation) on this `Element`
* `Visitor`
  * Encapsulates the executing algorithm (operation) on elements in the object structures
  * Can visit each `Element` in the object structure, and perform desired algorithm (handle operation) on that `Element`

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/4-Visitor%20Pattern/visitor_pattern.png?raw=true" width="500px">

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/4-Visitor%20Pattern/visitor_pattern_sequence_diagram.png?raw=true" width="500px">

Note that the concrete elements do not have to be related through inheritance at all

***

**For the car part example:**

Before using Visitor Pattern, we have

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/4-Visitor%20Pattern/Car%20Part%20Example/class_diagram_inheritance.png?raw=true">

As we can see, the functionalities `print()`, `render()`, `upgrade()` are spread out in the element classes `Engine`, `Wheel`, `Light`, so these functionalities are hard to understand and maintain, and also hard to add new functionalities in the future because we have to enter each element class and add that functionality.

<br>

By using Visitor Pattern,

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/4-Visitor%20Pattern/Car%20Part%20Example/class_diagram_with_visitor.png?raw=true">

In this way, we can centralize a functionality to a single `ConcreteVisitor`, so that an instance of this `ConcreteVisitor` class can visit each `Element` in the object structure, and implement desired functionality on that `Element`.

***

<br>

## Benefits

* Gains ability to modify operations and add new operations to existing object structure without modifying the object structure itself

  => Avoids pollution of concrete classes with many different operations

* Visitors can visit objects that don't have a common parent class.

## Drawback

* Adding new `ConcreteElement` is difficult, since it requires adding a method in each `ConcreteVisitor`

  => The operational area of Visitor Pattern is limited to only very stable class hierarchies.

