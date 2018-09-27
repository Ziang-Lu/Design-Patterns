# Observer Pattern (观察者模式)

## Applicability

* A one-to-many dependency between objects should be defined, without making the objects tightly coupled.

  Defining a one-to-many dependency between objects by <u>defininig one object (subject) that directly updates the state of dependent objects is inflexible, because it commits the subject to particular dependent objects, and introduces tight couple</u>.

  *即: The subject has to know how to update some particular dependent object, which could implement different interfaces. => Tight couple*

* It should be ensured that <u>when one object changes state, an open-ended number of dependent objects are automatically updated</u>.

<br>

## Definition & Explanation

-> Observer Pattern is a **behaviral pattern** that is an OO solution for **interaction between one object and one or more objects**.

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/6-Observer%20Pattern/observer_pattern.png?raw=true">

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/6-Observer%20Pattern/observer_pattern_uml.png?raw=true">

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/6-Observer%20Pattern/Java_Observable_Observer.png?raw=true">

